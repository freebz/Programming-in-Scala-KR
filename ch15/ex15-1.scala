// 리스트 15.1  케이스 클래스의 정의

abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String, left: Expr, right: Expr) extends Expr



// 15장 케이스 클래스와 패턴 매치

// 15.1 간단한 예

val v = Var("x")
val op = BinOp("+", Number(1), v)

v.name
op.left

println(op)
op.right == Var("x")

op.copy(operator = "-")
