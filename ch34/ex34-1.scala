// 리스트 34.1  간단한 스칼라 스윙 애플리케이션

import scala.swing._

object FirstSwingApp extends SimpleGUIApplication {
  def top = new MainFrame {
    title = "First Swing App"
    contents = new Button {
      text = "Click me"
    }
  }
}
