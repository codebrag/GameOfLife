package com.softwaremill.gameoflife

import org.scalatest.FunSpec
import org.scalatest.matchers.ShouldMatchers

class BoardTest extends FunSpec with ShouldMatchers {

  describe("A Board with a single live cell in the centre") {
    val board = Board(Cell(0, 0))

    it("should see the (0,0) cell as alive") {
      board.isCellAlive(Cell(0, 0))
    }

    it("should kill the (0,0) in the next iteration") {
      board.next.isCellAlive(Cell(0, 0)) should be(false)
    }
  }

  describe("A Board with a blinker") {
    val board = Board(Cell(-1, 0), Cell(0, 0), Cell(1, 0))
    it("should oscillate") {
      val nextBoard = board.next

      nextBoard.isCellAlive(Cell(0, 0)) should be(true)
      nextBoard.isCellAlive(Cell(0, -1)) should be(true)
      nextBoard.isCellAlive(Cell(0, 1)) should be(true)

      // now check the ones that should be dead
      nextBoard.isCellAlive(Cell(-1, 0)) should be(false)
      nextBoard.isCellAlive(Cell(1, 0)) should be(false)
    }
  }

  describe("Board's bounding box") {
    it("should be formed from edge points") {
      val board = Board(Cell(-1, -2), Cell(1, 2))

      board.boundingBox should be === (Rectangle(-1, -2, 1, 2))
    }

    it("should be sane (0,0,0,0) if no cells are present") {
      val board = Board()
      board.boundingBox should be === (Rectangle(0, 0, 0, 0))
    }
  }
}

class CellTest extends FunSpec with ShouldMatchers {

  it("should list its neighbours") {
    val c = Cell(0, 0)
    val neighbours = c.neighbours

    /* A cell always has 8 neighbours */
    neighbours.length should equal(8)
    val expectedNeighbours = List(
      Cell(-1, -1),
      Cell(-1, 0),
      Cell(-1, 1),
      Cell(0, -1),
      Cell(0, 1),
      Cell(1, -1),
      Cell(1, 0),
      Cell(1, 1)
    )
    expectedNeighbours.forall(neighbours.contains(_)) should be(true)
  }

}