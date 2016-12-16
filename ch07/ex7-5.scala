// 리스트 7.5  for 표현식으로 디렉토리 내 파일의 목록 구하기

val filesHere = (new java.io.File(".")).listFiles

for (file <- filesHere)
  println(file)



// 7.3 for 표현식

// 컬렉션 순회

for (i <- 1 to 4)
  println("Iteration "+ i)

// 스칼라에서는 일반적이지 않다.
for (i <- 0 to filesHere.length - 1)
  println(filesHere(i))
