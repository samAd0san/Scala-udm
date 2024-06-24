package docs.day3

object GenericClass extends App {
  /*
  Generic classes take a type as a parameter within square brackets []. One convention
  is to use the letter A as type parameter identifier, though any parameter name may be used.
  */

  // Example 1
  class Stack[A] {
    // Nil here is an 'empty List' and is not to be confused with null.
    var elements: List[A] = Nil

    // Adding an element in the stack
    def push(x: A): Unit =
      println(x)
      elements = x :: elements //  adds the element x to the front of the list elements.

    // View the top element of the stack
    def peek(): A =
      // This method returns the first element of the list. If the list is empty, it throws a NoSuchElementException.
      elements.head

    // Removing the top element from the stack
    def pop(): A = {
      val currentTop = peek()
      // 'tail' This method returns a new list containing all elements except the first one. If the list is empty, it throws a UnsupportedOperationException.
      elements = elements.tail
      currentTop
    }
  }

  /*
  This implementation of a Stack class takes any type A as a parameter. This means the underlying list,
  var elements: List[A] = Nil, can only store elements of type A. The procedure def push only accepts
  objects of type A (note: elements = x :: elements reassigns elements to a new list created by prepending
  x to the current elements).
  */

  // The instance stack can only take Ints. However, if the type argument had subtypes, those could be passed in:
  val stack = new Stack[Int]
  stack.push(10)
  stack.push(12)
  println(stack.peek()) // 12
  println(stack.pop()) // 12
  println(stack.pop()) // 10

  // Another example type, but related to the previous one i.e (Stack)
  class Fruit
  case class Apple(name: String) extends Fruit
  case class Banana(name: String) extends Fruit

  val anotherStack = new Stack[Fruit]
  val apple = new Apple("American apple")
  val banana = new Banana("Indian banana")

  println(anotherStack.push(apple)) // Apple(American apple)
  println(anotherStack.push(banana)) // Banana(Indian banana)
  println(anotherStack.pop()) // Banana(Indian banana)
}
