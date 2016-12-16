// 리스트 15.9  길이와 관계없이 매치할 수 있는 시퀀스 패턴

expr match {
  case List(0, _*) => println("found it")
  case _ =>
}
