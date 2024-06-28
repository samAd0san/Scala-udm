package docs.day3

object OptionSome {
  def main(args: Array[String]): Unit = {

     // Example 1
     val maybeName: Option[String] = Some("Alice in wonder land") // YO, Alice in wonder land
     maybeName match {
       case Some(name) => println(s"YO, $name")
       case None => println("Not Found")
     }

    // Example 2 checking with Integer
    val mayBeNumber: Option[Int] = Some(42)
    val mayBeSquared: Option[Int] = None
    println(mayBeNumber)
    println(mayBeSquared)

    // Example 3 (getOrElse)
    // val value: Option[String] = None // It is not there
    val value: Option[String] = Some("I am there") // I am there
    val res: String = value.getOrElse("It is not there")
    println(res)

    // Example 4 Greeting using Option/Some
    def greet(name: Option[String]): Unit = {
      val greeting = name match {
        case Some(n) => s"Hello, $n!"
        case None => "Hello, No Name"
      }
      println(greeting)
    }
    greet(Some("Alice")) // Hello, Alice!
    greet(None) // Hello, No Name

    /*
     While using Option:
     Only Two Statements can be passed in argument when using Option/Some
     - When passing the value it should be wrapped in the Some().
     - If there is no value is should give 'None' as it is.
    */

    // Example 5
    // Simulated database query returning Option
    def getUserById(id: Int): Option[String] = {
      val users = Map(
        1 -> "Alice",
        2 -> "Bob",
        3 -> "Marley"
      )
      // return statement
      users.get(id) // users.get(1) --> return Some(Alice) (or for) users.get(5) --> returns None
    }

    // val userName: Option[String] = getUserById(2) // Hello, Bob
    val userName: Option[String] = getUserById(6) // User not found
    userName match {
      case Some(name) => println(s"Hello, $name")
      case None => println("User not found")
    }
  }
}
