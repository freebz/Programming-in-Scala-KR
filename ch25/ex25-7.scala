// 리스트 25.7  RNA 가닥 클래스의 두 번째 버번

import collection.IndexedSeqLike
import collection.mutable.{Builder, ArrayBuffer}
import collection.generic.CanBuildFrom

final class RNA2 private (
  val groups: Array[Int],
  val length: Int
) extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA2] {

  import RNA2._

  override def newBuilder: Builder[Base, RNA2] =
    new ArrayBuffer[Base] mapResult fromSeq

  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }
}

object RNA2 {

  // 그룹을 표현할 때 필요한 비트 수
  private val S = 2

  // Int(32비트 정수)에 들어갈 그룹의 수
  private val N = 32 / S

  // 어떤 그룹만 떼어내기 위한 비트 마스크
  private val M = (1 << S) - 1

  def fromSeq(buf: Seq[Base]): RNA2 = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA2(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)
}
