// 리스트 12.7  ArrayBuffer로 구현한 BasicIntQueue

import scala.collection.mutable.ArrayBuffer

class BasicIntQueue extends IntQueue {
  private val buf = new ArrayBuffer[Int]
  def get() = buf.remove(0)
  def put(x: Int) { buf += x }
}


// 12.5 트레이트를 이용해 변경 쌓아올리기

val queue = new BasicIntQueue
queue.put(10)
queue.put(20)
queue.get()
queue.get()
