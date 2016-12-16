// 리스트 20.9  음식을 추상 타입으로 더 잘 모델링하기

class Food
abstract class Animal {
  type SuitableFood <: Food
  def eat(food: SuitableFood)
}
