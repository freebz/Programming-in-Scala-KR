// 9장 흐름 제어 추상화

// 9.1 코드 중복 줄이기

object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def filesEnding(query: String) =
    for (file <- filesHere; if file.getName.endsWith(query))
    yield file

  def filesContaining(query: String) =
    for (file <- filesHere; if file.getName.contains(query))
    yield file

  def filesRegex(query: String) =
    for (file <- filesHere; if file.getName.matches(query))
    yield file
}


object FileMatcher {
  private def filesHere = (new java.io.File(".")).listFiles

  def filesMatcher(query: String,
    matcher: (String, String) => Boolean) = {

    for (file <- filesHere; if matcher(file.getName, query))
    yield file
  }

  def filesEnding(query: String) =
    filesMatcher(query, _.endsWith(_))

  def filesContaining(query: String) =
    filesMatcher(query, _.contains(_))

  def filesRegex(query: String) =
    filesMatcher(query, _.matches(_))
}
