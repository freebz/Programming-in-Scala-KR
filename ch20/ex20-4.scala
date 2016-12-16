// 리스트 20.4  추상 val을 사용하는 트레이트

trait RationalTrait {
  val numerArg: Int
  val denomArg: Int
  require(denomArg != 0)
  private val g = gcd(numerArg, denomArg)
  val numer = numerArg / g
  val denom = denomArg / g
  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)
  override def toString = numer +"/"+ denom
}


val x = 2
new RationalTrait {
  val numerArg = 1 * x
  val denomArg = 2 * x
}
