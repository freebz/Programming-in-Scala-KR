// 리스트 8.2  processLine 지역 함수를 포함하는 LongLines

import scala.io.Source

object LongLines {

  def processFile(filename: String, width: Int) {

    def processLine(line: String) {
      if (line.length > width)
        println(filename +": "+ line.trim)
    }

    val source = Source.fromFile(filename)
    for (line <- source.getLines())
      processLine(line)
  }
}



// 8.3 1급 계층 함수

var increase = (x: Int) => x + 1
increase(10)

increase = (x: Int) => x + 9999
increase(10)

increase = (x: Int) => {
  println("We")
  println("are")
  println("here!")
  x + 1
}

increase(10)


val someNumbers = List(-11, -10, -5, 0, 5, 10)
someNumbers.foreach((x: Int) => println(x))

someNumbers.filter((x: Int) => x > 0)


// 8.4 간단한 형태의 함수 리터럴

someNumbers.filter((x) => x > 0)
someNumbers.filter(x => x > 0)


// 8.5 위치 표시자 문법

someNumbers.filter(_ > 0)

val f = _ + _
val f = (_: Int) + (_: Int)
f(5, 10)


// 8.6 부분 적용한 함수

someNumbers.foreach(println _)
someNumbers.foreach(x => println(x))

def sum(a: Int, b: Int, c: Int) = a + b + c
sum(1, 2, 3)

val a = sum _
a(1, 2, 3)
a.apply(1, 2, 3)

val b = sum(1, _: Int, 3)
b(2)
b(5)

someNumbers.foreach(println)

val c = sum
val d = sum _


// 8.7 클로저

(x: Int) => x + more  // 얼마나 더 (more)일까?

var more = 1
val addMore = (x: Int) => x + more
addMore(10)

more = 9999
addMore(10)

val someNumbers = List(-11, -10, -5, 0, 5, 10)
var sum = 0
someNumbers.foreach(sum += _)
sum

def makeIncreaser(more: Int) = (x: Int) => x + more
val inc1 = makeIncreaser(1)
val inc9999 = makeIncreaser(9999)
inc1(10)
inc9999(10)


// 8.8 특별한 형태의 함수 호출

// 반복 파라미터

def echo(args: String*) =
  for (arg <- args) println(arg)

echo()
echo("one")
echo("hello", "world!")

val arr = Array("What's", "up", "doc?")
echo(arr)
echo(arr: _*)


// 이름 붙인 인자

def speed(distance: Float, time: Float): Float =
  distance / time

speed(100, 10)
speed(distance = 100, time = 10)
speed(time = 10, distance = 100)
