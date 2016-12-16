// 리스트 12.2  extends 키워드를 이용해 트레이트를 믹스인한 클래스

class Frog extends Philosophical {
  override def toString = "green"
}



// 12장 트레이트

// 12.1 트레이트의 동작 원리

val frog = new Frog
frog.philosophize()

val phil: Philosophical = frog
phil.philosophize()
