// 리스트 9.4  빌려주기 패턴을 사용해 파일 쓰기

def withPrintWriter(file: File)(op: PrintWriter => Unit) {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}


val file = new File("date.txt")

withPrintWriter(file) {
  writer => writer.println(new java.util.Date)
}


// 9.5 이름에 의한 호출 파라미터

var assertionEnabled = true

def myAssert(predicate: () => Boolean) =
  if (assertionEnabled && !predicate())
    throw new AssertionError

myAssert(() => 5 > 3)
myAssert(5 > 3)  // 함수 리터럴의 () => 이 없어서 작동하지 않는다.
