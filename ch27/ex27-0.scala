// 27장 애노테이션

// 27.2 애노테이션 문법

@deprecated def bigMistake() = ??? // ...

@deprecated class QuickAndDirty {
  // ...
}

(e: @unchecked) match {
  // 모든 경우를 처리하지는 않음
}

import annotation._
class strategy(arg: Annotation) extends Annotation
class delayed extends Annotation
@strategy(@delayed) def f(){}
@strategy(new delayed) def f(){}


// 27.3 표준 애노테이션

// 사용금지

@deprecated def bigMistake() = ??? // ...

@deprecated("use newShinyMethod() instead")
def bigMistake() = ??? //...

// volatile 필드

// 이진 직렬화

// 자동 get, set 메소드

@scala.reflect.BeanProperty

// tailrec

// unchecked

// 네이티브 메소드

@native
def beginCountdown() { }
