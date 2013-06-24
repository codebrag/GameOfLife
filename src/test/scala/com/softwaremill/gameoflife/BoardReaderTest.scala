package com.softwaremill.gameoflife

import org.scalatest.matchers.ShouldMatchers
import org.scalatest.FunSuite
import io.Source

class BoardReaderTest extends FunSuite with ShouldMatchers {

  test("it should load one dead cell board") {
    val b = new BoardReader(Source.fromString(".\n")).toBoard

    b.isCellAlive(Cell(0, 0)) should be(false)
  }

  test("it should load one live cell board") {
    val b = new BoardReader(Source.fromString("X\n")).toBoard

    b.isCellAlive(Cell(0, 0)) should be(true)
  }

  test("it should load square 4 element board") {
    val b = new BoardReader(Source.fromString("X.\n.X")).toBoard

    List((Cell(0, 0), true),
      (Cell(1, 0), false),
      (Cell(0, 1), false),
      (Cell(1, 1), true)
    ).foreach{
      case (c, state) => b.isCellAlive(c) should be(state)
    }
  }
}