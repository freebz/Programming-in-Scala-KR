// 리스트 7.17  var를 사용해 루프를 도는 대신 재귀를 사용한 코드

def searchFrom(i: Int): Int =
  if (i >= args.length) -1
  else if (args(i).startsWith("-")) searchFrom(i + 1)
  else if (args(i).endsWith(".scala")) i
  else searchFrom(i + 1)

val i = searchFrom(0)



import scala.util.control.Breaks._
import java.io._

val in = new BufferedREader(new InputStreamReader(System.in))

breakable {
  while (true) {
    println("? ")
    if (in.readLine() == "") break
  }
}
