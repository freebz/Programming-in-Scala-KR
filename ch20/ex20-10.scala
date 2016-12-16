// 리스트 20.10  서브클래스에서의 추상 타입 구현

class Grass extends Food
class Cow extends Animal {
  type SuitableFood = Grass
  override def eat(food: SuitableFood) {}
}



class Fish extends Food
val bessy: Animal = new Cow
bessy eat (new Fish)


// 20.7 경로에 의존하는 타입

class DogFood extends Food
class Dog extends Animal {
  type SuitableFood = DogFood
  override def eat(food: DogFood) {}
}

val bessy = new Cow
val lassie = new Dog
lassie eat (new bessy.SuitableFood)

val bootsie = new Dog
lassie eat (new bootsie.SuitableFood)


class  Outer {
  class Inner
}

val o1 = new Outer
val o2 = new Outer

new o1.Inner
new Outer#Inner


// 20.8 구조적 서브타이핑

Animal { type SuitableFood = Grass }

class Pasture {
  var animals: List[Animal { type SuitableFood = Grass }] = Nil
  // ...
}


def using[T, S](obj: T)(operation: T => S) = {
  val result = operation(obj)
  obj.close()      // 타입 오류!
  result
}

def using[T <: { def close(): Unit }, S](obj: T)(operation: T => S) = {
  val result = operation(obj)
  obj.close()
  result
}

using(new PrintWriter("date.txt")) { writer =>
  writer.println(new Date)
}

using(serverSocket.accept()) { socket =>
  socket.getOutputStream().write("hello, world\n".getBytes)
}


// 20.9 열거형

object Color extends Enumeration {
  val Red = Value
  val Green = Value
  val Blue = Value
}

object Color extends Enumeration {
  val Red, Green, Blue = Value
}

import Color._

object Direction extends Enumeration {
  val North, East, South, West = Value
}

object Direction extends Enumeration {
  val North = Value("North")
  val East = Value("East")
  val South = Value("South")
  val West = Value("West")
}

for (d <- Direction.values) print(d +" ")

Direction.East.id

Direction(1)


// 20.10 사례 연구: 통화 변환

// 처음으로 (잘못) 설계한 통화 클래스
abstract class Currency {
  val amount: Long
  def designation: String
  override def toString = amount +" "+ designation
  def + (that: Currency): Currency = ??? // ...
  def * (x: Double): Currency = ??? // ...
}

new Currency {
  val amount = 79L
  def designation = "USD"
}

abstract class Dollar extends Currency {
  def designation = "USD"
}
abstract class Euro extends Currency {
  def designation = "Euro"
}

// 두 번째 (여전히 완전하지는 않은) Currency 클래스 설계
abstract class AbstractCurrency {
  type Currency <: AbstractCurrency

  val amount: Long
  def designation: String
  override def toString = amount +" "+ designation
  def + (that: Currency): Currency = ???  // ...
  def * (x: Double): Currency = ???  // ...
}

abstract class Dollar extends AbstractCurrency {
  type Currency = Dollar
  def designation = "USD"
}

abstract class CurrencyZone {
  type Currency <: AbstractCurrency
  def make(x: Long): Currency

  abstract class AbstractCurrency {
    val amount: Long
    def designation: String
    override def toString = amount +" "+ designation
    def + (that: Currency): Currency =
      make(this.amount + that.amount)
    def * (x: Double): Currency =
      make((this.amount * x).toLong)
  }
}

object US extends CurrencyZone {
  abstract class Dollar extends AbstractCurrency {
    def designation = "USD"
  }
  type Currency = Dollar
  def make(x: Long) = new Dollar { val amount = x }
}
