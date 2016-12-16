// 17장 컬렉션

// 17.1 시퀀스

// 리스트

val colors = List("red", "blue", "green")
colors.head
colors.tail


// 배열

val fiveInts = new Array[Int](5)

val fiveToOne = Array(5, 4, 3, 2, 1)

fiveInts(0) = fiveToOne(4)
fiveInts


// 리스트 버퍼

import scala.collection.mutable.ListBuffer

val buf = new ListBuffer[Int]
buf += 1
buf += 2
buf
3 +=: buf
buf.toList


// 배열 버퍼

import scala.collection.mutable.ArrayBuffer

val buf = new ArrayBuffer[Int]()
buf += 12
buf += 15
buf

buf.length
buf(0)


// 문자열(StringOps를 통함)

def hasUpperCase(s: String) = s.exists(_.isUpper)
hasUpperCase("Robert Frost")
hasUpperCase("e e cummings")
