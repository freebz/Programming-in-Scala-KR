// 리스트 29.6  추상 데이터베이스에 대한 val 값을 가진 Browser 클래스

package org.stairwaybook.recipe

abstract class Browser {
  val database: Database

  def recipesUsing(food: Food) =
    database.allRecipes.filter(recipe =>
      recipe.ingredients.contains(food))

  def displayCategory(category: database.FoodCategory) {
    println(category)
  }
}
