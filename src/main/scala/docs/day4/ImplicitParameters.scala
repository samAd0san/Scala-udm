package docs.day4

object ImplicitParameters extends App {
  /*
  implicit parameters are a mechanism that allows parameters to be passed
  automatically by the compiler when they are not explicitly provided in
  the function call. This is useful for dependency injection, type classes,
  and reducing boilerplate code.
  */

  // When you define a function with an implicit parameter, you mark the parameter with the implicit keyword.
  // Defining an implicit value
  implicit val defalutDiscount: Double = 0.1

  // Define a function with an implicit parameter
  def calculateDiscount(price: Double)(implicit discount: Double): Double = {
    price * (1 - discount)
  }

  // Calling the function without passing the implicit parameter
  val finalPrice: Double = calculateDiscount(1200)
  println(finalPrice) // 1080.0
  // NOTE: The compiler automatically detects the implicit function with the help of the keyword 'implicit'
}
