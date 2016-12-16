// 리스트 29.11  음식 카테고리 트레이트

package org.stairwaybook.recipe

trait FoodCategories {
  case class FoodCategory(name: String, foods: List[Food])
  def allCategories: List[FoodCategory]
}
