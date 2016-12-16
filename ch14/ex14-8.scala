// 리스트 14.8  specs 프레임워크로 동작을 명세화하고 테스트하기

import org.specs._
import Element.elem

object ElementSpecification extends Specification {
  "A UniformElement" should {
    "have a width equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.width must be_==(2)
    }
    "have a height equal to the passed value" in {
      val ele = elem('x', 2, 3)
      ele.height must be_(3)
    }
    "throw an IAE if passed a negative width" in {
      elem('x', -2, 3) must
      throwA[IllegalArgumentException]
    }
  }
}
