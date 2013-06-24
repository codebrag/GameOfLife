package com.softwaremill.gameoflife

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite

class BoardPrinterTest extends FunSuite with ShouldMatchers {

  test("a box with one cell in the centre") {
    val b = Board(Cell(0, 0))
    val bp = new BoardPrinter(b)

    bp.print() should be ===("X\n")
  }
}