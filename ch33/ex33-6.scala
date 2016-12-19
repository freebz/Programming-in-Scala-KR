// 리스트 33.6  ~ 콤비네이터 메소드

abstract class Parser[+T] ... { p =>
  ...
  def ~ [U](q: => Parser[U]) = new Parser[T~U] {
    def apply(in: Input) = p(in) match {
      case Success(x, in1) =>
        q(in1) match {
          case Success(y, in2) => Success(new ~(x, y), in2)
          case failure => failure
        }
      case failure => failure
    }
  }

  // 순차 합성

  def <~ [U](q: => Parser[U]): Parser[T] =
    (p~q) ^^ { case x~y => x}
  def ~> [U](q: => Parser[U]): Parser[U] =
    (p~q) ^^ { case x~y => y}


  // 대안 합성

  def | [U >: T](q: => Parser[U]) = new Parser[U] {
    def apply(in: Input) = p(in) match {
      case s1 @ Success(_, _) => s1
      case failure => q(in)
    }
  }


  // 재귀 다루기

  def parens = floatingPointNumber | "("~parens~")"


  // 결과 변환

  def ^^ [U](f: T => U): Parser[U] = new Parser[U] {
    def apply(in: Input) = p(in) match {
      case Success(x, in1) => Success(f(x), in1)
      case failure => failure
    }
  }
} // Parser의 끝


// 어떤 입력도 읽지 않는 파서

def success[T](v: T) = new Parser[T] {
  def apply(in: Input) = Success(v, in)
}
def failure(msg: String) = new Parser[Nothing] {
  def apply(in: Input) = Failure(msg, in)
}


// 선택적 합성과 반복 합성

def opt[T](p: => Parser[T]): Parser[Option[T]] = (
  p ^^ Some(_)
    | success(None)
)

def rep[T](p: => Parser[T]): Parser[List[T]] = (
  p~rep(p) ^^ { case x~xs => x :: xs }
    | success(List())
)

def repsep[T](p: => Parser[T],
  q: => Parser[Any]): Parser[List[T]] = (
  p~rep(q~> p) ^^ { case r~rs => r :: rs }
    | success(List())
)

} // Parser 트레이트의 끝


// 33.7 문자열 리터널과 정규 표현식

trait RegexParsers extends Parsers {
  type Elem = Char

  implicit def literal(s: String): Parser[String] = ...
  implicit def regex(r: Regex): Parser[String] = ...

  protected val whiteSpace = """\s+""".r
} // RegexParsers의 끝

object MyParsers extends REgexParsers {
  override val whiteSpace = "".r
  ...
}


// 33.8 어휘 분석과 파싱

scala.util.parsing.combinator.lexical
scala.util.parsing.combinator.syntactical


// 33.9 오류 보고

def value: Parser[Any] =
  obj | arr | stringLit | floatingPointNumber | "null" |
    "true" | "false" | failure("illegal start of value")

var lastFailure: Option[Failure] = None

case class Failure(msg: String, in: Input)
    extends ParseResult[Nothing] {
  if (lastFailure.isDefined &&
      lastFailure.get.in.pos <= in.pos)
    lastFailure = Some(this)
}

def phrase[T](p: Parser[T]) = new Parser[T] {
  lastFailure = None
  def apply(in: Input) = p(in) match {
    case s @ Success(out, in1) =>
      if (in1.atEnd) s
      else Failure("end of input expected", in1)
    case f : Failure =>
      lastFailure
  }
}


// 33.10 백트래킹과 LL(1)

def expr : Parser[Any] =
  term ~! rep("+" ~! term | "-" ~! term)

def term : Parser[Any] =
  factor ~! rep("*" ~! factor | "/" ~! factor)

def factor: Parser[Any] =
  "(" ~! expr ~! ")" | floatingPointNumber
