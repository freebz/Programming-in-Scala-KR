// 리스트 13.11  보호 접근이 스칼라와 자바에서 어떻게 다른가?

package p {
  class Super {
    protected def f() { println("f") }
  }
  class Sub extends Super {
    f()
  }
  class Other {
    (new Super).f()  // 오류: f에 접근할 수 없다.
  }
}
