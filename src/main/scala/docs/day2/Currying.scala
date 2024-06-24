package docs.day2

object Currying extends App {
  /*
  Currying is the technique of converting a function that takes multiple arguments into
  a sequence of functions that each takes a single argument.
  */

  // Example 1
  // Adding two numbers using currying
  def add(x: Int)(y: Int): Int = x + y
  println(add(3)(5)) // 8

  // or
  private def addFirstParam = add(5)
  private def addSecondParam = addFirstParam(5)
  println(addSecondParam) // 10

  // Example 2
  // Checking if a list contains an element using curried functions.
  private def contains[A](list: List[A])(elem: A): Boolean = list.contains(elem)

  // Checking whether the element exists in the list or not
  private val checkContains = contains(List(1,2,3,4))
  println(checkContains(5)) // false
  println(checkContains(2)) // true

  // Example 3
  // Implementing a curried function to calculate exponentiation.
  def power(base: Double)(exponent: Double): Double = math.pow(base,exponent)
  val square = power(2)
  println(square(3)) // 2^3 -> 8
}
