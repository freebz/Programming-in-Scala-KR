// 리스트 26.1  EMail 문자열 익스트랙터 객체

object EMail {
  // 인젝션(injection) 메소드(선택적)
  def apply(user: String, domain: String) = user +"@"+ domain

  // 익스트랙터 메소드(필수)
  def unapply(str: String): Option[(String, String)] = {
    val parts = str split "@"
    if (parts.length == 2) Some(parts(0), parts(1)) else None
  }
}
