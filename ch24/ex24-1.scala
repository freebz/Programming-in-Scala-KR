// 리스트 24.1  SynchronizedMap 트레이트 믹스인

import scala.collection.mutable.{Map,
  SynchronizedMap, HashMap}

object MapMaker {

  def makeMap: Map[String, String] = {
    new HashMap[String, String] with
        SynchronizedMap[String, String] {

      override def default(key: String) =
        "Why do you want to know?"
    }
  }
}



// 24.8 동기화한 집합과 맵

val capital = MapMaker.makeMap
capital ++= List("US" -> "Washington",
  "France" -> "Paris", "Japan" -> "Tokyo")
capital("Japan")
capital("New Zealand")
capital += ("New Zealand" -> "Wellington")
capital("New Zealand")


import scala.collection.mutable

val synchroSet =
  new mutable.HashSet[Int] with
      mutable.SynchronizedSet[Int]


// 24.9 변경 불가능한 구체적인 컬렉션 클래스

// 스트림

val str = 1 #:: 2 #:: 3 #:: Stream.empty

def fibFrom(a: Int, b: Int): Stream[Int] =
  a #:: fibFrom(b, a + b)

val fibs = fibFrom(1, 1).take(7)
fibs.toList


// 벡터

val vec = scala.collection.immutable.Vector.empty
val vec2 = vec :+ 1 :+ 2
val vec3 = 100 +: vec2
vec3(0)

val vec = Vector(1, 2, 3)
vec updated (2, 4)
vec

collection.immutable.IndexedSeq(1, 2, 3)


// 변경 불가능한 스택

val stack = scala.collection.immutable.Stack.empty
val hasOne = stack.push(1)
stack
hasOne.top
hasOne.pop


// 변경 불가능한 큐

val empty = scala.collection.immutable.Queue[Int]()
val has1 = empty.enqueue(1)
val has123 = has1.enqueue(List(2, 3))

val (element, has23) = has123.dequeue


// 범위

1 to 3
5 to 14 by 3
1 until 3


// 적흑 트리

val set = collection.immutable.TreeSet.empty[Int]
set + 1 + 3 + 3


// 변경 불가능한 비트 집합

val bits = scala.collection.immutable.BitSet.empty
val moreBits = bits + 3 + 4 + 4
moreBits(3)
moreBits(0)


// 리스트 맵

val map = collection.immutable.ListMap(
  1 -> "one", 2 -> "two")
map(2)


// 24.10 변경 가능한 구체적인 컬렉션 클래스

// 배열 버퍼

var buf = collection.mutable.ArrayBuffer.empty[Int]
buf += 1
buf += 10
buf.toArray


// 리스트 버퍼

val buf = collection.mutable.ListBuffer.empty[Int]
buf += 1
buf += 10
buf.toList


// 문자열 빌더

val buf = new StringBuilder
buf += 'a'
buf ++= "bcdef"
buf.toString


// 큐

val queue = new scala.collection.mutable.Queue[String]
queue += "a"
queue ++= List("b", "c")
queue
queue.dequeue
queue


// 스택

val stack = new scala.collection.mutable.Stack[Int]
stack.push(1)
stack.push(2)
stack
stack.top
stack
stack.pop
stack


// 해시 테이블

val map = collection.mutable.HashMap.empty[Int,String]
map += (1 -> "make a web site")
map += (3 -> "profit!")
map(1)
map contains 2


// 변경 가능한 비트 집합

val bits = scala.collection.mutable.BitSet.empty
bits += 1
bits += 3
bits


// 24.11 배열

val a1 = Array(1, 2, 3)
val a2 = a1 map (_ * 3)
val a3 = a2 filter (_ % 2 != 0)
a3.reverse

val seq: Seq[Int] = a1
val a4: Array[Int] = seq.toArray
a1 eq a4

val seq: Seq[Int] = a1
seq.reverse
val ops: collection.mutable.ArrayOps[Int] = a1
ops.reverse

a1.reverse
intArrayOps(a1).reverse

// 잘못된 것임!
def evenElems[T](xs: Vector[T]): Array[T] = {
  val arr = new Array[T]((xs.length + 1) / 2)
  for (i <- 0 until xs.length by 2)
    arr(i / 2) = xs(i)
  arr
}

// 잘 동작함
def evenElems[T: ClassManifest](xs: Vector[T]): Array[T] = {
  val arr = new Array[T]((xs.length + 1) / 2)
  for (i <- 0 until xs.length by 2)
    arr(i / 2) = xs(i)
  arr
}

evenElems(Vector(1, 2, 3, 4, 5))
evenElems(Vector("this", "is", "a", "test", "run"))

def wrap[U](xs: Vector[U]) = evenElems(xs)

def wrap[U: ClassManifest](xs: Vector[U]) =
  evenElems(xs)


// 24.12 문자열

val str = "hello"
str.reverse
str.map(_.toUpper)
str drop 3
str slice (1, 4)
val s: Seq[Char] = str


// 24.14 동일성

import collection.mutable.{HashMap, ArrayBuffer}

val buf = ArrayBuffer(1, 2, 3)
val map = HashMap(buf -> 3)
map(buf)
buf(0) += 1
map(buf)


// 24.15 뷰

def lazyMap[T, U](coll: Iterable[T], f: T => U) =
  new Iterable[U] {
    def iterator = coll.iterator map f
  }

val v = Vector(1 to 10: _*)
v map (_ + 1) map (_ * 2)

(v.view map (_ + 1) map (_ * 2)).force

val vv = v.view
val res13 = vv map (_ + 1)
val res14 = res13 map (_ * 2)
res14.force

def isPalindrome(x: String) = x == x.reverse
def findPalindrome(s: Seq[String]) = s find isPalindrome
findPalindrome(words take 1000000)
findPalindrome(words.view take 1000000)

val arr = (0 to 9).toArray
val subarr = arr.view.slice(3, 6)

def negate(xs: collection.mutable.Seq[Int]) =
  for (i <- 0 until xs.length) xs(i) = -xs(i)

negate(subarr)
arr


// 24.16 이터레이터

val it = Iterator("a", "number", "of", "words")
val res1 = it.map(_.length)
res1 foreach println
it.next()

val it = Iterator("a", "number", "of", "words")
it dropWhile (_.length < 2)
it.next()

val (it1, it2) = it.duplicate


// 버퍼 이터레이터

// 작동하지 않음
def skipEmptyWordsNOT(it: Iterator[String]) {
  while (it.next().isEmpty) {}
}

def skipEmptyWords(it: BufferedIterator[String]) =
  while (it.head.isEmpty) { it.next() }

val it = Iterator(1, 2, 3, 4)
val bit = it.buffered
bit.head
bit.next()
bit.next()


// 24.17 컬렉션 밑바닥부터 만들기

Traversable()            // 빈 순회 가능 객체
List()                   // 빈 리스트
List(1.0, 2.0)           // 1.0, 2.0이 원소인 리스트
Vector(1.0, 2.0)         // 1.0, 2.0이 원소인 벡터
Iterator(1, 2, 3)        // 3개의 정수를 돌려주는 이터레이터
Set(dog, cat, bird)      // 세 동물의 집합
HashSet(dog, cat, bird)  // 위와 같은 동물로 이뤄진 해시 집합
Map('a' -> 7, 'b' -> 0)  // 문자에서 정수로 가는 맵

List.apply(1.0, 2.0)

List(1, 2, 3)
Traversable(1, 2, 3)
mutable.Traversable(1, 2, 3)


// 24.18 자바와 스칼라 컬렉션 변환

import collection.JavaConversions._
import collection.mutable._

val jul: java.util.List[Int] = ArrayBuffer(1, 2, 3)
val buf: Seq[Int] = jul
val m: java.util.Map[String, Int] =
  HashMap("abc" -> 1, "hello" -> 2)

val jul: java.util.List[Int] = List(1, 2, 3)
jul.add(7)
