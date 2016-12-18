// 리스트 32.3  react를 호출하는 액터

object NameResolver extends Actor {
  import java.net.{InetAddress, UnknownHostException}

  def act() {
    react {
      case (name: String, actor: Actor) =>
        actor ! getIp(name)
        act()
      case "EXIT" =>
        println("Name resolver exiting.")
        // 종료
      case msg =>
        println("Unhandled message: "+ msg)
        act()
    }
  }

  def getIp(name: String): Option[InetAddress] = {
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _:UnknownHostException => None
    }
  }
}


// 32.4 스레드 재활용을 통한 성능 향상

NameResolver.start()
NameResolver ! ("www.scala-lang.org", self)
self.receiveWithin(0) { case x => x }
NameResolver ! ("wwwwww.scala-lang.org", self)
self.receiveWithin(0) { case x => x }
