// 리스트 8.3  디폴트 값이 있는 파라미터

def printTime(out: java.io.PrintStream = Console.out) =
  out.println("time = "+ System.currentTimeMillis())



// 디폴트 인자 값

printTime()
printTime(Console.err)
