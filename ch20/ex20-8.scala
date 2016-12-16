// 리스트 20.8  트레이트를 지연 val로 초기화하기

trait LazyRationalTrait {
  val numerArg: Int
  val denomArg: Int
  lazy val numer = numerArg / g
  lazy val denom = denomArg / g
  override def toString = numer +"/"+ denom
  private lazy val g = {
    require(denomArg != 0)
    gcd(numerArg, denomArg)
  }
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}



val x = 2
new LazyRationalTrait {
  val numerArg = 1 * x
  val denomArg = 2 * x
}


// 20.6 추상 타입

class Food
abstract class Animal {
  def eat(food: Food)
}

class Grass extends Food
class Cow extends Animal {
  override def eat(food: Grass) {}  // 컴파일할 수 없음
}


class Food
abstract class Animal {
  def eat(food: Food)
}
class Grass extends Food
class Cow extends Animal {
  override def eat(food: Grass) {}  // 컴파일할 수 없다.
                                    // 하지만, 만약 컴파일할 수 있다면...
}
class Fish extends Food
val bessy: Animal = new Cow
bessy eat (new Fish)  // ... 물고기를 소이게 먹일 수 있었을 것이다.
x
