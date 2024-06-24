package docs.day2

object SingletonObjects extends App {
  /*
  A singleton object in Scala is an object that is declared using the object keyword
  instead of class. Unlike classes, singleton objects cannot be instantiated multiple
  times; they have a single instance per JVM. Singleton objects are often used to hold
  utility methods, constants, and factory methods.
  */

  /*
  Companion Object
  A companion object in Scala is an object that shares the same name as a class and is
  defined in the same file. Companion objects and their corresponding classes can access
  each other's private members, allowing for a close relationship between the two.
  */
  class Person(val name: String, val age: Int)

  object Person {
    def apply(name: String, age: Int): Person = new Person(name, age)

    def older(p1: Person, p2: Person): Person = if (p1.age > p2.age) p1 else p2
  }

  // Using the companion object to create instances and compare
  val person1 = Person("Alice", 30)
  val person2 = Person("Bob", 25)

  val olderPerson = Person.older(person1, person2)
  println(s"The older person is ${olderPerson.name}") // prints: The older person is Alice

}
