// 리스트 15.13  (@ 기호를 사용한) 변수 바인딩이 있는 패턴 매치

expr match {
  case UnOp("abs", e @ UnOp("abs", _)) => e
  case _ =>
}
