// 리스트 30.4  equals와 hashCode가 있는 파라미터화된 타입

class Branch[+T](
  val elem: T,
  val left: Tree[T],
  val right: Tree[T]
) extends Tree[T] {

  override def equals(other: Any) = other match {
    case that: Branch[_] => (that canEqual this) &&
      this.elem == that.elem &&
      this.left == that.left &&
      this.right == that.right
    case _ => false
  }

  def canEqual(other: Any) = other.isInstanceOf[Branch[_]]

  override def hashCode: Int =
    41 * (
      41 * (
        41 + elem.hashCode
      ) + left.hashCode
    ) + right.hashCode
}
