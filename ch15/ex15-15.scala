// 리스트 15.15  case의 순서가 중요함을 보여주는 match 표현식

def simplifyAll(expr: Expr): Expr = expr match {
  case UnOp("-", UnOp("-", e)) =>
    simplifyAll(e)  // -를 두번 적용하는 경우
  case BinOp("+", e, Number(0)) =>
    simplifyAll(e)  // 0은 + 연산의 항등원
  case BinOp("*", e, Number(1)) =>
    simplifyAll(e)  // 1은 * 연산의 항등원
  case UnOp(op, e) =>
    UnOp(op, simplifyAll(e))
  case BinOp(op, l, r) =>
    BinOp(op, simplifyAll(l), simplifyAll(r))
  case _ => expr
}
