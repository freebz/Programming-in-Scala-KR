// 리스트 7.3  do-while로 표준 입력 읽기

var line = ""
do {
  line = readLine()
  println("Read: "+ line)
} while (line != "")


// 7.2 while 루프

def greet() { println("hi") }
greet() == ()


var line = ""
while ((line = readLine()) != "")  // 작동하지 않음!
  println("Read: "+ line)
