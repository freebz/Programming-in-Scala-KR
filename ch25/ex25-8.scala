// 리스트 25.8  최종 RNA 가닥 클래스
// 리스트 25.9  RNA 동반 객체 최종 버전

import collection.IndexedSeqLike
import collection.mutable.{Builder, ArrayBuffer}
import collection.generic.CanBuildFrom

final class RNA private (val groups: Array[Int], val length: Int)
    extends IndexedSeq[Base] with IndexedSeqLike[Base, RNA] {

  import RNA._

  // 'IndexedSeq'에 있는 'newBuilder'를 재구현하는 것은 필수다.
  override protected[this] def newBuilder: Builder[Base, RNA] =
    RNA.newBuilder

  // 'IndexSeq'의 'apply'를 재구현하는 것은 필수다.
  def apply(idx: Int): Base = {
    if (idx < 0 || length <= idx)
      throw new IndexOutOfBoundsException
    Base.fromInt(groups(idx / N) >> (idx % N * S) & M)
  }

  // foreach는 재구현을 꼭 해야 하는 것은 아니다.
  // 하지만 더 효율적으로 만들기 위해 재구현한다.
  override def foreach[U](f: Base => U): Unit = {
    var i = 0
    var b = 0
    while (i < length) {
      b = if (i % N == 0) groups(i / N) else b >>> S
      f(Base.fromInt(b & M))
      i += 1
    }
  }
}

object RNA {
  private val S = 2             // 그룹당 비트 수
  private val M = (1 << S) - 1  // 어떤 그룹만 떼어내기 위한 비트 마스크
  private val N = 32 / S        // 32비트 정수에 들어갈 그룹 개수

  def fromSeq(buf: Seq[Base]): RNA = {
    val groups = new Array[Int]((buf.length + N - 1) / N)
    for (i <- 0 until buf.length)
      groups(i / N) |= Base.toInt(buf(i)) << (i % N * S)
    new RNA(groups, buf.length)
  }

  def apply(bases: Base*) = fromSeq(bases)

  def newBuilder: Builder[Base, RNA] =
    new ArrayBuffer mapResult fromSeq

  implicit def canBuildFrom: CanBuildFrom[RNA, Base, RNA] =
    new CanBuildFrom[RNA, Base, RNA] {
      def apply(): Builder[Base, RNA] = newBuilder
      def apply(from: RNA): Builder[Base, RNA] = newBuilder
    }
}
