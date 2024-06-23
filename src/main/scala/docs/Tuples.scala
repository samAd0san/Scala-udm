package docs

object Tuples extends App{
  /*
  In Scala, a tuple is a value that contains a fixed number of elements, each with its
  own type. Tuples are immutable.

  Tuples are especially handy for returning multiple values from a method.
  */

  // A tuple with two elements
  val ingredient = ("sugar",21)
  println(ingredient) // (sugar,21)

  println(ingredient._1) // sugar
  println(ingredient._2) // 21

  // Basically we are declaring 'name' and 'quantity' and assigning the value of ingredients
  // index wise to it respectively.
  val (name,quantity) = ingredient
  // name’s inferred type is String and quantity’s inferred type is Int.
  println(name) // sugar
  println(quantity) // 21

  val numPairs = List((2, 5), (3, -7), (20, 56))
  println("numPairs")
  for ((a, b) <- numPairs) {
    println(a * b) // 10 -21 1120
  }
}
