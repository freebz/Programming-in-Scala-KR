// 리스트 29.17  싱글톤 타입 사용

import org.stairwaybook.recipe._

object GotApples {
  def main(args: Array[String]) {
    val db: Database =
      if(args(0) == "student")
        StudentDatabase
      else
        SimpleDatabase

    object browser extends Browser {
      val database: db.type = db
    }

    val apple = db.foodNamed("Apple").get

    for(recipe <- browser.recipesUsing(apple))
      println(recipe)

    for (category <- db.allCategories)
      browser.displayCategory(category)
  }
}
