package com.softwaremill.gameoflife

import io.Source

class BoardReader(source: Source,
                  liveMark: Char = 'X',
                  deadMark: Char = '.',
                  startPosition: Cell = Cell(0, 0)) {

  private lazy val liveCells: Set[Cell] = {
    val commentPredicate = (line: String) => {
      List("#", "//", ";").exists(line.trim.startsWith(_))
    }

    val linesWithIndex = source.getLines.withFilter(!commentPredicate(_)).zipWithIndex

    linesWithIndex.flatMap[Cell] {
      case (s, i) => {
        s.zipWithIndex.withFilter{
          case (c, j) => c == liveMark
        }.map{
          case (c, j) => Cell(j, i)
        }.iterator
      }
    }.toSet
  }

  def toBoard() = new Board(liveCells)


}