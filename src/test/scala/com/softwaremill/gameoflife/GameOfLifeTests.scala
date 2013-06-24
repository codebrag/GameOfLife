package com.softwaremill.gameoflife

import org.scalatest.Suites

class GameOfLifeTests
  extends Suites(
    new BoardTest(),
    new CellTest(),
    new BoardReaderTest()
  )