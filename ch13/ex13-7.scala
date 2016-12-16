// 리스트 13.7  임포트 준비가 된 밥의 과일 클래스들

package bobsdelights

abstract class Fruit(
  val name: String,
  val color: String
)

object Fruits {
  object Apple extends Fruit("apple", "red")
  object Orange extends Fruit("orange", "orange")
  object Pear extends Fruit("pear", "yellowish")
  val menu = List(Apple, Orange, Pear)
}



// Fruit에 간단하게 접근
import bobsdelights.Fruit

// bobsdelights의 모든 맴버에 간단하게 접근
import bobsdelights._

// Fruits의 모든 맴버에 간단하게 접근
import bobsdelights.Fruits._
