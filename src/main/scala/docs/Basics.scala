package docs

object Basics extends App{
  // Functions
  // Functions are expressions that have parameters, and take arguments

//  (x: Int) => println(x)
  val arrowFunction = (x: Int) => println(s"I am $x years old")
  arrowFunction(10)

  val add = (a: Int, b: Int) => a + b
  println(add(10,20))

  val getAns = () => 21
  println(getAns())

  // Methods
  def add(a: Int, b: Int, c: Int): Int = a + b + c
  println(add(10,30,10))

  def addThenMultiply(a: Int, b: Int)(c: Int,d: Int): Int = a + b * (c + d)
  println(addThenMultiply(10,10)(10,10)) // 20 * 10 + 10

  def name = println("no params")
  name

  // when calling the method 'parenthesis' is not required
  def otherName = "no param with unit"
  println(otherName)

  // when calling the arrow function 'parenthesis' is required
  val arrowFun = () => "This is an arrow function"
  println(arrowFun())

  def newName: String = System.getProperty("user.name")
  println("Hello " + newName + "!!")

  def squareToString(num: Double): String = {
    val square = num * num
    square.toString
  }
  println(squareToString(2.5).getClass) // checking typeof -> class java.lang.String

  // Classes
  class Greeter(val name: String) {
    def addName(name: String,surname: String): Unit = println(s"My name is $name $surname, but people call me ${this.name}")
  }
  val greeter = new Greeter("Sam")

  greeter.addName("Sohaib","Samad") // My name is Sohaib Samad, but people call me Sam

  /*
  Case Classes
  Scala has a special type of class called a “case” class. By default, instances of case classes are immutable,
  and they are compared by value (unlike classes, whose instances are compared by reference). This makes them
  additionally useful for pattern matching.
   */

  case class Person(name: String, age: Int)

  val jim = new Person("jim",21)

  println(jim.name) // jim
  println(jim.age) // 21

  // attempting to change the value of object 'jim'

  // jim.name = "Sam" // not possible
  // jim.age = 30 // case class is immutable

  // But if we want to change the value of the object,
  // to "modify" an instance, you need to create a new instance with the desired changes using the copy method
  // provided by case classes.

  val anotherJim = jim.copy(name = "Sam")
  println(anotherJim.name + " " + anotherJim.age) // Sam 21

  /*
  Traits are abstract data types containing certain fields and methods. In Scala inheritance, a class can only extend
  one other class, but it can extend multiple traits.
   */

  trait Animal {
    def sound(): String  // Abstract method no implementation

    def sleep(): String = "ZZzz..." // // Concrete method (with implementation)
  }

  class Dog extends Animal {
    def sound(): String = "Woof..."

    // Override the sleep method (should add override keyword)
     override def sleep(): String = "Dog is asleep" + " " + super.sleep()
  }

  class Cat extends Animal {
    def sound(): String = "Meow..!"

    // Override the sleep method
     override def sleep(): String = "Cat is asleep"
  }

  val dog = new Dog()
  println(dog.sound())
  println(dog.sleep())

  val cat = new Cat()
  println(cat.sound())
  println(cat.sleep())

  // Define traits with different behaviors

  // trait 1
  trait swimming {
    def swim(): Unit = println("Swimming...")
  }

  // trait 2
  trait flying {
    def fly(): Unit = println("flying...")
  }

  // A class extending 2 traits i.e trait swimming and trait flying
  class Bird extends swimming with flying {
    def sound(): String = "Chirp..."

    // creating a method to call all the three methods which are defined differently
    def performActions(): Unit = {
      println(sound())
      swim()
      fly()
    }
  }

  // defining an object (parenthesis is not required after 'Bird' because we have not declared any parenthesis after the class Bird
  val bird = new Bird
  // calling this method from the Bird class
  bird.performActions()
}

