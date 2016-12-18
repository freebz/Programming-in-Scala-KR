// 리스트 32.1  간단한 액터

import scala.actors._

object SillyActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("I'm acting!")
      Thread.sleep(1000)
    }
  }
}



// 32장 액터와 동시성

// 32.2 액터와 메시지 전달

SillyActor.start()


import scala.actors._

object SeriousActor extends Actor {
  def act() {
    for (i <- 1 to 5) {
      println("To be or not to be.")
      Thread.sleep(1000)
    }
  }
}

SillyActor.start(); SeriousActor.start()

import scala.actors.Actor._

val seriousActor2 = actor {
  for (i <- 1 to 5) {
    println("That is the question.")
    Thread.sleep(1000)
  }
}

SillyActor ! "hi there"
