// 리스트 13.8  일반 객체(싱글톤이 아닌)의 맴버 임포트

def showFruit(fruit: Fruit) {
  import fruit._
  println(name +"s are "+ color)
}
