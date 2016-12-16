// 리스트 29.1  간단한 Food 엔티티 클래스

package org.stairwaybook.recipe

abstract class Food(val name: String) {
  override def toString = name
}
