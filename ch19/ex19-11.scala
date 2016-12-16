// 리스트 19.11  Ordered 트레이트를 혼합하는 Person 클래스

class Person(val firstName: String, val lastName: String) extends
    Ordered[Person] {

  def compare(that: Person) = {
    val lastNameComparison =
      lastName.compareToIgnoreCase(that.lastName)
    if (lastNameComparison != 0)
      lastNameComparison
    else
      firstName.compareToIgnoreCase(that.firstName)
  }
  override def toString = firstName +" "+ lastName
}



// 19.8 상위 바운드

val robert = new Person("Robert", "Jones")
val sally = new Person("Sally", "Smith")
robert < sally
