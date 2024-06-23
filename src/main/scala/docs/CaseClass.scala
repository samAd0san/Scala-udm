package docs

object CaseClass extends App {
  /*
  A case class in Scala is a special type of class that comes with several convenient
   features designed for use in pattern matching and immutability.
   */

  case class Person(name: String, age: Int)

  val john = new Person("john",21)

  // 1. Simple use case
  println(john) // Person(john, 21)

  // 2. Comparison
  val anotherJohn = new Person("john",21)
  println(john == anotherJohn) // true

  // 3. Using 'Copy' method
  val olderPerson = john.copy(age = 41)
  println(olderPerson) // Person(john,41)

  // 4. Pattern matching with case class !!! CHECK THE PatternMatching.scala file !!!
}
