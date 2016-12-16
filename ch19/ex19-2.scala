// 리스트 19.2  private를 사용해 주 생성자 숨기기

class Queue[T] private (
  private val leading: List[T],
  private val trailing: List[T]
)



// 19.2 정보 은닉

// 비공개 생성자와 팩토리 메소드

new Queue(List(1, 2), List(3))
