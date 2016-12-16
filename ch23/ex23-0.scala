// 23장 for 표현식 다시 보기

case class Person(name: String,
  isMale: Boolean,
  children: Person*)

val lara = Person("Lara", false)
val bob = Person("Bob", true)
val julie = Person("Julie", false, lara, bob)
val persons = List(lara, bob, julie)

persons filter (p => !p.isMale) flatMap (p =>
  (p.children map (c => (p.name, c.name))))

persons withFilter (p => !p.isMale) flatMap (p =>
  (p.children map (c => (p.name, c.name))))

for (p <- persons; if !p.isMale; c <- p.children)
yield (p.name, c.name)


// 23.1 for 표현식

for (p <- persons; n = p.name; if (n startsWith "To"))
yield n

for {
  p <- persons                  // 제너레이터
  n = p.name                    // 정의
  if (n startsWith "To")        // 필터
} yield n

for (x <- List(1, 2); y <- List("one", "two"))
yield (x, y)


// 23.2 n 여왕 문제

def queens(n: Int): List[List[(Int, Int)]] = {
  def placeQueens(k: Int): List[List[(Int, Int)]] =
    if (k == 0)
      List(List())
    else
      for {
        queens <- placeQueens(k - 1)
        column <- 1 to n
        queen = (k, column)
        if isSafe(queen, queens)
      } yield queen :: queens

  def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
    queens forall (q => !inCheck(queen, q))

  def inCheck(q1: (Int, Int), q2: (Int, Int)) = {
    q1._1 == q2._1 ||         // 같은 행
    q1._2 == q2._2 ||         // 같은 열
    (q1._1 - q2._1).abs == (q1._2 - q2._2).abs  // 대각선
  }

  placeQueens(n)
}

def printSolutions(tbls: List[List[(Int, Int)]]) = {
  def printSolution(tbl: List[(Int, Int)]) = {
    val len = tbl.head._1
    println("_" * (len * 2))
    for {
      dim <- tbl.reverse
      col <- 1 to len       // 모든 셀에 무언가를 출력한다.
      pipe = if (col == 1) "|" else ""
      cell = if (col == dim._2) "Q|" else "_|"
      nl = if (col == len) "\n" else ""
    } print(pipe + cell + nl)
  }
  for (t <- tbls) printSolution(t)
}


// 23.3 for 식으로 질의하기

case class Book(title: String, authors: String*)

val books: List[Book] =
  List(
    Book(
      "Structure and Interpretation of Computer Programs",
      "Abelson, Harold", "Sussman, Gerald J."
    ),
    Book(
      "Principles of Compiler Design",
      "Aho, Alfred", "Ullman, Jeffrey"
    ),
    Book(
      "Programming in Modula-2",
      "Wirth, Niklaus"
    ),
    Book(
      "Elements of ML Programming",
      "Ullman, Jeffrey"
    ),
    Book(
      "The Java Language Specification", "Gosling, James",
      "Joy, Bill", "Steele, Guy", "Bracha, Gilad"
    )
  )

for (b <- books; a <- b.authors
  if a startsWith "Gosling")
yield b.title

for (b <- books if (b.title indexOf "Program") >= 0)
yield b.title

val res6 = for (b1 <- books; b2 <- books if b1 != b2;
  a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
yield a1

def removeDuplicates[A](xs: List[A]): List[A] = {
  if (xs.isEmpty) xs
  else
    xs.head :: removeDuplicates(
      xs.tail filter (x => x != xs.head)
    )
}

removeDuplicates(res6)

def removeDuplicates[A](xs: List[A]): List[A] = {
  if (xs.isEmpty) xs
  else
    xs.head :: removeDuplicates(
      for (x <- xs.tail if x != xs.head) yield x
    )
}

removeDuplicates(res6)


// 23.4 for 표현식 변환

// 제너레이터가 하나밖에 없는 for 표현식의 변환

for (x <- expr1) yield expr2
expr1.map(x => expr2)

// 제너레이터로 시작하고 필터가 하나 있는 for 표현식의 변환

for (x <- expr1 if expr2) yield expr3
for (x <- expr1 withFilter (x => expr2)) yield expr3
expr1 withFilter (x => expr2) map (x => expr3)

for (x <- expr1 if expr2; seq) yield expr3
for (x <- expr1 withFilter expr2; seq) yield expr3

// 제너레이터 2개로 시작하는 for 표현식의 변환

for (x <- expr1; y <- expr2; seq) yield expr3
expr1.flatMap(x => for (y <- expr2; seq) yield expr3)

for (b1 <- books; b2 <- books if b1 != b2;
  a1 <- b1.authors; a2 <- b2.authors if a1 == a2)
yield a1

books flatMap (b1 =>
  books withFilter (b2 => b1 != b2) flatMap (b2 =>
    b1.authors flatMap (a1 =>
      b2.authors withFilter (a2 => a1 == a2) map (a2 =>
        a1))))

// 제너레이터에 있는 패턴의 변환

for ((x1, ..., xn) <- expr1) yield expr2
expr1.map { case (x1, ..., xn) => expr2 }

for (pat <- expr1) yield expr2
expr1 withFilter {
  case pat => true
  case _ => false
} map {
  case pat => expr2
}

// 정의 변환

for (x <- expr1; y = expr2; seq) yield epxr3
for ((x, y) <- for (x <- expr1) yield (x, expr2); seq)
yield expr3

for (x <- 1 to 1000; y = expensiveComputationNotInvolvingX)  // y 연산이 반복됨
yield x * y

val y = expensiveComputationNotInvolvingX  // 이쪽이 효율적
for (x <- 1 to 1000) yield * y

// for 루프 변환

for (x <- expr1) body
expr1 foreach (x => body)

for (x <- expr1; if expr2; y <- expr3) body
expr1 withFilter (x => expr2) foreach (x =>
  expr3 foreach (y => body))

var sum = 0
for (xs <- xss; x <- xs) sum += x

var sum = 0
xss foreach (xs =>
  xs foreach (x =>
    sum += x))


// 23.5 역방향 적용

object Demo {
  def map[A, B](xs: List[A], f: A => B): List[B] =
    for (x <- xs) yield f(x)

  def flatMap[A, B](xs: List[A], f: A => List[B]): List[B] =
    for (x <- xs; y <- f(x)) yield y

  def filter[A](xs: List[A], p: A => Boolean): List[A] =
    for (x <- xs if p(x)) yield x
}


// 23.6 for 일반화

abstract class C[A] {
  def map[B](f: A => B): C[B]
  def flatMap[B](f: A => C[B]): C[B]
  def withFilter(p: A => Boolean): C[A]
  def foreach(b: A => Unit): Unit
}
