// 리스트 7.4  재귀를 사용한 최대공약수 계산

def gcd(x: Long, y: Long): Long =
  if (y == 0) x else gcd(y, x % y)
