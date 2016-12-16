// 리스트 22.1  Nil 싱글톤 객체 정의

case object Nil extends List[Nothing] {
  override def isEmpty = true
  override def head: Nothing =
    throw new NoSuchElementException("head of empty list")
  override def tail: List[Nothing] =
    throw new NoSuchElementException("tail of empty list")
}


// :: 클래스

final case class ::[T](hd: T, tl: List[T]) extends List[T] {
  def head = hd
  def tail = tl
  override def isEmpty: Boolean = false
}

final case class ::[T](head: T, tail: List[T]) extends List[T] {
  override def isEmpty: Boolean = false
}


// 추가 메소드

def length: Int =
  if (isEmpty) 0 else 1 + tail.length

def drop(n: Int): List[T] =
  if (isEmpty) Nil
  else if (n <= 0) this
  else tail.drop(n - 1)

def map[U](f: T => U): List[U] =
  if (isEmpty) Nil
  else f(head) :: tail.map(f)


// 리스트 구성

abstract class Fruit
class Apple extends Fruit
class Orange extends Fruit
