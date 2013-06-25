package com.softwaremill.gameoflife.examples

import com.softwaremill.gameoflife.{BoardPrinter, BoardReader}
import scala.io.Source

class ExampleRunner(val example: Example) {
  val toadReader = new BoardReader(Source.fromInputStream(getClass.getResourceAsStream(example.boardResource), "UTF-8"))

  val toadInitialBoard = toadReader.toBoard

  val consecutiveBoards = (1 to 3).foldLeft(List(toadInitialBoard))((acc, index) => {
    acc.head.next :: acc
  }).reverse

  consecutiveBoards.zipWithIndex.foreach {
    case (b, i) => {
      val boardPrinter = new BoardPrinter(b)
      val printedBoard = example.boundingBox match {
        case Some(boundingBox) => boardPrinter.print(boundingBox)
        case None => boardPrinter.print()
      }
      print("Iteration " + i + ":\n" + printedBoard)
    }
  }
}
