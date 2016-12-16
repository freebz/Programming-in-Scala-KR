// 리스트 17.1  Predef 안에 있는 디폴트 맵과 집합 정의

object Predef {
  type Map[A, +B] = collection.immutable.Map[A, B]
  type Set[A] = collection.immutable.Set[A]
  val Map = collection.immutable.Map
  val Set = collection.immutable.Set
  // ...
}



// 17.2 집합과 맵

import scala.collection.mutable

val mutaSet = mutable.Set(1, 2, 3)


// 집합의 사용

val text = "See Spot run. Run, Spot. Run!"
val wordsArray = text.split("[ !,.]+")

val words = mutable.Set.empty[String]
for (word <- wordsArray)
  words += word.toLowerCase
words


// 맵의 사용

val map = mutable.Map.empty[String, Int]
map("hello") = 1
map("there") = 2
map
map("hello")

def countWords(text: String) = {
  val counts = mutable.Map.empty[String, Int]
  for (rawWord <- text.split("[ ,!.]+")) {
    val word = rawWord.toLowerCase
    val oldCount =
      if (counts.contains(word))
        counts(word)
      else
        0
    counts += (word -> (oldCount + 1))
  }
  counts
}

countWords("See Spot run! Run, Spot. Run!")


// 정렬된 집합과 맵

import scala.collection.immutable.TreeSet

val ts = TreeSet(9, 3, 1, 8, 0, 2, 7, 4, 6, 5)
val cs = TreeSet('f', 'u', 'n')

import scala.collection.immutable.TreeMap

var tm = TreeMap(3 -> 'x', 1 -> 'x', 4 -> 'x')
tm += (2 -> 'x')
tm


// 17.3 변경 가능 컬렉션과 변경 불가능 컬렉션 비교

val people = Set("Nancy", "Jane")
people += "Bob"

var people = Set("Nancy", "Jane")
people += "Bob"
people

people -= "Jane"
people ++= List("Tom", "Harry")
people

var capital = Map("US" -> "Washington", "France" -> "Paris")
capital += ("Japan" -> "Tokyo")
println(capital("France"))

import scala.collection.mutable.Map  // 이 부분만 바꾸면 충분함!
var capital = Map("US" -> "Washington", "France" -> "Paris")
capital += ("Japan" -> "Tokyo")
println(capital("France"))

var roughlyPi = 3.0
roughlyPi += 0.1
roughlyPi += 0.04
roughlyPi


// 17.4 컬렉션 초기화

List(1, 2, 3)
Set('a', 'b', 'c')
import scala.collection.mutable
mutable.Map("hi" -> 2, "there" -> 5)
Array(1.0, 2.0, 3.0)

import scala.collection.mutable
var stuff = mutable.Set(42)
sutff += "abracadabra"

val stuff = mutable.Set[Any](42)

val colors = List("blue", "yellow", "red", "green")

import scala.collection.immutable.TreeSet

val treeSet = TreeSet(colors)
val treeset = TreeSet[String]() ++ colors


// 배열이나 리스트로 바꾸기

treeSet.toList
treeSet.toArray


// 변경 가능한 집합(맵)과 변경 불가능한 집합(맵) 사이의 변환

import scala.collection.mutable

treeSet
val mutaSet = mutable.Set.empty ++= treeSet
val immutaSet = Set.empty ++ mutaSet

val muta = mutable.Map("i" -> 1, "ii" -> 2)
val immu = Map.empty ++ muta


// 17.5 튜플

(1, "hello", Console)

def longestWord(words: Array[String]) = {
  var word = words(0)
  var idx = 0
  for (i <- 1 until words.length)
    if (words(i).length > word.length) {
      word = words(i)
      idx = i
    }
  (word, idx)
}

val longest =
  longestWord("The quick brown fox".split(" "))

longest._1
longest._2

val (word, idx) = longest
word

val word, idx = longest
