enum Instruction {
  case Mul(a: Int, b: Int)
  case Do
  case Dont
}

def part1(input: String): Long =
  part1(Part1Parser.parse(input))

def part1(muls: List[(Int, Int)]): Long =
  muls.foldLeft(0) { case (m, (a, b)) =>
    m + (a * b)
  }

def part2(input: String): Long =
  part2(Part2Parser.parse(input))


def part2(instructions: List[Instruction]): Long = {
  println(instructions)
  instructions.foldLeft((true, 0)) {
    case ((true, m), Instruction.Mul(a, b)) => (true, m + (a * b))
    case ((false, m), Instruction.Do)       => (true, m)
    case ((true, m), Instruction.Dont)      => (false, m)
    case ((s, m), _)                        => (s, m)
  }._2
}

object Part1Parser {

  import atto.*
  import Atto.*

  private val newline: Parser[Any] =
    string("\r\n") | char('\r') | char('\n')

  private val mul: Parser[(Int, Int)] =
    string("mul(") ~> (int ~ (char(',') ~> int)) <~ char(')')

  private lazy val mul2: Parser[(Int, Int)] =
    mul | (anyChar ~> mul2)

  private lazy val parser: Parser[List[(Int, Int)]] =
    mul2.many

  def parse(input: String): List[(Int, Int)] =
    parser.parseOnly(input).done.option.get
}

object Part2Parser {

  import atto.*
  import Atto.*

  private val newline: Parser[Any] =
    string("\r\n") | char('\r') | char('\n')

  private val mul: Parser[Instruction] =
    (string("mul(") ~> (int ~ (char(',') ~> int)) <~ char(')'))
      .map(Instruction.Mul.apply.tupled)

  private val doInstruction: Parser[Instruction] =
    string("do()").map(_ => Instruction.Do)

  private val dontInstruction: Parser[Instruction] =
    string("don't()").map(_ => Instruction.Dont)

  private val instruction: Parser[Instruction] =
    mul | doInstruction | dontInstruction

  private lazy val instruction2: Parser[Instruction] =
    instruction | (anyChar ~> instruction2)

  private val parser: Parser[List[Instruction]] =
    instruction2.many

  def parse(input: String): List[Instruction] =
    parser.parseOnly(input).done.option.get
}