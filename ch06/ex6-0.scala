// 6장 함수형 객체

// 6.2 Rational 생성

class Rational(n: Int, d: Int)

class Rational(n: Int, d: Int) {
  println("Created "+ n +"/"+ d)
}

new Rational(1, 2)


// 6.3 toString 메소드 다시 구현하기

class Rational(n: Int, d: Int) {
  override def toString = n +"/" + d
}

val x = new Rational(1, 3)
val y = new Rational(5, 7)


// 6.4 전제 조건 확인

new Rational(5, 0)

class Rational(n: Int, d: Int) {
  require(d != 0)
  override def toString = n +"/" + d
}

new Rational(5, 0)


// 6.5 필드 추가

class Rational(n: Int, d: Int) {
  require(d != 0)
  override def toString = n +"/" + d
  def add(that: Rational): Rational =
    new Rational(n * that.d + that.n * d, d * that.d)
}
