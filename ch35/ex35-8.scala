// 리스트 35.8  산술 연산을 위한 라이브러리

package org.stairwaybook.scells

trait Arithmetic { this: Evaluator =>
  operations += {
    "add"  -> { case List(x, y) => x + y },
    "sub"  -> { case List(x, y) => x - y },
    "div"  -> { case List(x, y) => x / y },
    "mul"  -> { case List(x, y) => x * y },
    "mod"  -> { case List(x, y) => x % y },
    "sum"  -> { case (0.0 /: xs) (_ + _) },
    "prod" -> { case (1.0 /: xs) (_ * _) }
  }
}
