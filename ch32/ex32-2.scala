// 리스트 32.2  receive를 호출하는 액터

val echoActor = actor {
  while (true) {
    receive {
      case msg =>
        println("received message: "+ msg)
    }
  }
}



echoActor ! "hi there"
echoActor ! 15

val intActor = actor {
  receive {
    case x: Int =>  // Int밖에 난 몰라
      println("Got an Int: "+ x)
  }
}

intActor ! "hello"
intActor ! math.Pi
intActor ! 12


// 32.3 네이티브 스레드를 액터로 다루기

import scala.actors.Actor._

self ! "hello"
self.receive { case x => x }
self.receiveWithin(1000) { case x => x }  // 1초간 대기
