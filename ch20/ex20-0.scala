// 20장 추상 맴버

// 20.1 추상 멤버 간략하게 돌아보기

trait Abstract {
  type T
  def transform(x: T): T
  val initial: T
  var current: T
}

class Concrete extends Abstract {
  type T = String
  def transform(x: String) = x + x
  val initial = "hi"
  var current = initial
}


// 20.3 추상 val 변수

val initial: String
val initial = "hi"
def initial: String
