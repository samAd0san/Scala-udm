package docs.day3

import scala.util.{Failure, Success}

object ForComprehension extends App {
  /*
  For-comprehension is a syntactic construct that allows you to iterate over collections
  (such as lists, arrays, or other sequences) and perform operations on their elements
  concisely. It combines elements of foreach loops, map, flatMap, and filter operations
  into a single readable syntax.

  We can perform operations on monadic types like Option, List, Future, etc. using for-comprehension.
  */

  case class User(name: String, age: Int)

  val userBase = List(
    User("Samuel",24),
    User("Jacob",31),
    User("John",48),
    User("Samantha",35),
    User("Samad",21)
  )

  val aboveTwenty: List[String] =
    for(user <- userBase if user.age >= 20 && user.age < 30)
      yield user.name // adds this to the list

  aboveTwenty.foreach(println) // Samuel Samad

  // example using two generators. It computes all pairs of numbers between 0 and n-1 whose sum is equal to a given value v:

  def foo(n: Int, v: Int) = {
    for i <- 0 until n
        j <- 0 until n if (i + j == v)
    yield (i,j)
  }

  foo(10,10).foreach {
    case(i,j) =>
      // println(s"($i, $j)") // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5) (6, 4) (7, 3) (8, 2) (9, 1)
  }
  /*
  Here n == 10 and v == 10. On the first iteration, i == 0 and j == 0 so i + j != v and
  therefore nothing is yielded. j gets incremented 9 more times before i gets incremented
  to 1. Without the if guard, this would simply print the following:

  (0, 0) (0, 1) (0, 2) (0, 3) (0, 4) (0, 5) (0, 6) (0, 7) (0, 8) (0, 9) (1, 0) ...
  */

  /*
  You can omit yield in a comprehension. In that case, comprehension will return Unit.
  This can be useful in case you need to perform side-effects.
  */

  def anotherFoo(n: Int, v: Int) = {
    for (i <- 0 until n;
        j <- 0 until n if i + j == v)
    println(s"($i, $j)")
  }

  // anotherFoo(10,10) // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5) (6, 4) (7, 3) (8, 2) (9, 1)

  /*
  monadic type - Option, List, Future, etc. - - can be used in a for-comprehension.
   */

  // For comprehension with -Option-
  val person: Option[String] = Some("Alice")
//  val person: Option[String] = None
  val greeting = for {
    name <- person
  } yield s"Hello, $name"
  println(greeting) // Some(Hello, Alice)

  // For comprehension with -List-
  val people = List("Alice, Bob, Charlie")
  val greetings = for {
    name <- people
  } yield s"Hello, $name"
  println(greetings) // List(Hello, Alice, Bob, Charlie)

  // For comprehension with -Future-
  import scala.concurrent.Future
  import scala.concurrent.ExecutionContext.Implicits.global

  val future1: Future[Int] = Future(54)
  val future2: Future[Int] = Future(12)
  val result = for {
    a <- future1
    b <- future2
  } yield a + b
  result.foreach(println) // 66

  result.onComplete(println) // 66
  result.onComplete {
    case Success(value) => println(value)
    case Failure(exeception) => println(exeception)
  } // Success(66)

  // For comprehension with List
  val myList = List(1,2,3,4)
  val square = for {
    i <- myList
  } yield i * i
  println(square) // List(1,4,9,16)

  // For comprehension with Map
  val myMap = Map(
    1 -> "One",
    2 -> "Two",
    3 -> "Three"
  )
  val getMap = for {
    (key, value) <- myMap
  } yield (value)
  println(getMap) // List(One, Two, Three)
}
