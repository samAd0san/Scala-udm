package lectures.part1basics

object StringOperations extends App {
  // Different methods of String

  val str: String = "Hello, I am Learning Scala" // Indexing starts from 0

  println(str.charAt(7)) // I
  println(str.substring(1,11)) // ello, I am // The first arg is inclusive (compulsory)
  println(str.split(" ").toList) // List(Hello,, I, am, Learning, Scala)

  println(str.startsWith("Learning")) // false
  println(str.startsWith("Hello")) // true

  println(str.replace(" ","-")) // Hello,-I-am-Learning-Scala
  println(str.toLowerCase()) // hello, i am learning scala
  println(str.toUpperCase()) // HELLO, I AM LEARNING SCALA

  println(str.length) // 26

  println(str.reverse) // alacS gninraeL ma I ,olleH
  println(str.take(2)) // He

  // Type Casting
  val aNumString = "2"
  val toNum = aNumString.toInt
  println(toNum) // 2

  val toStr = toNum.toString
  println(toStr) // "2"

  // prepending and appending
  val numString = "2"
  println('a' +: numString :+ 'z') // a2z

  // String Interpolation
  // S-interpolator
  val name = "Sam"
  val age = 12
  val greeting = s"Hello, my name is $name and I am $age years old"
  val anotherGreeting = s"Hello, my name is $name and I will be turning ${age + 1} years old."
  println(anotherGreeting) // Hello, my name is Sam and I will be turning 13 years old.

  // F-interpolator
  val speed = 1.2f
  val myth = f"$name can eat $speed%2.2f burgers per minute"
  println(myth) // Sam can eat 1.20 burgers per minute

  // raw-interpolator - allows you to create strings where backslashes (\) are treated literally,
  // without interpreting them as escape characters or performing variable substitution.
  println(raw"this is \n newline") // this is \n newline
  val escape = "This is a \n newline"
  println(raw"$escape") // This is a
                        // newline
}
