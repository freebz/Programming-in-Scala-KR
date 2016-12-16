// 리스트 7.9  for 표현식의 흐름 중간에 값 할당하기

def grep(pattern: String) =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
    line <- fileLines(file)
    trimmed = line.trim
    if trimmed.matches(pattern)
  } println(file +": "+ trimmed)

grep(".*gcd.*")


// 새로운 컬렉션 만들어내기

def scalaFiles =
  for {
    file <- filesHere
    if file.getName.endsWith(".scala")
  } yield file
