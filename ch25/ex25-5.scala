// 리스트 25.5  RNA 염기들

abstract class Base
case object A extends Base
case object C extends Base
case object G extends Base
case object U extends Base

object Base {
  val fromInt: Int => Base = Array(A, C, G, U)
  val toInt: Base => Int = Map(A -> 0, C -> 1, G -> 2, U -> 3)
}
