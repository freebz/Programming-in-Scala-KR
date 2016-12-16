// 리스트 15.5  상수 패턴을 사용한 패턴 매치

def describe(x: Any) = x match {
  case 5 => "five"
  case true => "truth"
  case "hello" => "hi!"
  case Nil => "the empty list"
  case _ => "somthing else"
}


// 15.2 패턴의 종류

// 상수 패턴

describe(5)
describe(true)
describe("hello")
describe(Nil)
describe(List(1,2,3))
