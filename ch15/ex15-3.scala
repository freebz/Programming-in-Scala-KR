// 리스트 15.3  비어 있는 '디폴트' 케이스가 있는 패턴 매치

expr match {
  case BinOp(op, left, right) =>
    println(expr +" is a binary operation")
  case _ =>
}
