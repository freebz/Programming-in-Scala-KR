// 리스트 12.4  여러 트레이트의 믹스인

class Animal
trait HasLegs

class Frog extends Animal with Philosophical with HasLegs {
  override def toString = "green"
}




class Animal

class Frog extends Animal with Philosophical {
  override def toString = "green"
  override def philosophize() {
    println("It ain't easy being "+ toString +"!")
  }
}

val phrog: Philosophical = new Frog
phrog.philosophize()


class Point(x: Int, y: Int)
trait NoPoint(x: Int, y: Int)  // 컴파일할 수 없다.


// 12.2 간결한 인터페이스와 풍부한 인터페이스

trait CharSequence {
  def charAt(index: Int): Char
  def length: Int
  def subSequence(start: Int, end: Int): CharSequence
  def toString(): String
}


// 12.3 예제: 직사각형 객체

class Point(val x: Int, val y: Int)

class Rectangle(val topLeft: Point, val bottomRight: Point) {
  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // 여러 기하 관련 메소드...
}

abstract class Component {
  def topLeft: Point
  def bottomRight: Point

  def left = topLeft.x
  def right = bottomRight.x
  def width = right - left
  // 여러 기하 관련 메소드...
}
