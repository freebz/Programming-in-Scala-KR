// 리스트 19.3  동반 객체의 apply 팩토리 메소드

object Queue {
  // 'xs'에 있는 원소로 큐를 만든다.
  def apply[T](xs: T*) = new Queue[T](xs.toList, Nil)
}
