// 리스트 15.10  튜플 패턴을 사용하는 패턴 매치

def tupleDemo(expr: Any) =
  expr match {
    case (a, b, c) => println("matched "+ a + b + c)
    case _ =>
  }



// 튜플 패턴

tupleDemo(("a", 3, "-tuple"))
