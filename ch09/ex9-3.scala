// 리스트 9.3  커링한 함수의 정의 및 호출

def curriedSum(x: Int)(y: Int) = x + y
curriedSum(1)(2)


// 9.3 커링

def first(x: Int) = (y: Int) => x + y
val second = first(1)
second(2)

val onePlus = curriedSum(1)_
onePlus(2)

val twoPlus = curriedSum(2)_
twoPlus(2)


// 9.4 새로운 제어 구조 작성

def twice(op: Double => Double, x: Double) = op(op(x))
twice(_ + 1, 5)

def withPrintWriter(file: File, op: PrintWriter => Unit) {
  val writer = new PrintWriter(file)
  try {
    op(writer)
  } finally {
    writer.close()
  }
}

withPrintWriter(
  new File("date.txt"),
  writer => writer.println(new java.util.Date)
)

println("Hello, world!")
println { "Hello, world!" }

val g = "Hello, world!"
g.substring { 7, 9 }
g.substring(7, 9)
