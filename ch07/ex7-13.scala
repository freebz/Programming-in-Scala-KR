// 리스트 7.13  값을 만들어내는 catch 절

import java.net.URL
import java.net.MalformedURLException

def urlFor(path: String) =
  try {
    new URL(path)
  } catch {
    case e: MalformedURLException =>
      new URL("http://www.scala-lang.org")
  }


// 7.4 표현식으로 예외 다루기

def f(): Int = try { return 1 } finally { return 2 }
f()

def g(): Int = try { 1 } finally { 2 }
g()
