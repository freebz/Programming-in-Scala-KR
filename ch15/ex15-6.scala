// 리스트 15.6  변수 패턴을 사용한 패턴 매치

expr match {
  case 0 => "zero"
  case somthingElse => "not zero: "+ somthingElse
}



// 변수 패턴

// 변수 또는 상수?

import math.{E, Pi}

E match {
  case Pi => "strange math? Pi = "+ Pi
  case _ => "OK"
}


val pi = math.Pi
E match {
  case pi => "strange math? Pi = "+ pi
}

E match {
  case pi => "strange math? Pi = "+ pi
  case _ => "OK"
}

E match {
  case `pi` => "strange math? Pi = "+ pi
  case _ => "OK"
}
