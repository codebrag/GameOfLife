import sbt._
import sbt.Keys._

object GameOfLifeBuild extends Build {

  lazy val gofcbr = Project(
    id = "GameOfLife",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "GameOfLife",
      organization := "com.softwaremill",
      version := "0.1-SNAPSHOT",
      scalaVersion := "2.10.2",
      libraryDependencies += "org.scalatest" % "scalatest_2.10" % "1.9.1" % "test"
    )
  )
}
