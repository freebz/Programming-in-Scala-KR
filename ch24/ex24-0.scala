// 24장 스칼라 컬렉션 API

// 24.2 컬렉션 일관성

import scala.collection._
import scala.collection.mutable.Buffer

val (x, y, z) = (24, 25, 26)
object Color extends Enumeration {
  val Red, Green, Blue = Value
}
val (a, b, c) = ('a', 'b', 'c')

Traversable(1, 2, 3)
Iterable("x", "y", "z")
Map("x" -> 24, "y" -> 25, "z" -> 26)
Set(Color.Red, Color.Green, Color.Blue)
SortedSet("hello", "world")
Buffer(x, y, z)
IndexedSeq(1.0, 2.0)
LinearSeq(a, b, c)

import scala.collection.immutable.HashMap

List(1, 2, 3)
HashMap("x" -> 24, "y" -> 25, "z" -> 26)

List(1, 2, 3) map (_ + 1)
Set(1, 2, 3) map (_ * 2)


// 24.3 Traversable 트레이트

def foreach[U](f: Elem => U)


// 24.4 Iterable 트레이트

def foreach[U])(f: Elem => U): Unit = {
  val it= iterator
  while (it.hasNext) f(it.next())
}

val xs = List(1, 2, 3, 4, 5)
val git = xs grouped 3
git.next()
git.next()
val sit = xs sliding 3
sit.next()
sit.next()
sit.next()

// Traversable과 Iterable이 각각 존재하는 이유는 무엇인가?

sealed abstract class Tree
case class Branch(left: Tree, right: Tree) extends Tree
case class Node(elem: Int) extends Tree

sealed abstract class Tree extends Traversable[Int] {
  def foreach[U](f: Int => U) = this match {
    case Node(elem) => f(elem)
    case Branch(l, r) => l foreach f; r foreach f
  }
}

sealed abstract class Tree extends Iterable[Int] {
  def iterator: Iterator[Int] = this match {
    case Node(elem) => Iterator.single(elem)
    case Branch(l, r) => l.iterator ++ r.iterator
  }
}


// 24.6 집합

val fruit = Set("apple", "orange", "peach", "banana")
fruit("peach")
fruit("potato")

var s = Set(1, 2, 3)
s += 4; s -= 2
s

val s = collection.mutable.Set(1, 2, 3)
s += 4
s -= 2


// 정렬 집합

val myOrdering = Ordering.fromLessThan[String](_ > _)

import scala.collection.immutable.TreeSet
TreeSet.empty(myOrdering)

val set = TreeSet.empty[String]
val numbers = set + ("one", "two", "three", "four")

numbers range ("one", "two")
numbers from "three"


// 24.7 맵

def f(x: String) = {
  println("taking my time."); Thread.sleep(100)
  x.reverse }

val cache = collection.mutable.Map[String, String]()

def cachedF(s: String) = cache.getOrElseUpdate(s, f(s))
cachedF("abc")
cachedF("abc")

def cachedF(arg: String) = cache get arg match {
  case Some(result) => result
  case None =>
    val result = f(arg)
    cache(arg) = result
    result
}
