// 리스트 35.9  마지막 스프레드시트 구현

package org.stairwaybook.scells

import swing._, event._

class Spreadsheet(val height: Int, val width: Int)
    extends ScrollPane {

  val cellModel = new Model(height, width)
  import cellModel._

  val table = new Table(height, width)
    ... // 리스트 35.1과 같은 설정

  override def rendererComponent(
    isSelected: Boolean, hasFocus: Boolean,
    row: Int, column: Int) =
    ... // 리스트 35.3과 같음

  def userData(row: Int, column: Int): String =
    ... // 리스트 35.3과 같음
    reactions += {
      case TableUpdated(table, rows, column) =>
        for (row <- rows)
          cells(row)(column).formula =
            FormulaParsers.parse(userData(row, column))
      case ValueChanged(cell) =>
        updateCell(cell.row, cell.column)
    }
  for (row <- cells; cell <- row) listenTo(cell) {
  }

  val rowHeader = new ListView(0 until height) {
    fixedCellWidth = 30
    flxedCellHeight = table.rowHeight
  }

  viewportView = table
  rowHeaderView = rowHeader
}
