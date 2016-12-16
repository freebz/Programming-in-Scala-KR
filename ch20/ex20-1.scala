// 리스트 20.1  추상 val과 파라미터 없는 메소드 오버라이드 하기

abstract class Fruit {
  val v: String  // 'v'는 값을 의미
  def m: String  // 'm'은 메소드를 의미
}

abstract class Apple extends Fruit {
  val v: String
  val m: String  // 'def'를 'val'로 오버라이드 할 수 있다.
}

abstract class BadApple extends Fruit {
  def v: String  // 오류: 'val'은 'def'로 오버라이드 할 수 없다.
  def m: String
}
