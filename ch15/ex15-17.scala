// 리스트 15.17  할당문 하나로 여러 배열 정의하기

val myTuple = (123, "abc")
val (number, string) = myTuple



// 15.7 패턴은 어디에나

// 변수 정의에서 패턴 사용하기

val exp = new BinOp("*", Number(5), Number(1))
val BinOp(op, left, right) = exp

// case 시퀀스로 부분 함수 만들기

val withDefault: Option[Int] => Int = {
  case Some(x) => x
  case None => 0
}

withDefault(Some(10))
withDefault(None)


val second: List[Int] => Int = {
  case x :: y :: _ => y
}

second(List(5, 6, 7))
second(List())


val second: PartialFunction[List[Int],Int] = {
  case x :: y :: _ => y
}

second.isDefinedAt(List(5,6,7))
second.isDefinedAt(List())


new PartialFunction[List[Int], Int] {
  def apply(xs: List[Int]) = xs match {
    case x :: y :: _ => y
  }
  def isDefinedAt(xs: List[Int]) = xs match {
    case x :: y :: _ => true
    case _ => false
  }
}
