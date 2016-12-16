// 리스트 14.5  JUnit3Suite로 테스트 작성하기

import org.scalatest.junit.JUnit3Suite
import Element.elem

class ElementSuite extends JUnit3Suite {

  def testUniformElement() {
    val ele = elem('x', 2, 3)
    assert(ele.width === 2)
    expect(3) { ele.height }
    intercept[IllegalArgumentException] {
      elem('x', -2, 3)
    }
  }
}



import org.testng.annotations.Test
import org.testng.Assert.assertEquals
import Element.elem

class ElementTests {
  @Test def verifyUniformElement() {
    val ele = elem('x', 2, 3)
    assertEquals(ele.width, 2)
    assertEquals(ele.height, 3)
  }
  @Test(
    expectedExceptions =
      Array(classOf[IllegalArgumentException])
  )
  def elemShouldThrowIAE() { elem('x', -2, 3) }
}
