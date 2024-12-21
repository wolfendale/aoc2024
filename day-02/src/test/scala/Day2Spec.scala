import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

import scala.io.Source

class Day2Spec extends AnyFreeSpec with Matchers {

  private val testInput =
    """7 6 4 2 1
      |1 2 7 8 9
      |9 7 6 2 1
      |1 3 2 4 5
      |8 6 4 4 1
      |1 3 6 7 9""".stripMargin

  private val puzzleInput = Source.fromInputStream(getClass.getResourceAsStream("input.txt")).mkString

  "part1" - {

    "must match the test input" in {
      part1(testInput) mustEqual 2
    }

    "must match the puzzle input" in {
      part1(puzzleInput) mustEqual 483
    }
  }

  "part2" - {

    "must match the test input" in {
      part2(testInput) mustEqual 4
    }

    "must match the puzzle input" in {
      part2(puzzleInput) mustEqual 528
    }
  }
}
