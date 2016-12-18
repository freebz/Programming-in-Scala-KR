// 리스트 32.6  메시지에 케이스 클래스를 사용하는 액터

import scala.actors.Actor._
import java.net.{InetAddress, UnknownHostException}

case class LookupIP(name: String, respondTo: Actor)
case class LookupResult(
  name: String,
  address: Option[InetAddress]
)
object NameResolver2 extends Actor {
  def act() {
    loop {
      react {
        case LookupIP(name, actor) =>
          actor ! LookupResult(name, getIp(name))
      }
    }
  }
  def getIp(name: String): Option[InetAddress] = {
    // 리스트 32.3의 내용과 동일
    try {
      Some(InetAddress.getByName(name))
    } catch {
      case _:UnknownHostException => None
    }
  }
}



// 32.6 더 긴 예제: 병렬 이산 이벤트 시뮬레이션

// 전체 설계

trait Simulant extends Actor
class Wire extends Simulant

case class Ping(time: Int)
case class Pont(time: Int, from: Actor)

class Clock extends Actor {
  private var running = false
  private var currentTime = 0
  private var agenda: List[WorkItem] = List()
}

case class WorkItem(time: Int, msg: Any, target: Actor)

case class AfterDelay(delay: Int, msg: Any, target: Actor)

case object Start
case object Stop


// 시뮬레이션 프레임워크 구현

class Clock extends Actor {
  private var running = false
  private var currentTime = 0
  private var agenda: List[WorkItem] = List()
  private var allSimulants: List[Actor] = List()
  private var busySimulants: Set[Actor] = Set.empty

  def add(sim: Simulant) {
    allSimulants = sim :: allSimulants
  }

  def act() {
    loop {
      if (running && busySimulants.isEmpty)
        advance()
      reactToOneMessage()
    }
  }

  def advance() {
    if (agenda.isEmpty && currentTime > 0) {
      println("** Agenda empty.  Clock exiting at time "+
        currentTime+".")
      self ! Stop
      return
    }

    currentTime += 1
    println("Advancing to time "+currentTime)

    processCurrentEvents()
    for (sim <- allSimulants)
      sim ! Ping(currentTime)
    busySimulants = Set.empty ++ allSimulants
  }

  private def processCurrentEvents() {
    val todoNow = agenda.takeWhile(_.time <= currentTime)
    agenda = agenda.drop(todoNow.length)
    for (WorkItem(time, msg, target) <- todoNow) {
      assert(time == currentTime)
      target ! msg
    }
  }

  def reactToOneMessage() {
    react {
      case AfterDelay(delay, msg, target) =>
        val item = WorkItem(currentTime + delay, msg, target)
        agenda = insert(agenda, item)
      case Pong(time, sim) =>
        assert(time == currentTime)
        assert(busySimulants contains sim)
        busySimulants -= sim
      case Start => running = true
      case Stop =>
        for (sim <- allSimulants)
          sim ! Stop
        exit()
    }
  }

}
