// 4장 클래스와 객체

// 4.1 클래스, 필드, 메소드

class ChecksumAccumulator {
  // 여기 클래스 정의가 들어간다.
}

new ChecksumAccumulator


class ChecksumAccumulator {
  var sum = 0
}

val acc = new ChecksumAccumulator
val csa = new ChecksumAccumulator

acc.sum = 3

// acc가 val이기 때문에 컴파일할 수 없다.
acc = new ChecksumAccumulator


class ChecksumAccumulator {
  private var sum = 0
}

val acc = new ChecksumAccumulator
acc.sum = 5  // sum이 비공개라서 컴파일할 수 없다.


class ChecksumAccumulator {

  private var sum = 0

  def add(b: Byte): Unit = {
    sum += b
  }

  def checksum(): Int = {
    return ~(sum & 0xFF) + 1
  }
}
