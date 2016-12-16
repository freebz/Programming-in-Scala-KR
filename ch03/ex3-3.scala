// 리스트 3.3  리스트 만들고 초기화하기

val oneTwoThree = List(1, 2, 3)


val oneTwo = List(1, 2)
val threeFour = List(3, 4)
val oneTwoThreeFour = oneTwo ::: threeFour
println(oneTwo +" and "+ threeFour +" were not mutated.")
println("Thus, "+ oneTwoThreeFour +" is a new list.")


val twoThree = List(2, 3)
val oneTwoThree= 1 :: twoThree
println(oneTwoThree)


val oneTwoThree = 1 :: 2 :: 3 :: Nil
println(oneTwoThree)
