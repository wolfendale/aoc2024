import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

import scala.io.Source

class Day1Spec extends AnyFreeSpec with Matchers {

  private val testInput =
    """3   4
      |4   3
      |2   5
      |1   3
      |3   9
      |3   3""".stripMargin

  private val puzzleInput = Source.fromInputStream(getClass.getResourceAsStream("input.txt")).mkString

  "part1" - {

    "must match the test input" in {
      part1(testInput) mustEqual 11
    }

    "must match the puzzle input" in {
      part1(puzzleInput) mustEqual 1223326
    }
  }

  "part2" - {

    "must match the test input" in {
      part2(testInput) mustEqual 31
    }

    "must match the puzzle input" in {
      part2(puzzleInput) mustEqual 21070419
    }
  }
}
