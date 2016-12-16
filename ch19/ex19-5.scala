// 리스트 19.5  무공변성(융통성이 없는) Cell 클래스

class Cell[T](init: T) {
  private[this] var current = init
  def get = current
  def set(x: T) { current = x }
}



val c1 = new Cell[String]("abc")
val c2: Cell[Any] = c1
c2.set(1)


// 변성과 배열

// 자바 코드
String[] a1 = { "abc" };
Object[] a2 = a1;
a2[0] = new Integer(17);
String s = a1[0];

val a1 = Array("abc")
val a2: Array[Any] = a1

val a2: Array[Object] =
  a1.asInstanceOf[Array[Object]]


// 19.4 변성 표기 검사

class StrangeIntQueue extends Queue[Int] {
  override def enqueue(x: Int) = {
    println(math.sqrt(x))
    super.enqueue(x)
  }
}

val x: Queue[Any] = new StrangeIntQueue
x.enqueue("abc")
