// 리스트 10.2  파라미터 없는 메소드 width와 height 정의

abstract class Element {
  def contents: Array[String]
  def height: Int = contents.length
  def width: Int = if (height == 0) 0 else contents(0).length
}
