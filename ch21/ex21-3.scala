// 리스트 21.3  암시적 파라미터가 있는 함수

def maxListImpParam[T](elements: List[T])
    (implicit orderer: T => Ordered[T]): T =

  elements match {
    case List() =>
      throw new IllegalArgumentException("empty list!")
    case List(x) => x
    case x :: rest =>
      val maxRest = maxListImpParam(rest)(orderer)
      if (orderer(x) > maxRest) x
      else maxRest
  }



maxListImpParam(List(1,5,10,3))
maxListImpParam(List(1.5, 5.2, 10.7, 3.14159))
maxListImpParam(List("one", "two", "three"))


// 암시 파라미터에 대한 스타일 규칙

def maxListPoorStyle[T](elements: List[T])
  (implicit orderer: (T, T) => Boolean): T
