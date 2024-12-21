import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.must.Matchers

import scala.io.Source

class Day4Spec extends AnyFreeSpec with Matchers {

  private val testInput = """MMMSXXMASM
                            |MSAMXMSMSA
                            |AMXSXMAAMM
                            |MSAMASMSMX
                            |XMASAMXAMM
                            |XXAMMXXAMA
                            |SMSMSASXSS
                            |SAXAMASAAA
                            |MAMMMXMMMM
                            |MXMXAXMASX""".stripMargin

  private val puzzleInput = Source.fromInputStream(getClass.getResourceAsStream("input.txt")).mkString

  "part1" - {

    "must match the test input" in {
      part1(testInput) mustEqual 18
    }

    "must match the puzzle input" in {
      part1(puzzleInput) mustEqual 2493
    }
  }

  "part2" - {

    "must match the test input" in {
      part2(testInput) mustEqual 9
    }

    "must match the puzzle input" in {
      part2(puzzleInput) mustEqual 1890
    }
  }
}
