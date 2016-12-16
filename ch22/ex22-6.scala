// 리스트 22.6  List의 서브클래스인 :: 클래스 정의

final case class ::[U](hd: U,
  private[scala] var tl: List[U]) extends List[U] {

  def head = hd
  def tail = tl
  override def isEmpty: Boolean = false
}
