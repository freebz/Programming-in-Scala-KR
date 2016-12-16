// 2장 스칼라 첫걸음

// 1단계: 스칼라 인터프리터 사용법을 익히자

1 + 2

res0 * 3

println("Hello, world!")


// 2단계: 변수를 정의해보자

val msg = "Hello, world!"
val msg2: java.lang.String = "Hello again, world!"
val msg3: String = "Hello yet again, world!"

print(msg)

msg = "Goodbye cruel world!"

var greeting = "Hello, world!"
greeting = "Leave me alone, world!"

val multiLine =
  "This is the next line."


// 3단계: 함수를 정의해보자

def max(x: Int, y: Int): Int = {
  if (x > y) x
  else y
}

def max2(x: Int, y: Int) = if (x > y) x else y

max(3, 5)

def greet() = println("Hello, world!")
