// 리스트 7.2  최대공약수를 계산하는 while 루프

def gcdLoop(x: Long, y: Long): Long = {
  var a = x
  var b = y
  while (a != 0) {
    val temp = a
    a = b%a
    b = temp
  }
  b
}
