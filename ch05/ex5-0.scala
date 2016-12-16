// 5장 기본 타입과 연산

// 5.2 리터럴

// 정수 리터럴

val hex = 0x5
val hex2 = 0x00FF
val magic = 0xcafebabe

val oct = 035  // 8진수 35는 10진수로 29임
val nov = 0777
val dec = 0321

val dec1 = 31
val dec2 = 255
val dec3 = 20

val prog = 0XCAFEBABEL
val tower = 35L
val of = 31l

val little: Short = 367
val littler: Byte = 38


// 부동소수점 리터럴

val big = 1.2345
val bigger = 1.2345e1
val biggerStill = 123E45

val little = 1.2345F
val littleBigger = 3e5f

val anotherDouble = 3e5
val yetAnother = 3e5D


// 문자 리터럴

val a = 'A'
val c = '\101'
val d = '\u0041'
val f = '\u0044'
val B\u0041\u0044 = 1
val backslash = '\\'


// 문자열 리터럴

val hello = "hello"
val escape = "\\\"\'"
println("""Welcome to Ultamix 3000.
           Type "HELP" for help.""")
println("""|Welcome to Ultamix 3000.
           |Type "HELP" for help.""".stripMargin)


// 심볼 리터럴

'cymbal
Symbol("cymbal")

def updateRecordByName(r: Symbol, value: Any) {
  // 코드가 들어감
}
updateRecordByName(favoriteAlbum, "OK Computer")
updateRecordByName('favoriteAlbum, "OK Computer")

val s = 'aSymbol
s.name


// 불리언 리터럴

val bool = true
val fool = false


// 5.3 연산자는 메소드다

val sum = 1 + 2  // 스칼라는 (1).+(2)를 호출한다.
val sumMore = (1).+(2)
val longSum = 1 + 2L  // 스칼라는 (1).+(2L)을 호출한다.

val s = "Hello, world!"
s indexOf 'o'  // 스칼라는 s.indexOf('o')를 호출한다.
s indexOf ('o', 5)  // 스칼라는 s.indexOf('o', 5)를 호출한다.

-2.0
(2.0).unary_-

val s = "Hello,world!"
s.toLowerCase
s toLowerCase


// 5.4 산술 연산

1.2 + 2.3
3 - 1
'b' - 'a'
2L * 3L
11 / 4
11 % 4
11.0f / 4.0f
11.0 % 4.0

math.IEEEremainder(11.0, 4.0)

val neg = 1 + -3
val y = +3
-neg


// 5.5 관계 및 논리 연산

1 > 2
1 < 2
1.0 <= 1.0
3.5f >= 3.6f
'a' >= 'A'
val thisIsBoring = !true
!thisIsBoring

val toBe = true
val question = toBe || !toBe
val paradox = toBe && !toBe

def salt() = { println("salt"); false }
def pepper() = { println("pepper"); true }
pepper() && salt()
salt() && pepper()


// 5.6 비트 연산

1 & 2
1 | 2
1 ^ 3
~1

-1 >> 31
-1 >>> 31
1 << 2


// 5.7 객체 동일성

1 == 2
1 != 2
2 == 2

List(1, 2, 3) == List(1, 2, 3)
List(1, 2, 3) == List(4, 5, 6)

1 == 1.0
List(1, 2, 3) == "hello"

List(1, 2, 3) == null
null == List(1, 2, 3)

("he"+"llo") == "hello"


// 5.8 연산자 우선순위와 결합 법칙

2 << 2 + 2
2 + 2 << 2
