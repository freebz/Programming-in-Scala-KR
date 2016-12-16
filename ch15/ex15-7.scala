// 리스트 15.7  생성자 패턴을 사용한 패턴 매치

expr match {
  case BinOp("+", e, Number(0)) => println("a depp match")
  case _ =>
}
