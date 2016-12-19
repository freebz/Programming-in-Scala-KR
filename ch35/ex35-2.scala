// 리스트 35.2  스프레드시트 애플리케이션의 메인 프로그램

package org.stairwaybook.scells
import swing._

object Main extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "ScalaSheet"
    contents = new Spreadsheet(100, 26)
  }
}
