// 리스트 26.7  StringOps 안에 있는 r 메소드 정의

package scala.runtime
import scala.util.matching.Regex

class StringOps(self: String) ... {
  // ...
  def r = new Regex(self)
}



// 정규 표현식 검색

val Decimal = """(-)?(\d+)(\.\d*)?""".r

val input = "for -1.0 to 99 by 3"
for (s <- Decimal findAllIn input)
  println(s)

Decimal findFirstIn input
Decimal findPrefixOf input


// 정규 표현식 뽑아내기

val Decimal(sign, integerpart, decimalpart) = "-1.23"
val Decimal(sign, integerpart, decimalpart) = "1.0"

for (Decimal(s, i, d) <- Decimal findAllIn input)
  println("sign: "+ s +", integer: "+
    i +", decimal: "+ d)
