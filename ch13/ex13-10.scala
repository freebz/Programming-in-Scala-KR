// 리스트 13.10  비공개 접근이 자바와 스칼라에서 어떻게 다른가?

class Outer {
  class Inner {
    private def f() { println("f") }
    class InnerMost {
      f()  // 문제없음
    }
  }
  (new Inner).f()  // 오류: f를 찾을 수 없음
}
