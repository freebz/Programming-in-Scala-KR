// 리스트 15.19  패턴과 매치하는 리스트 원소 고르기

val results = List(Some("apple"), None,
  Some("orange"))
for (Some(fruit) <- results) println(fruit)
