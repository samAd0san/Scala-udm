package lectures.part1basics

object CBVvsCBN extends App { // Call by value and Call by name
  // Call by value - The argument is evaluated before the function call and passed as a value.
  def callByValue(x: Long): Unit = {
    println("Call by value")
    println("x1: " + x) // 77642961416400
    println("x2: " + x) // 77642961416400
  }
  /* In call by value, System.nanoTime() is evaluated once before the function call, and the same value is printed twice. */
  callByValue(System.nanoTime())
  println()
  // Call by name - The argument is evaluated each time it is accessed within the function.
  def callByName(x: => Long): Unit = {
    println("Call by name")
    println("x1: " + x) // 77643038003400
    println("x1: " + x) // 77643039114300
  }
  /* In call by name, System.nanoTime() is evaluated each time it is accessed within the function, resulting in different values being printed. */
  callByName(System.nanoTime())
}