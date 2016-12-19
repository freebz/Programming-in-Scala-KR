// 리스트 33.1  산술식 파서

import scala.util.parsing.combinator._

class Arith extends JavaTokenParsers {
  def expr: Parser[Any] = term~rep("+"~term | "-"~term)
  def term: Parser[Any] = factor~rep("*"~factor | "/"~factor)
  def factor: Parser[Any] = floatingPointNumber | "("~expr~")"
}


// 33장 콤비네이터 파싱

// 33.2 파서 실행

object ParseExpr extends Arith {
  def main(args: Array[String]) {
    println("input : "+ args(0))
    println(parseAll(expr, args(0)))
  }
}

ParseExpr.main(Array("2 * (3 + 7)"))
ParseExpr.main(Array("2 * (3 + 7))"))
