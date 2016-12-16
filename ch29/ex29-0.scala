// 29장 객체를 사용한 모듈화 프로그래밍

// 29.2 조리법 애플리케이션

import org.stairwaybook.recipe._

val apple = SimpleDatabase.foodNamed("Apple").get
SimpleBrowser.recipesUsing(apple)


// 29.6 모듈 인스턴스 추적

val category = StudentDatabase.allCategories.head
SimpleBrowser.displayCategory(category)
