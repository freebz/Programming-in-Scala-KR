// 리스트 7.19  함수형 방식으로 곱셈표 만들기

// 하나의 열을 시퀀스로 반환
def makeRowSeq(row: Int) =
  for (col <- 1 to 10) yield {
    val prod = (row * col).toString
    val padding = " " * (4 - prod.length)
    padding + prod
  }

// 하나의 열을 문자열로 반환
def makeRow(row: Int) = makeRowSeq(row).mkString

// 표를 한 줄에 한 열의 내용을 담고 있는 문자열로 반환
def multiTable() = {
  val tableSeq = // 한 열에 해당하는 문자열의 시퀀스
    for (row <- 1 to 10)
    yield makeRow(row)

  tableSeq.mkString("\n")
}
