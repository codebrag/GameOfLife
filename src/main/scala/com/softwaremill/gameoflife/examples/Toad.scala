package com.softwaremill.gameoflife.examples

import com.softwaremill.gameoflife.{Rectangle, BoardPrinter, BoardReader}
import scala.io.Source

object Toad extends App {
  val toadReader = new BoardReader(Source.fromInputStream(getClass.getResourceAsStream(
    "/com/softwaremill/gameoflife/boards/toad.board"), "UTF-8"))

  val toadInitialBoard = toadReader.toBoard

  val consecutiveBoards = (1 to 3).foldLeft(List(toadInitialBoard))((acc, index) => {
    acc.head.next :: acc
  }).reverse

  consecutiveBoards.zipWithIndex.foreach {
    case (b, i) => (print("Iteration " + i + ":\n" + new BoardPrinter(b).print(boundingBox = Rectangle(0,-3,6,3))))
  }
}
