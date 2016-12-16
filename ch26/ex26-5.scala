// 리스트 26.5  ExpandedEMail 익스트랙터 객체

object ExpandedEMail {
  def unapplySeq(email: String)
      : Option[(String, Seq[String])] = {
    val parts = email split "@"
    if (parts.length == 2)
      Some(parts(0), parts(1).split("\\.").reverse)
    else
      None
  }
}



val s = "tom@support.dpfl.ch"
val ExpandedEMail(name, topdom, subdoms @ _*) = s
