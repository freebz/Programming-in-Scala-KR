// 21장 암시적 변환과 암시적 파라미터

// 21.1 암시적 변환

val button = new JButton
button.addActionListener(
  new ActionListener {
    def actionPerformed(event: ActionEvent) {
      println("pressed!")
    }
  }
)

button.addActionListener(  // 타입 불일치!
  (_: ActionEvent) => println("pressed!")
}

implicit def function2ActionListener(f: ActionEvent => Unit) =
  new ActionListener {
    def actionPerformed(event: ActionEvent) = f(event)
  }

button.addActionListener(
  function2ActionListener(
    (_: ActionEvent) => println("pressed!")
  )
)

// 이제 작동한다.
button.addActionListener(
  (_: ActionEvent) => println("pressed!")
}


// 21.2 암시 규칙

// 표시 규칙: implicit로 표시한 정의만 검토 대상이다

implicit def intToString(x: Int) = x.toString

// 스코프 규칙: 삽입할 implicit 변환은 스코프 내에 단일 식별자로만 존재하거나,
// 변환의 결과나 원래 타입과 연관이 있어야 한다

object Dollar {
  implicit def dollarToEuro(x: Dollar): Euro = ???  // ...
}
class Dollar { }

// 한 번에 하나만 규칙: 오직 하나의 암시적 선언만 사용한다

// 명시적 우선 규칙: 코드가 그 상태 그대로 타입 검사를 통과한다면 암시를 통한 변환을 시도하지 않는다

// 암시적 변환 이름 붙이기

object MyConversions {
  implicit def stringWrapper(s: String):
      IndexedSeq[Char] = ???
  implicit def intToString(x: Int): String = ???
}

import MyConversions.stringWrapper
// stringWrapper를 (암시적으로) 사용하는 코드


// 21.3 예상 타입으로의 암시적 변환

val i: Int = 3.5

implicit def doubleToInt(x: Double) = x.toInt
val i: Int = 3.5

implicit def int2double(x: Int): Double = x.toDouble


// 21.4 호출 대상 객체 변환

// 새 타입과 함께 통합하기

class Rational(n: Int, d: Int) {
  // ...
  def + (that: Rational): Rational = ???
  def + (that: Int): Rational = ???
}

val oneHalf = new Rational(1, 2)
oneHalf + oneHalf
oneHalf + 1

1 + oneHalf

implicit def intToRational(x: Int) =
  new Rational(x, 1)

1 + oneHalf
intToRational(1) + oneHalf

// 새로운 문법 흉내 내기

Map(1 -> "one", 2 -> "two", 3 -> "three")

package scala
object Predef {
  class ArrowAssoc[A](x: A) {
    def -> [B](y: B): Tuple2[A, B] = Tuple2(x, y)
  }
  implicit def any2ArrowAssoc[A](x: A): ArrowAssoc[A] =
    new ArrowAssoc(x)
  // ...
}


// 21.5 암시적 파라미터

class PreferredPrompt(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt) {
    println("Welcome, "+ name +". The system is ready.")
    println(prompt.preference)
  }
}

val bobsPrompt = new PreferredPrompt("relax> ")
Greeter.greet("Bob")(bobsPrompt)

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
}

Greeter.greet("Joe")

import JoesPrefs._
Greeter.greet("Joe")
