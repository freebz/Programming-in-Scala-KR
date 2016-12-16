// 리스트 20.7  클래스 정의에서 필드를 미리 초기화하기

class RationalClass(n: Int, d: Int) extends {
  val numerArg = n
  val denomArg = d
} with RationalTrait {
  def + (that: RationalClass) = new RationalClass(
    numer * that.denom + that.numer * denom,
    denom * that.denom
  )
}


// 필드를 미리 초기화하기

new {
  val numerArg = 1
  val denomArg = this.numerArg * 2
} with RationalTrait


// 지연 계산 val 변수

object Demo {
  val x = { println("initializing x"); "done" }
}

Demo
Demo.x

object Demo {
  lazy val x = { println("initializing x"); "done" }
}

Demo
Demo.x
