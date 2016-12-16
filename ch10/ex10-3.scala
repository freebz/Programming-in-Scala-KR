// 리스트 10.3  Element의 서브클래스인 ArrayElement 정의

class ArrayElement(conts: Array[String]) extends Element {
  def contents: Array[String] = conts
}


// 10.4 클래스의 확장

val ae = new ArrayElement(Array("hello", "world"))
ae.width

val e: Element = new ArrayElement(Array("hello"))
