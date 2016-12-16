// 리스트 25.2  TraversableLike 안의 filter 구현

package scala.collection

class TraversableLike[+Elem, +Repr] {
  def newBuilder: Builder[Elem, Repr]  // 추후 구현
  def foreach[U](f: Elem => U)         // 추후 구현

  //  ...

  def filter(p: Elem => Boolean): Repr = {
    val b = newBuilder
    foreach { elem => if (p(elem)) b += elem }
    b.result
  }
}



// 25.2 공통 연산 한데 묶기

import collection.immutable.BitSet

val bits = BitSet(1, 2, 3)
bits map (_ * 2)
bits map (_.toFloat)

Map("a" -> 1, "b" -> 2) map { case (x, y) => (y, x) }
Map("a" -> 1, "b" -> 2) map { case (x, y) => y }
