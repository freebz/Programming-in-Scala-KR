// 리스트 13.12  접근 지정자를 사용해 보호 영역을 유연하게 설정하기

package bobsrockets

package navigation {
  private[bobsrockets] class Navigator {
    protected[navigation] def useStarChart() {}
    class LegOfJourney {
      private[Navigator] val distance = 100
    }
    private[this] var speed = 200
  }
}

package launch {
  import navigation._
  object Vehicle {
    private[launch] val guide = new Navigator
  }
}
