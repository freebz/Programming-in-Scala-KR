// 리스트 15.12  isInstanceOf와 asInstanceOf 사용(좋지 않은 스타일)

if (x.isInstanceOf[String]) {
  val s = x.asInstanceOf[String]
  s.length
} else ...



// 타입 소거

def isIntIntMap(x: Any) = x match {
  case m: Map[Int, Int] => true
  case _ => false
}

isIntIntMap(Map(1 -> 1))
isIntIntMap(Map("abc" -> "abc"))


def isStringArray(x: Any) = x match {
  case a: Array[String] => "yes"
  case _ => "no"
}

val as = Array("abc")
isStringArray(as)
val ai = Array(1, 2, 3)
isStringArray(ai)
