// 리스트 8.4  두 디폴트 인자를 가진 함수

def printTime2(out: java.io.PrintStream = Console.out,
  divisor: Int = 1) =
  out.println("time = "+ System.currentTimeMillis()/divisor)



printTime2()
printTime2(out = Console.err)
printTime2(divisor = 1000)


// 8.9 꼬리 재귀

def approximate(guess: Double): Double =
  if (isGoodEnough(guess)) guess
  else approximate(improve(guess))

def approximateLoop(initialGuess: Double): Double = {
  var guess = initialGuess
  while (!isGoodEnough(guess))
    guess = improve(guess)
  guess
}


// 꼬리 재귀 함수 추적

def boom(x: Int): Int = {
  if (x == 0) throw new Exception("boom!")
  else boom(x - 1) + 1
}

boom(3)

def bang(x: Int): Int = {
  if (x == 0) throw new Exception("bang!")
  else bang(x - 1)
}

bang(5)


// 꼬리 재귀의 한계

def isEven(x: Int): Boolean =
  if (x == 0) true else isOdd(x - 1)
def isOdd(x: Int): Boolean =
  if (x == 0) false else isEven(x - 1)

val funValue = nestedFun _
def nestedFun(x: Int) {
  if (x != 0) { println(x); funValue(x - 1) }
}
