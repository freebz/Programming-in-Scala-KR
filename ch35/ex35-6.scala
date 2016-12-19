// 리스트 35.6  공식을 파싱하는 스프레드시트

package org.stairwaybook.scells

import swing._
import event._

class Spreadsheet(val height: Int, val width: Int) ... {
  val table = new Table(height, width) {
    ...
    reactions += {
      case TableUpdated(table, rows, column) =>
        for (row <- rows)
          cells(row)(column).formula =
            FormulaParsers.parse(userData(row, column))
    }
  } // table 끝
    // 나머지는 그대로
} // Spreadsheet 끝
