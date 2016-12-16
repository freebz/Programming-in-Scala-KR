// 리스트 10.4  파라미터 없는 메소드를 필드로 오버라이드하기

class ArrayElement(conts: Array[String]) extends Element {
  val contents: Array[String] = conts
}
