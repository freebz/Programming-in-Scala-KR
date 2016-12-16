// 리스트 14.3  Suite를 확장해 테스트 메소드 작성하기

import org.scalatest.Suite
import Element.elem

class ElementSuite extends Suite {

  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}


// 14장 단언문과 단위 테스트

// 14.2 스칼라에서의 단위 테스트

(new ElementSuite).execute()
