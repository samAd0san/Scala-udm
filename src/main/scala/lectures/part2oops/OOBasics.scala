package lectures.part2oops

object OOBasics extends App{

  class Person(val name: String, val age: Int ) {
    val x = 2
    // println(2 + 2)

    // 'this' keyword refers to the parameter of the object (of the class),
    // In this case the parameter of the object of the class is 'person'
    def greet(name: String): Unit = println(s"${this.name} says Hey, $name")

    // method overloading - same method name but different parameters
    def greet(): Unit = println(s"Hi, I am $name")

    // Primary constructor
    def this(name: String) = {
      // It is an auxiliary constructor that initializes age to 0.
      this(name, 0) // Calls primary constructor with default age
    }

    // Auxiliary constructor
    def this() = {
      // It  is another auxiliary constructor that initializes name to "Cassandra".
      this("Cassandra") // Calls another auxiliary constructor
    }
  }

  // Instance of a class or It is an object
  val person = new Person("Samad", 21)

  // Accessing the attributes of the object
  println(person.name + " " + person.age) // Sam 21

  // Accessing the variable 'x' in the class
  println(person.x) // 4  Sam 21   2

  // Calling the greet method which has a name argument
  println(person.greet("Sohaib")) // Samad says, Hey Sohaib

  // Calling the greet method which has no argument (method overloading)
  println(person.greet()) // Hi, I am Samad

  // This is the Primary constructor object, where we only declare name in the parameter
  println(new Person("Alice").name) // Alice

  // This is the Auxiliary constructor object, where without any parameter we can print
  println(new Person().name) // Cassandra
}
