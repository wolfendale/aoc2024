def part1(input: String): Long =
  part1(Parser.parse(input))

def part1(reports: List[List[Int]]): Long =
  reports.count { report =>

    val diffs = report.zip(report.tail).map { case (a, b) =>
      b - a
    }

    diffs.forall(a => a <= 3 && a >= -3) && (diffs.forall(_ > 0) || diffs.forall(_ < 0))
  }

def part2(input: String): Long =
  part2(Parser.parse(input))

def part2(reports: List[List[Int]]): Long =
  reports.count { report =>
    possibleReports(report).exists { report =>

      val diffs = report.zip(report.tail).map { case (a, b) =>
        b - a
      }

      diffs.forall(a => a <= 3 && a >= -3) && (diffs.forall(_ > 0) || diffs.forall(_ < 0))
    }
  }

def possibleReports(report: List[Int]): List[List[Int]] =
  report +: report.zipWithIndex.map { case (_, i) =>
    report.patch(i, Seq.empty, 1)
  }

object Parser {

  import atto.*
  import Atto.*

  private val newline: Parser[Any] =
    string("\r\n") | char('\r') | char('\n')

  private val parser: Parser[List[List[Int]]] =
    int.sepBy(spaceChar).sepBy(newline)

  def parse(input: String): List[List[Int]] =
    parser.parseOnly(input).done.option.get
}
