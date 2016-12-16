// 리스트 15.4  와일드카드 패턴 매치

expr match {
  case BinOp(_, _, _) => println(expr +" is a binary operation")
  case _ => println("It's somthing else")
}
