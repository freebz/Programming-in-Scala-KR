// 리스트 15.2  패턴 매치를 사용하는 simplifyTop 함수

def simplifyTop(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e))  => e  // 부호를 두 번 반전
  case BinOp("+", e, Number(0)) => e  // 0을 더함
  case BinOp("*", e, Number(1)) => e  // 1을 곱함
  case _ => expr
}


// 패턴 매치

simplifyTop(UnOp("-", UnOp("-", Var("x"))))
