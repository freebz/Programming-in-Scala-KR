// 리스트 14.4  FunSuite로 테스트 함수 작성하기

import org.scalatest.FunSuite
import Element.elem

class ElementSuite extends FunSuite {

  test("elem result should have passed width") {
    val ele = elem('x', 2, 3)
    assert(ele.width == 2)
  }
}


// 14.3 실패 보고 시 더 많은 정보 제공하기

assert(ele.width === 2)

expect(2) {
  ele.width
}

intercept[IllegalArgumentException] {
  elem('x', -2, 3)
}


// 14.4 JUnit과 TestNG 사용

import junit.framework.TestCase
import junit.framework.Assert.assertEquals
import junit.framework.Assert.fail
import Element.elem

class ElementTestCase extends TestCase {

  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assertEquals(2, ele.width)
    assertEquals(3, ele.height)
    try {
      elem('x', -2, 3)
      fail()
    }
    catch {
      case e: IllegalArgumentException =>  // 발생하리라 예상
    }
  }
}
