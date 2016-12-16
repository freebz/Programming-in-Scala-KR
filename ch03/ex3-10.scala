// 리스트 3.10  파일에서 줄 단위로 내용 읽기

import scala.io.Source

if (args.length > 0) {
  for (line <- Source.fromFile(args(0)).getLines())
    println(line.length +" "+ line)
}
else
  Console.err.println("Please enter filename")
