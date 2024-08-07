package playground

object Calculator {
  def calc(num1: Int, num2: Int, operator: Char): Int = {
    try {
      operator match
        case '+' => num1 + num2
        case '-' => num1 - num2
        case '*' => num1 * num2
        case '/' =>
          if (num2 == 0) throw new ArithmeticException("Not Divisible by Zero")
          else num1 / num2
        case _ => throw new IllegalArgumentException("Invalid Operator")
    }catch {
      case e: ArithmeticException =>
        println(s"Error: ${e.getMessage}")
        0
      case e: IllegalArgumentException =>
        println(s"Error: ${e.getMessage}")
        0
    }
  }

  def main(args: Array[String]): Unit = {
    println(calc(5,0,'/')) // Error: Not Divisible by Zero 0
    println(calc(5,5,'_')) // Error: Invalid Operator 0
  }
}
