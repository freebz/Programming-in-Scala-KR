// 리스트 9.1  코드 중복을 줄이기 위한 클로저 사용

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  private def filesMatcher(matcher: String => Boolean) =
    for (file <- filesHere; if matcher(file.getName))
    yield file

  def filesEnding(query: String) =
    filesMatcher(_.endsWith(query))

  def filesContaining(query: String) =
    filesMatcher(_.contains(query))

  def filesRegex(query: String) =
    filesMatcher(_.matches(query))
}


// 9.2 클라이언트 코드 단순하게 만들기

def containsNeg(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num < 0)
      exists = true
  exists
}

containsNeg(List(1, 2, 3, 4))
containsNeg(List(1, 2, -3, 4))

def containsNeg(nums: List[Int]) = nums.exists(_ < 0)
containsNeg(Nil)
containsNeg(List(0, -1, -2))

def containsOdd(nums: List[Int]): Boolean = {
  var exists = false
  for (num <- nums)
    if (num % 2 == 1)
      exists = true
  exists
}

def containsOdd(nums: List[Int]) = nums.exists(_ % 2 == 1)
