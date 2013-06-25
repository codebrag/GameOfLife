package com.softwaremill.gameoflife.examples

import com.softwaremill.gameoflife.Rectangle

sealed abstract class Example(val boardResource : String, val boundingBox : Option[Rectangle])

case object ToadExample extends Example("/com/softwaremill/gameoflife/boards/toad.board", Some(Rectangle(0,-3,6,3)))

case object BlinkerExample extends Example("/com/softwaremill/gameoflife/boards/blinker.board", None)