// 리스트 16.1  리스트 병합 정렬 함수

def msort[T](less: (T, T) => Boolean)
  (xs: List[T]): List[T] = {

  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
  val n = xs.length / 2

  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}


// 예제: 병합 정렬

msort((x: Int, y: Int) => x < y)(List(5, 7, 1, 3))

val intSort = msort((x: Int, y: Int) => x < y) _
val reverseIntSort = msort((x: Int, y: Int) => x > y) _

val mixedInts = List(4, 1, 9, 0, 5, 8, 3, 6, 2, 7)
intSort(mixedInts)
reverseIntSort(mixedInts)


// 16.7 List 클래스의 고차 메소드

// 리스트 매핑: map, flatMap, foreach

List(1, 2, 3) map (_ + 1)
val words = List("the", "quick", "brown", "fox")
words map (_.length)
words map (_.toList.reverse.mkString)

words map (_.toList)
words flatMap (_.toList)

List.range(1, 5) flatMap (
  i => List.range(1, i) map (j => (i, j))
)

for (i <- List.range(1, 5); j <- List.range(1, i)) yield (i, j)

var sum = 0
List(1, 2, 3, 4, 5) foreach (sum += _)
sum


// 리스트 걸러내기: filter, partition, find, takeWhile, dropWhile, span

List(1, 2, 3, 4, 5) filter (_ % 2 == 0)
words filter (_.length == 3)

List(1, 2, 3, 4, 5) partition (_ % 2 == 0)

List(1, 2, 3, 4, 5) find (_ % 2 == 0)
List(1, 2, 3, 4, 5) find (_ <= 0)

List(1, 2, 3, -4, 5) takeWhile (_ > 0)
words dropWhile (_ startsWith "t")

List(1, 2, 3, -4, 5) span (_ > 0)


// 리스트 전체에 대한 술어: forall과 exists

def hasZeroRow(m: List[List[Int]]) =
  m exists (row => row forall (_ == 0))
hasZeroRow(diag3)


// 리스트 폴드: /:과 :\

def sum(xs: List[Int]): Int = (0 /: xs) (_ + _)
def product(xs: List[Int]): Int = (1 /: xs) (_ * _)

("" /: words) (_ +" "+ _)
(words.head /: words.tail) (_ +" "+ _)

def flattenLeft[T](xss: List[List[T]]) =
  (List[T]() /: xss) (_ ::: _)
def flattenRight[T](xss: List[List[T]]) =
  (xss :\ List[T]()) (_ ::: _)

def flattenRight[T](xss: List[List[T]]) =
  (xss :\ List()) (_ ::: _)
def flattenLeft[T](xss: List[List[T]]) =
  (List() /: xss) (_ ::: _)


// 예: 폴드를 사용해 리스트 뒤집기

def reverseLeft[T](xs: List[T]) =
  (List[T]() /: xs) {(ys, y) => y :: ys}


// 리스트 정렬: sortWith

List(1, -3, 4, 2, 6) sortWith (_ < _)
words sortWith (_.length > _.length)


// 16.8 List 객체의 메소드

// 원소로부터 리스트 만들기: List.apply

List.apply(1, 2, 3)


// 수의 범위를 리스트로 만들기: List.range

List.range(1, 5)
List.range(1, 9, 2)
List.range(9, 1, -3)


// 균일한 리스트 생성: List.fill

List.fill(5)('a')
List.fill(3)("hello")

List.fill(2, 3)('b')


// 함수 도표화: List.tabulate

val squares = List.tabulate(5)(n => n * n)
val mutiplication = List.tabulate(5,5)(_ * _)


// 여러 리스트 연결하기: List.concat

List.concat(List('a', 'b'), List('c'))
List.concat(List(), List('b'), List('c'))
List.concat()


// 16.9 여러 리스트를 함께 처리하기

(List(10, 20), List(3, 4, 5)).zipped.map(_ * _)

(List("abc", "de"), List(3, 2)).zipped.
  forall(_.length == _)
(List("abc", "de"), List(3, 2)).zipped.
  exists(_.length != _)


// 16.10 스칼라의 타입 추론 알고리즘 이해

msort((x: Char, y: Char) => x > y)(abcde)

abcde sortWith (_ > _)

msort(_ > _)(abcde)
msort[Char](_ > _)(abcde)

def msortSwapped[T](xs: List[T])(less:
    (T, T) => Boolean): List[T] = {

  def merge(xs: List[T], ys: List[T]): List[T] =
    (xs, ys) match {
      case (Nil, _) => ys
      case (_, Nil) => xs
      case (x :: xs1, y :: ys1) =>
        if (less(x, y)) x :: merge(xs1, ys)
        else y :: merge(xs, ys1)
    }
  val n = xs.length / 2

  if (n == 0) xs
  else {
    val (ys, zs) = xs splitAt n
    merge(msort(less)(ys), msort(less)(zs))
  }
}

msortSwapped(abcde)(_ > _)
