// 리스트 33.2  자바 식별자를 위한 정규 표현식 파서

object MyParsers extends RegexParsers {
  val ident: Parser[String] = """[a-zA-Z_]\w*""".r
}
