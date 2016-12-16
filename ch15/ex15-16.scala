// 리스트 15.16  봉인한 케이스 클래스 계층

sealed abstract class Expr
case class Var(name: String) extends Expr
case class Number(num: Double) extends Expr
case class UnOp(operator: String, arg: Expr) extends Expr
case class BinOp(operator: String,
  left: Expr, right: Expr) extends Expr



// 15.5 봉인한 클래스

def describe(e: Expr): String = e match {
  case Number(_) => "a number"
  case Var(_)    => "a variable"
}

def describe(e: Expr): String = e match {
  case Number(_) => "a number"
  case Var(_)    => "a variable"
  case _ => throw new RuntimeException  // 일어나서는 안 될 일이다.
}

def describe(e: Expr): String = (e: @unchecked) match {
  case Number(_) => "a number"
  case Var(_)    => "a variable"
}


// 15.6 Option 타입

val capitals =
  Map("France" -> "Paris", "Japan" -> "Tokyo")

capitals get "France"
capitals get "North Pole"

def show(x: Option[String]) = x match {
  case Some(s) => s
  case None => "?"
}

show(capitals get "Japan")
show(capitals get "France")
show(capitals get "North Pole")
