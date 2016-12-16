// 리스트 30.3  이진 트리 계층구조

trait Tree[+T] {
  def elem: T
  def left: Tree[T]
  def right: Tree[T]
}

object EmptyTree extends Tree[Nothing] {
  def elem =
    throw new NoSuchElementException("EmptyTree.elem")
  def left =
    throw new NoSuchElementException("EmptyTree.left")
  def right =
    throw new NoSuchElementException("EmptyTree.right")
}

class Branch[+T](
  val elem: T,
  val left: Tree[T],
  val right: Tree[T]
) extends Tree[T]



// 30.3 파라미터화한 타입의 동일성 정의

class Branch[+T](
  val elem: T,
  val left: Tree[T],
  val right: Tree[T]
) extends Tree[T] {
  override def equals(other: Any) = other match {
    case that: Branch[T] => this.elem == that.elem &&
      this.left == that.left &&
      this.right == that.right
    case _ => false
  }
}

val b1 = new Branch[List[String]](Nil,
  EmptyTree, EmptyTree)
val b2 = new Branch[List[Int]](Nil,
  EmptyTree, EmptyTree)
b1 == b2

