package com.softwaremill.gameoflife

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSpec
import io.Source

class BoardReaderTest extends FunSpec with ShouldMatchers {

  describe("A BoardReader") {
    it("should load a board containing one dead cell") {
      val b = new BoardReader(Source.fromString(".\n")).toBoard

      b.isCellAlive(Cell(0, 0)) should be(false)
    }

    it("should load a board containing one live cell") {
      val b = new BoardReader(Source.fromString("X\n")).toBoard

      b.isCellAlive(Cell(0, 0)) should be(true)
    }

    it("should load a square 4 element board") {
      val b = new BoardReader(Source.fromString("X.\n.X")).toBoard

      List((Cell(0, 0), true),
        (Cell(1, 0), false),
        (Cell(0, 1), false),
        (Cell(1, 1), true)
      ).foreach{
        case (c, deadOrAlive) => b.isCellAlive(c) should be(deadOrAlive)
      }
    }
  }

}