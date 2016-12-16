// 1장 확장 가능한 언어

// 1.1 점점 여러분의 마음에서 자라가는 언어

var capital = Map("US" -> "Washington", "France" -> "Paris")
capital += ("Japan" -> "Tokyo")
println(capital("France"))


def factorial(x: BigInt): BigInt =
  if (x == 0) 1 else x * factorial(x - 1)

factorial(30)


import java.math.BigInteger

def factorial(x: BigInteger): BigInteger = {
  if (x == BigInteger.ZERO)
    BigInteger.ONE
  else
    x.multiply(factorial(x.subtract(BigInteger.ONE)))
}


actor {
  var sum = 0
  loop {
    receive {
      case Data(bytes)       => sum += hash(bytes)
      case GetSum(requester) => requester ! sum
    }
  }
}


// 스칼라는 간결하다

// 자바 코드
class MyClass {
  private int index;
  private String name;

  public MyClass(int index, String name) {
    this.index = index;
    this.name = name;
  }
}

class MyClass(index: Int, name: String)


// 스칼라는 고수준이다

// 자바코드
boolean nameHasUpperCase = false;
for (int i = 0; i < name.length(); ++i) {
  if (Character.isUpperCase(name.charAt(i))) {
    nameHasUpperCase = true;
    break;
  }
}

val nameHasUpperCase = name.exists(_.isUpper)

// 자바 코드
interface CharacterProperty {
  boolean hasProperty(char ch);
}

// 자바 코드
exists(name, new CharacterProperty() {
  public boolean hasProperty(char ch) {
    return Character.isUpperCase(ch);
  }
});
