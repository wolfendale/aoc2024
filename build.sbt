import sbt.Keys.version

lazy val commonSettings = Seq(
  scalaVersion := "3.3.4",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-core" % "2.12.0",
    "org.tpolecat" %% "atto-core" % "0.9.5",
    "org.scalactic" %% "scalactic" % "3.2.19",
    "org.scalatest" %% "scalatest" % "3.2.19" % "test"
  )
)

lazy val root = (project in file("."))
  .settings(
    name := "aoc2024",
    version := "0.1",
    scalaVersion := "3.3.4"
  )

lazy val dayOne = (project in file("day-01"))
  .settings(
    name := "day one",
    commonSettings
  )

lazy val dayTwo = (project in file("day-02"))
  .settings(
    name := "day two",
    commonSettings
  )

lazy val dayThree = (project in file("day-03"))
  .settings(
    name := "day three",
    commonSettings
  )

lazy val dayFour = (project in file("day-04"))
  .settings(
    name := "day four",
    commonSettings
  )
