// 리스트 29.12  FoodCategories 트레이트를 혼합하는 Database 클래스

package org.stairwaybook.recipe

abstract class Database extends FoodCategories {
  def allFoods: List[Food]
  def allRecipes: List[Recipe]
  def foodNamed(name: String) =
    allFoods.find(f => f.name == name)
}
