final case class Board(data: Vector[Vector[Char]]) {

  val height: Int = data.length
  val width: Int = data(0).length

  def get(x: Int, y: Int): Option[Char] =
    data.lift(y).flatMap(_.lift(x))

  def get(coords: (Int, Int)*): String =
    coords.flatMap(get.tupled).mkString
}

def part1(input: String): Long =
  part1(Parser.parse(input))

def part1(board: Board): Long =
  (0 until board.height).foldLeft(0) { (m, y) =>
    m + (0 until board.width).foldLeft(0) { (n, x) =>
      n + Seq(
        board.get((x, y), (x + 1, y), (x + 2, y), (x + 3, y)),
        board.get((x, y), (x, y + 1), (x, y + 2), (x, y + 3)),
        board.get((x, y), (x + 1, y + 1), (x + 2, y + 2), (x + 3, y + 3)),
        board.get((x, y), (x + 1, y - 1), (x + 2, y - 2), (x + 3, y - 3)),
      ).count(s => s == "XMAS" || s == "SAMX")
    }
  }

def part2(input: String): Long =
  part2(Parser.parse(input))

def part2(board: Board): Long =
  (0 until board.height).foldLeft(0) { (m, y) =>
    m + (0 until board.width).foldLeft(0) { (n, x) =>

      val isXmas = Seq(
        board.get((x - 1, y - 1), (x, y), (x + 1, y + 1)),
        board.get((x - 1, y + 1), (x, y), (x + 1, y - 1))
      ).count(s => s == "MAS" || s == "SAM") == 2

      n + (if isXmas then 1 else 0)
    }
  }

object Parser {

  import atto.*
  import Atto.*

  private val newline: Parser[Any] =
    string("\r\n") | char('\r') | char('\n')

  private val parser: Parser[Board] =
    letter.many.map(_.toVector)
      .sepBy(newline).map(data => Board(data.toVector))

  def parse(input: String): Board =
    parser.parseOnly(input).done.option.get
}
