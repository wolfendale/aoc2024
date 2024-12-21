def part1(input: String): Long =
  part1.tupled(Parser.parse(input))

def part1(as: List[Int], bs: List[Int]): Long =
  as.sorted.zip(bs.sorted).foldLeft(0) { case (m, (a, b)) =>
    m + (a - b).abs
  }

def part2(input: String): Long =
  part2.tupled(Parser.parse(input))

def part2(as: List[Int], bs: List[Int]): Long = {

  val frequencies = bs.groupMapReduce(identity)(_ => 1)(_ + _).withDefaultValue(0)

  as.foldLeft(0) { (m, n) =>
    m + n * frequencies(n)
  }
}

object Parser {

  import atto.*
  import Atto.*

  private val newline: Parser[Any] =
    string("\r\n") | char('\r') | char('\n')

  private val parser: Parser[(List[Int], List[Int])] =
    ((int ~ (spaceChar.many ~> int)).sepBy(newline) <~ endOfInput)
      .map(a => a.unzip)

  def parse(input: String): (List[Int], List[Int]) =
    parser.parseOnly(input).done.option.get
}
