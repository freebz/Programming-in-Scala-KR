// 리스트 33.4  간단한 JSON 파서

import scala.util.parsing.combinator._

class JSON extends JavaTokenParsers {

  def value : Parser[Any] = obj | arr |
                            stringLiteral |
                            floatingPointNumber |
                            "null" | "true" | "false"

  def obj   : Parser[Any] = "{"~repsep(member, ",")~"}"

  def arr   : Parser[Any] = "["~repsep(value, ",")~"]"

  def member: Parser[Any] = stringLiteral~":"~value
}


// 33.4 또 다른 예제: JSON

import java.io.FileReader

object ParseJSON extends JSON {
  def main(args: Array[String]) {
    val reader = new FileReader(args(0))
    println(parseAll(value, reader))
  }
}


ParseJSON.main(Array("address-book.json"))


// 33.5 파서의 결과

floatingPointNumber ^^ (_.toDouble)

"true" ^^ (x => true)

def obj: Parser[Map[String, Any]] = // 더 개설할 여지가 있다.
  "{"~repsep(member, ",")~"}" ^^
    { case "{"~ms~"}" => Map() ++ ms}

case class ~[+A, +B](x: A, y: B) {
  override def toString = "("+ x "~"+ y +")"
}

def obj: Parser[Map[String, Any]] =
  "{"~> repsep(member, ",") <~"}" ^^ (Map() ++ _)
