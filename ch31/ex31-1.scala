// 리스트 31.1  자바 throws를 추가한 스칼라 메소드

import java.io._

class Reader(fname: String) {

  private val in =
    new BufferedReader(new FileReader(fname))

  @throws(classOf[IOException])
  def read() = in.read()
}
