import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

import scala.io.Source

class Day3Spec extends AnyFreeSpec with Matchers {

  private val puzzleInput = Source.fromInputStream(getClass.getResourceAsStream("input.txt")).mkString

  "part1" - {

    "must match the test input" in {

      val testInput =
        """xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))""".stripMargin

      part1(testInput) mustEqual 161
    }

    "must match the puzzle input" in {
      part1(puzzleInput) mustEqual 183788984
    }
  }

  "part2" - {

    "must match the test input" in {

      val testInput =
        """xmul(2,4)&mul[3,7]!^don't()_mul(5,5)+mul(32,64](mul(11,8)undo()?mul(8,5))""".stripMargin

      part2(testInput) mustEqual 48
    }

    "must match the puzzle input" in {
      part2(puzzleInput) mustEqual 0
    }
  }
}
