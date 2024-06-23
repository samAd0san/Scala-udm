package docs

object HOFs extends App {

  /*
  A high-order function in Scala is a function that either takes other functions as
  parameters or returns a function as a result.

  Functions are treated like any other data type, such as integers or strings.
  This means they are considered "first-class values.

  You can define a function and then assign it to a variable, just like you would
  with any other data.
  */

  // 'a' and 'b' are integers, and operation is a function that takes two integers and returns an integer.
  def applyOperation(a: Int, b: Int, operation: (Int, Int) => Int): Int = {
    operation(a,b) // taking a,b as arguments
  }

  val sum = (a: Int, b: Int) => a + b
  val prod = (a: Int, b: Int) => a * b

  println(applyOperation(10,20,sum)) // 30
  println(applyOperation(5,2,prod)) // 10

  // Example 2
  val salaries = List(10_000.21,22_000.65,37_000.721)
  val result = salaries.map(x => x * 2)
  println(result) // List(20000, 44000, 74000)

  // since the compiler can infer the type of x, The only caveat is that you need to use _ in place of a parameter name
  val anotherResult = salaries.map(_ * 2)
  println(anotherResult) // List(20000, 44000, 74000)

  // Example 3 (giving a function in the parameter)
  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] = {
    salaries.map(promotionFunction) // returning this statement
  }

  // Requires a single argument and return list of Doubles
  def smallPromotion(salaries: List[Double]): List[Double] = {
    // Calling the promotion function then in parameters passing the first param of parent method and in second argument
    // we are using the map function so no need to explicit argument
    promotion(salaries, salary => salary * 1.1)
  }
  println(smallPromotion(salaries)) // List(11000.231, 24200.715000000004, 40700.7931)

  def greatPromotion(salaries: List[Double]): List[Double] = {
    promotion(salaries, salary => salary * math.log(salary))
  }
  println(greatPromotion(salaries)) // List(92105.54789344492, 219980.69933961818, 389199.21306057135)

  def hugePromotion(salaries: List[Double]): List[Double] = {
    promotion(salaries, salary => salary * salary)
  }
  println(hugePromotion(salaries)) // List(1.0000420004409999E8, 4.840286004225001E8, 1.3690533545198407E9)

  // Example 4 (Returning a Function in Function)
  // have to give two arguments 
  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    // returning statement of this function is a function
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }
  
  val getURL = urlBuilder(true, "example.com") // the returned function is stored in a variable 
  println(getURL("users", "id1")) // https://example.com/users?id1
}
