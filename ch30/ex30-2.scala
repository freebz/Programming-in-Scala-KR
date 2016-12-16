// 리스트 30.2  canEqual을 호출하는 서브클래스 equlas 메소드

class ColoredPoint(x: Int, y: Int, val color: Color.Value) extends
    Point(x, y) {

  override def hashCode = 41 * super.hashCode + color.hashCode
  override def equals(other: Any) = other match {
    case that: ColoredPoint =>
      (that canEqual this) &&
      super.equals(that) && this.color == that.color
    case _ =>
      false
  }
  override def canEqual(other: Any) =
    other.isInstanceOf[ColoredPoint]
}



val p = new Point(1, 2)
val cp = new ColoredPoint(1, 2, Color.Indigo)
val pAnon = new Point(1, 1) { override val y = 2 }
val coll = List(p)
coll contains p
coll contains cp
coll contains pAnon
