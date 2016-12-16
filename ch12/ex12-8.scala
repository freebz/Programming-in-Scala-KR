// 리스트 12.8  '쌓을 수 있는 변경'을 나타내는 Doubling 트레이트

trait Doubling extends IntQueue {
  abstract override def put(x: Int) { super.put(2 * x) }
}


class MyQueue extends BasicIntQueue with Doubling
val queue = new MyQueue
queue.put(10)
queue.get()
