// 리스트 33.5  의미 있는 결과를 반환하는 완전한 JSON 파서

import scala.util.parsing.combinator._

class JSON1 extends JavaTokenParsers {

  def obj: Parser[Map[String, Any]] =
    "{"~> repsep(member, ",") <~"}" ^^ (Map() ++ _)

  def arr: Parser[List[Any]] =
    "["~> repsep(value, ",") <~"]"

  def member: Parser[(String, Any)] =
    stringLiteral~":"~value ^^
      { case name~":"~value => (name, value) }

  def value: Parser[Any] = (
        obj
      | arr
      | stringLiteral
      | floatingPointNumber ^^ (_.toDouble)
      | "null"  ^^ (x => null)
      | "true"  ^^ (x => true)
      | "false" ^^ (x => false)
  )
}


// 33.6 콤비네이터 파서 구현

package scala.util.parsing,combinator
trait Parsers {
  ... // 따로 언급하지 않으면 코드는 이 안에 들어 있다.
}

type Parser[T] = Input => ParseResult[T]


// 파서 입력

type Input = Reader[Elem]

Type Elem


// 파서의 결과

sealed abstract class ParseResult[+T]
case class Success[T](result: T, in: Input)
    extends ParseResult[T]
case class Failure(msg: String, in: Input)
    extends ParseResult[Nothing]


// Parser 클래스

abstract class Parser[+T] extends (Input => ParseResult[T])
{ p =>
  // 이 파서의 동작을 지정하는 메소드들
  def apply(in: Input): ParseResult[T]
  def ~ ...
  def ~ ...
  ...
}


// this 별명

abstract class Parser[+T] extends ... { p =>
}

class Outer { outer =>
  class Inner {
    println(Outer.this eq outer) // true를 출력할 것이다.
  }
}


// 단일 토큰 파서

def elem(kind: String, p: Elem => Boolean) =
  new Parser[Elem] {
    def apply(in: Input) =
      if (p(in.first)) Success(in.first, in.rest)
      else Failure(kind +" expected", in)
  }
}
