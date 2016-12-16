// 리스트 22.4  List 클래스의 ::: 메소드 정의

def :::[U >: T](prefix: List[U]): List[U] =
  if (prefix.isEmpty) this
  else prefix.head :: prefix.tail ::: this



// 22.2 ListBuffer 클래스

def incAll(xs: List[Int]): List[Int] = xs match {
  case List() => List()
  case x :: xs1 => x + 1 :: incAll(xs1)
}

var result = List[Int]()            // 아주 비효율적인 접근 방법
for (x <- xs) result = result ::: List(x + 1)
result

import scala.collection.mutable.ListBuffer

val buf = new ListBuffer[Int]
for (x <- xs) buf += x + 1
buf.toList
