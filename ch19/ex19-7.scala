// 리스트 19.7  반공변 출력 채널

trait OutputChannel[-T] {
  def write(x: T)
}
