package docs.day4

object PolymorphicMethods extends App {
 /*
 Methods in Scala can be parameterized by type as well as by value.
 The syntax is similar to that of generic classes. Type parameters
 are enclosed in square brackets, while value parameters are enclosed
 in parentheses.
 */

  // This function repeats an element 'n' number of times
  def listOfDuplicates[A](elem: A, length: Int): List[A] = {
   if (length < 1) Nil
   else elem :: listOfDuplicates(elem, length - 1) // This line prepends (::) the element 'elem' to the list returned by the recursive call
  }
  println(listOfDuplicates[Int](2,4)) // List(2, 2, 2, 2)
  println(listOfDuplicates[String]("Repeat",3))
}
