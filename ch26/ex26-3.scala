// 리스트 26.3  UpperCase 문자열 익스트랙터 객체

object UpperCase {
  def unapply(s: String): Boolean = s.toUpperCase == s
}



// 26장 익스트랙터

// 26.3 변수가 없거나 1개만 있는 패턴

def userTwiceUpper(s: String) = s match {
  case EMail(Twice(x @ UpperCase()), domain) =>
    "match: "+ x +" in domain "+ domain
  case _ =>
    "no match"
}

userTwiceUpper("DIDI@hotmail.com")
userTwiceUpper("DIDO@hotmail.com")
userTwiceUpper("didi@hotmail.com")
