// 리스트 7.6  필터를 이용해 .scala 파일 찾기

val filesHere = (new java.io.File(".")).listFiles

for (file <- filesHere if file.getName.endsWith(".scala"))
  println(file)



// 필터링

for (file <- filesHere)
  if (file.getName.endsWith(".scala"))
    println(file)
