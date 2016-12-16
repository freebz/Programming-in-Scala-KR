// 리스트 18.3  공개 var가 게터와 세터 메소드로 어떻게 확장되는지 보여주는 예

class Time {

  private[this] var h = 12
  private[this] var m = 0

  def hour: Int = h
  def hour_=(x: Int) { h = x }

  def minute: Int = m
  def minute_=(x: Int) { m = x }
}
