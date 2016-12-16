// 리스트 13.14  패키지 객체

// bobsdelights/package.scala 파일
package object bobsdelights {
  def showFruit(fruit: Fruit) {
    import fruit._
    println(name +"s are "+ color)
  }
}

// PrintMenu.scala 파일
package printmenu
import bobsdelights.Fruits
import bobsdelights.showFruit

object PrintMenu {
  def main(args: Array[String]) {
    for (fruit <- Fruits.menu) {
      showFruit(fruit)
    }
  }
}
