// 리스트 29.15  셀프 타입을 사용한 SimpleRecipes 트레이트

package org.stairwaybook.recipe

trait SimpleRecipes {
  this: SimpleFoods =>

  object FruitSalad extends Recipe(
    "fruit salad",
    List(Apple, Pear),
    "Mix it all together."
  )
  def allRecipes = List(FruitSalad)
}
