package com.softwaremill.gameoflife

class BoardPrinter(b: Board,
                   liveMark: Char = 'X',
                   deadMark: Char = '.') {

  def print(boundingBox: Rectangle = b.boundingBox) = {
    val s = new StringBuilder
    for (yIter <- (boundingBox.y1 to boundingBox.y2)) {
      for (xIter <- (boundingBox.x1 to boundingBox.x2)) {
        s.append(if (b.isCellAlive(Cell(xIter, yIter))) liveMark else deadMark)
      }
      s.append('\n')
    }
    s.toString
  }
}