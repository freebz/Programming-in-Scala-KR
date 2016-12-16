// 리스트 4.3  Summer 애플리케이션

// Summer.scala에 저장
import ChecksumAccumulator.calculate

object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg +": "+ calculate(arg))
  }
}
