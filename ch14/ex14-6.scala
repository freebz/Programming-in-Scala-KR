// 리스트 14.6  TestNGSuite로 TestNG 테스트 작성하기

import org.scalatest.testng.TestNGSuite
import org.testng.annotation.Test
import Element.elem

class ElementSuite extends TEstNGSuite {

  @Test def verifyUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width ===2)
    expect(3) { ele.height }
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }
}
