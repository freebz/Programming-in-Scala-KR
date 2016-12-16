// 25.3 새 컬렉션 통합

// 시퀀스 통합

val xs = List(A, G, C, A)
RNA1.fromSeq(xs)
val rna1 = RNA1(A, U, G, G, C)


// RNA 메소드의 결과 타입 변환

rna1.length
rna1.last
rna1.take(3)

val rna2 = RNA2(A, U, G, G, C)
rna2 take 3
rna2 filter (U != _)


// map과 친구들 다루기

val rna = RNA(A, U, G, G, C)
rna map { case A => C case b => b }

rna ++ rna

rna map Base.toInt
rna ++ List("missing", "data")


val rna2 = RNA2(A, U, G, G, C)
rna2 map { case A => C case b => b }

rna2 ++ rna2


// 새로운 집합과 맵 통합

val m = PrefixMap("abc" -> 0, "abd" -> 1, "al" -> 2,
  "all" -> 3, "xy" -> 4)

m withPrefix "a"


val res0 = PrefixMap("hello" -> 5, "hi" -> 2)
PrefixMap.empty[String]

res0 map { case (k, v) => (k + "!", "x" * v) }
