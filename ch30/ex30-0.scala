// 30장 객체의 동일성

// 30.2 동일성 비교 메소드 작성

// 함정 #1: equlas 선언 시 잘몯쇤 시그니처를 사용하는 경우

class Point(val x: Int, val y: Int) {

  // 잘못된 equals 정의
  def equals(other: Point): Boolean =
    this.x == other.x && this.y == other.y
}

val p1, p2 = new Point(1, 2)
val q = new Point(2, 3)
p1 equals p2
p1 equals q

import scala.collection.mutable._
val coll = HashSet(p1)
coll contains p2

val p2a: Any = p2
p1 equals p2a

class Point(val x: Int, val y: Int) {

  // 더 나은 정의. 하지만 여전히 완전하지는 않다.
  override def equals(other: Any) = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }
}

// def ==(other: Point): Boolean = // 이러면 안 된다!


// 함정 #2: equals를 변경하면서 hashCode는 그대로 놔둔 경우

val p1, p2 = new Point(1, 2)
HashSet(p1) contains p2

class Point(val x: Int, val y: Int) {
  override def hashCode = 41 * (41 + x) + y
  override def equals(other: Any) = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }
}


// 함정 #3: equals를 변경 가능한 필드의 값을 기준으로 정의한 경우

class Point(var x: Int, var y: Int) {  // 문제가 있음
  override def hashCode = 41 * (41 + x) + y
  override def equals(other: Any) = other match {
    case that: Point => this.x == that.x && this.y == that.y
    case _ => false
  }
}

val p = new Point(1, 2)
val coll = HashSet(p)
coll contains p

p.x += 1
coll contains p
coll.iterator contains p


// 함정 #4: equals를 동치 관계로 정의하지 않는 경우

object Color extends Enumeration {
  val Red, Orange, Yellow, Green, Blue, Indigo, Violet = Value
}

class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends
    Point(x, y) {  // 문제가 있음. 대칭성이 성립하지 않음

  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      this.color == that.color && super.equals(that)
    case _ => false
  }
}

val p = new Point(1, 2)
val cp = new ColoredPoint(1, 2, Color.Red)
p equals cp
cp equals p

HashSet[Point](p) contains cp
HashSet[Point](cp) contains p

class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends
    Point(x, y) {  // 문제가 있음. 추이성이 성립하지 않음

  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (this.color == that.color) && super.equals(that)
    case that: Point =>
      that equals this
    case _ =>
      false
  }
}

val redp = new ColoredPoint(1, 2, Color.Red)
val bluep = new ColoredPoint(1, 2, Color.Blue)
redp == p
p == bluep
redp == bluep

// 기술적으로는 맞지만 만족할 수는 없는 equals 메소드
class Point(val x: Int, val y: Int) {
  override def hashCode = 41 * (41 + x) + y
  override def equals(other: Any) = other match {
    case that: Point =>
      this.x == that.x && this.y == that.y &&
      this.getClass == that.getClass
    case _ => false
  }
}

class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends
    Point(x, y) {

  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (this.color == that.color) && super.equals(that)
    case _ => false
  }
}

val pAnon = new Point(1, 1) { override val y = 2 }
