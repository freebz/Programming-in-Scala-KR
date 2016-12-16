// 리스트 19.8  Function1의 반공변성과 공변성

trait Function1[-S, +T] {
  def apply(x: S): T
}
