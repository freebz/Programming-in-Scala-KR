// 리스트 25.3  TraversableLike의 map 구현

def map[B, That](p: Elem => B)
    (implicit bf: CanBuildFrom[This, B, That]): That = {
  val b = bf(this)
  for (x <- this) b += f(x)
  b.result
}
