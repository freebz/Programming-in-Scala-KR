// 리스트 7.18  곱셈을 표로 출력하는 코드에서의 변수 스코프

def printMultiTable() {

  var i = 1
  // i만이 스코프 안에 있다.

  while (i <= 10) {

    var j = 1
    // 여기서는 i와 j가 스코프 안에 있다.

    while (j <= 10) {
      val prod = (i * j).toString
      // i, j, prod가 스코프 안에 있다.

      var k = prod.length
      // i, j, prod, k가 모두 스코프 안에 있다.

      while (k < 4) {
        print(" ")
        k += 1
      }

      print(prod)
      j += 1
    }

    // i와 j는 여전히 스코프 안이지만, prod와 k는 스코프를 벗어난다.
    println()
    i += 1
  }

  // i는 여전히 스코프 안이지만, j, prod, k는 스코프를 벗어난다.
}
