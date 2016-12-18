// 리스트 32.5  도우미 액터를 사용해 자신은 블록되지 않도록 막는 방법

val sillyActor2 = actor {
  def emoteLater() {
    val mainActor = self
    actor {
      Thread.sleep(1000)
      mainActor ! "Emote"
    }
  }

  var emoted = 0
  emoteLater()

  loop {
    react {
      case "Emote" =>
        println("I'm acting!")
        emoted += 1
        if (emoted < 5)
          emoteLater()
      case msg =>
        println("Received: "+ msg)
    }
  }
}



// 32.5 바람직한 액터 스타일

// 액터는 블록돼서는 안 된다

sillyActor2 ! "hi there"
