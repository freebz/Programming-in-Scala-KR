// 11장 스칼라의 계층구조

// 11.1 스칼라의 클래스 계층구조

new Int

42.toString
42.hashCode
42 equals 42

42 max 43
42 min 43
1 until 5
1 to 5
3.abs
  (-3).abs


// 11.2 여러 기본 클래스를 어떻게 구현했는가?

def isEqual(x: Int, y: Int) = x == y
isEqual(421, 421)
def isEqual(x: Any, y: Any) = x == y
isEqual(421, 421)

val x = "abcd".substring(2)
val y = "abcd".substring(2)
x == y

val x = new String("abc")
val y = new String("abc")
x == y
x eq y
x ne y


// 11.3 바닥에 있는 타입

val i: Int = null

def error(message: String): Nothing =
  throw new RuntimeException(message)

def divide(x: Int, y: Int): Int = {
  if (y != 0) x / y
  else error("can't divide by zero")
}
