package Revise
/*
Simple Calculator App
Concepts: Variables, data types, operators, basic control structures (if, match, loops), functions.
Task: Create a command-line calculator that supports addition, subtraction, multiplication, and division.
*/

object Calculator {
  def main(arg: Array[String]): Unit = {
    print("Enter the first number: ")
    val a: Int = scala.io.StdIn.readInt()

    print("Enter the second number: ")
    val b: Int = scala.io.StdIn.readInt()

    print("Enter the Operator (+, -, *, /): ")
    val op: String = scala.io.StdIn.readLine()

    op match {
      case "+" => println(a + b)
      case "-" => println(a - b)
      case "*" => println(a * b)
      case "/" =>
        if (b != 0) println(a / b)
        else println("The denominator cannot be zero")
      case _ => println("Enter a valid operator")
    }
  }
}