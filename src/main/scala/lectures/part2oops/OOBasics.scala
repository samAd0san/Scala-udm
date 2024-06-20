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

  /*
  EXERCISES
  1. Novel and a Writer

  Create a Class named
  Writer: first name, surname, year
    - method full name

  Create a class named
  Novel: name, year of release, author
  - authorAge
  - isWrittenBy(author)
  */

  // Class Writer
  class Writer(firstName: String, lastName: String, val year: Int) {
    def fullName: String = firstName + " " + lastName
  }

  // Object of Writer Class
  val author = new Writer("Charles", "Cook", 1831)
  // Returning the full name of the author with its dob
  println(author.fullName + " " + author.year) // Charles Cook 1831

  // Class Novel
  class Novel(name: String, year: Int, author: Writer) {
    // method 1
    // subtracting the year of publish of novel with the age of the author
    def authorAge = year - author.year

    // method 2
    // def isWrittenBy = author.fullName // just returning the name of the author
    def isWrittenBy(author: Writer) = author == this.author // It means the author of def isWritternBy(author) and class Novel(name..,year,, author) should match
  }

  // Object of Novel Class
  val novel = new Novel("Great Expectations", 1874, author)
  // println(novel.isWrittenBy)
  // returning the age of the author
  println(novel.authorAge) // 43


  val imposter = new Writer("Charles","Cook",1831)
  println(novel.isWrittenBy(author)) // true
  // comparing the imposter == author, this 'author' is of object 'novel'
  println(novel.isWrittenBy(imposter)) // false


  /*
    2. Counter class
      - receives an int value
      - method current count
      - method to increment/decrement => new Counter
      - overload inc/dec to N number of times
   */
  class Counter(count: Int = 0) {
    def inc = {
      // println("inc")
      new Counter(count + 1) // immutability
    }

    def dec = {
      // println("dec")
      new Counter(count - 1)
    }

    def inc(n: Int): Counter = {
      /* If n is less than or equal to 0, the method returns this, meaning it returns the current instance of the
      Counter without making any changes. This serves as the stopping condition for the recursion. */
      if(n <= 0) this
      // implementing recursion here
      else inc.inc(n-1) // If n is greater than 0, the method calls inc to create a new Counter instance with the count incremented by 1.
      // It then recursively calls inc with the argument n-1. This reduces the value of n by 1 each time, ensuring that the method will eventually reach the base case.
    }

    def dec(n: Int): Counter = {
      if(n <= 0) this
      else dec.dec(n-1) // Using the dec method defined above
    }

    def print = println(count)
  }

  val count = new Counter
  count.inc.print // 1
  count.inc.inc.inc.print // 3

  count.dec.print // -1
  count.dec.dec.dec.print // -3

  count.inc(10).print // 10
  count.dec(10).print // -10
}
