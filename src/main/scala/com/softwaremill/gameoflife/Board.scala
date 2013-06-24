package com.softwaremill.gameoflife

object Board {
  def apply(cells: Cell*) = new Board(cells.toSet)
}

class Board private[gameoflife](private[gameoflife] val cells: Set[Cell]) {

  def isCellAlive(c: Cell) = cells.contains(c)

  private def candidateCells = cells.flatMap(_.neighbours)

  def next = new Board(candidateCells.filter(c => {
    val boardCell = c.on(this)
    val liveNeighbours = boardCell.liveNeighbourCount
    (boardCell.isAlive && liveNeighbours == 2) || liveNeighbours == 3
  }))

}

case class Cell(x: Int, y: Int) {
  def neighbours = {
    for (i <- (x - 1 to x + 1);
         j <- (y - 1 to y + 1) if !(i == x && j == y)) yield Cell(i, j)
  }

  def on(b: Board) = new BoardCell(this, b)
}

class BoardCell(val cell: Cell, val board: Board) extends Cell(cell.x, cell.y) {
  def isAlive = board.isCellAlive(this)

  def liveNeighbourCount = neighbours.count(_.on(board).isAlive)
}
