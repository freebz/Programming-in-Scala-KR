// 리스트 8.1  비공개 processLine 메소드가 들어 있는 LongLines

import scala.io.Source

object LongLines {

  def processFile(filename: String, width: Int) {
    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(filename, width, line)
  }

  private def processLine(filename: String,
    width: Int, line: String) {

    if (line.length > width)
      println(filename +": "+ line.trim)
  }
}



// 8장 함수와 클로저

// 8.1 메소드

object FindLongLines {
  def main(args: Array[String]) {
    val width = args(0).toInt
    for (arg <- args.drop(1))
      LongLines.processFile(arg, width)
  }
}
