// 리스트 25.1  Builder 클래스의 개요

package scala.collection.generic

class Builder[-Elem, +To] {
  def +=(elem: Elem): this.type
  def result(): To
  def clear()
  def mapResult(f: To => NewTo): Builder[Elem, NewTo] = ???  // ...
}



// 25장 스칼라 컬렉션의 아키텍처

// 25.1 빌더

import collection.mutable.ArrayBuffer

val buf = new ArrayBuffer[Int]
val bldr = buf mapResult (_.toArray)
