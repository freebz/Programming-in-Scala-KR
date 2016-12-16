// 리스트 6.4  연산자 메소드를 추가한 Rational 클래스

class Rational(n: Int, d: Int) {

  require(d != 0)

  private val g = gcd(n.abs, d.abs)

  val numer: Int = n / g
  val denom: Int = d / g

  def this(n: Int) = this(n, 1)  // 보조 생성자

  def + (that: Rational): Rational =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def * (that: Rational): Rational =
    new Rational(numer * that.numer, denom * that.denom)

  override def toString = numer +"/"+ denom

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
}


// 6.9 연산자 정의

val x = new Rational(1, 2)
val y = new Rational(2, 3)
x + y

x.+(y)

x + x * y
(x + x) * y
x + (x * y)
