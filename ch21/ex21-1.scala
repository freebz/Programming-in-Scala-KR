// 리스트 21.1  여러 파라미터가 있는 암시적 파라미터 목록

class PreferredPrompt(val preference: String)
class PreferredDrink(val preference: String)

object Greeter {
  def greet(name: String)(implicit prompt: PreferredPrompt,
    drink: PreferredDrink) {

    println("Welcome, "+ name +". The system is ready.")
    print("But while you work, ")
    println("why not enjoy a cup of "+ drink.preference +"?")
    println(prompt.preference)
  }
}

object JoesPrefs {
  implicit val prompt = new PreferredPrompt("Yes, master> ")
  implicit val drink = new PreferredDrink("tea")
}



Greeter.greet("Joe")

import JoesPrefs._

Greeter.greet("Joe")(prompt, drink)
Greeter.greet("Joe")
