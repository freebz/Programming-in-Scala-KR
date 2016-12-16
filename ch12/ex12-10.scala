// 리스트 12.10  쌓을 수 있는 변경 트레이트 Incrementing, Filtering

trait Incrementing extends IntQueue {
  abstract override def put(x: Int) { super.put(x + 1) }
}

trait Filtering extends IntQueue {
  abstract override def put(x: Int) {
    if (x >= 0) super.put(x)
  }
}



val queue = (new BasicIntQueue
    with Incrementing with Filtering)
queue.put(-1); queue.put(0); queue.put(1)
queue.get()
queue.get()

val queue = (new BasicIntQueue
    with Filtering with Incrementing)
queue.put(-1); queue.put(0); queue.put(1)
queue.get()
queue.get()
queue.get()


// 12.6 왜 다중 상속은 안 되는가?

class Animal
trait Furry extends Animal
trait HasLeg extends Animal
trait FourLegged extends HasLegs
class Cat extends Animal with Furry with FourLegged
