// 16장 리스트

// 16.1 리스트 리터럴

val fruit = List("apples", "oranges", "pears")
val nums = List(1, 2, 3, 4)
val diag3 =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty = List()


// 16.2 리스트 타입

val fruit: List[String] = List("apples", "oranges", "pears")
val nums: List[Int] = List(1, 2, 3, 4)
val diag3: List[List[Int]] =
  List(
    List(1, 0, 0),
    List(0, 1, 0),
    List(0, 0, 1)
  )
val empty: List[Nothing] = List()

// List()는 List[String] 타입이기도 하다!
val xs: List[String] = List()


// 16.3 리스트 생성

val fruit = "apples" :: ("oranges" :: ("rears" :: Nil))
val nums = 1 :: (2 :: (3 :: (4 :: Nil)))
val diag3 = ((1 :: (0 :: (0:: Nil))) ::
  (0 :: (1 :: (0 :: Nil))) ::
  (0 :: (0 :: (1 :: Nil))) :: Nil)
val empty = Nil

val nums = 1 :: 2 :: 3 :: 4 :: Nil


// 16.4 리스트 기본 연산

Nil.head

def insert(x: Int, xs: List[Int]): List[Int] = {
  if (xs.isEmpty || x <= xs.head) x :: xs
  else xs.head :: insert(x, xs.tail)
}

def isort(xs: List[Int]): List[Int] = {
  if (xs.isEmpty) Nil
  else insert(xs.head, isort(xs.tail))
}


// 16.5 리스트 패턴

val List(a, b, c) = fruit
val a :: b :: rest = fruit

def insert(x: Int, xs: List[Int]): List[Int] = xs match {
  case List()  => List(x)
  case y :: ys => if (x <= y) x :: xs
  else y :: insert(x, ys)
}

def isort(xs: List[Int]): List[Int] = xs match {
  case List()   => List()
  case x :: xs1 => insert(x, isort(xs1))
}


// 16.6 List 클래스의 1차 메소드

// 두 리스트 연결하기

List(1, 2) ::: List(3, 4, 5)
List() ::: List (1, 2, 3)
List (1, 2, 3) ::: List(4)


// 분할 정복 원칙

def append[T](xs: List[T], ys: List[T]): List[T] =
  xs match {
    case List() => ys
    case x :: xs1 => x :: append(xs1, ys)
  }


// 리스트 길이 구하기: length

List(1, 2, 3).length


// 리스트 양 끝에 접근하기: init와 last

val abcde = List('a', 'b', 'c', 'd', 'e')
abcde.last
abcde.init

List().init
List().last


// 리스트 뒤집기: reverse

abcde.reverse
abcde

def rev[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case x :: xs1 => rev(xs1) ::: List(x)
}


// 접두사와 접미사: drop, take splitAt

abcde take 2
abcde drop 2
abcde splitAt 2


// 원소 선택: apply와 indices

abcde apply 2  // 스칼라에서는 이렇게 사용하는 경우가 드물다.
abcde(2)  // 스칼라에서는 이렇게 사용하는 경우가 드물다.

abcde.indices


// 리스트의 리스트를 한 리스트로 반듯하게 만들기: flatten

List(List(1, 2), List(3), List(), List(4, 5)).flatten
fruit.map(_.toCharArray).flatten

List(1, 2, 3).flatten


// 두 리스트를 순서쌍으로 묶기: zip과 unzip

abcde.indices zip abcde
val zipped = abcde zip List(1, 2, 3)
abcde.zipWithIndex
zipped.unzip


// 리스트 출력하기: toString과 mkString

abcde.toString
abcde mkString ("[", ",", "]")
abcde mkString ""
abcde.mkString
abcde mkString ("List(", ", ", ")")

val buf = new StringBuilder
abcde addString (buf, "(", ";", ")")


// 리스트 변환하기: iterator, toArray, copyToArray

val arr = abcde.toArray
arr.toList

val arr2 = new Array[Int](10)
List(1, 2, 3) copyToArray (arr2, 3)
arr2

val it = abcde.iterator
it.next
it.next

