package com.softwaremill.gameoflife

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec

class BoardPrinterTest extends FunSpec with ShouldMatchers {

  describe("A BoardPrinter") {

    it("should print a box with one live cell in the centre") {
      val board = Board(Cell(0, 0))
      val boardPrinter = new BoardPrinter(board)

      boardPrinter.print().stripLineEnd should be === ("X")
    }

    it("should print one dead cell if no cells are alive") {
      val board = Board()
      val boardPrinter = new BoardPrinter(board)

      boardPrinter.print().stripLineEnd should be === (".")
    }
  }
}