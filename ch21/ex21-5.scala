// 리스트 21.5  뷰 바운드를 사용한 함수

def maxList[T <% Ordered[T]](elements: List[T]): T =
  elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxList(rest)  // orderer를 암시적으로 사용
      if (x > maxRest) x           // orderer(x)를 암시적으로 사용
      else maxRest
  }



// 21.7 여러 변환을 사용하는 경우

def printLength(seq: Seq[Int]) = println(seq.length)
implicit def intToRange(i: Int) = 1 to i
implicit def intToDigits(i: Int) =
  i.toString.toList.map(_.toInt)
printLength(12)

val cba = "abc".reverse
"abc" == "abc".reverse.reverse


// 21.8 암시 디버깅

val chars: List[Char] = "xyz"
val chars: List[Char] = wrapString("xyz")
