package docs.day3

import scala.util.Random

object ExtractorObject extends App {
  /*
  An extractor object in Scala is an object with an unapply method. This method is used
  to deconstruct a value and match its contents against a pattern. Extractor objects are
  useful for pattern matching and can be seen as the inverse of apply methods, which are
  used for constructing objects.

  The apply method acts as a versatile tool allowing objects to be treated like functions
  for calling them directly with arguments.
  */

  object CustomerID {

    def apply(name: String) = s"$name--${Random.nextLong()}"  // Sohaib--3420954

    def unapply(customerID: String): Option[String] = {
      val stringArray: Array[String] = customerID.split("--")

      // This code checks if a string (customerID) has content after splitting by "--".
      // If content exists, it extracts the first part (head) using Some(value), otherwise
      // returns None indicating no value.
      if (stringArray.tail.nonEmpty) Some(stringArray.head) else None
    }
  }

  val customer1ID = CustomerID("Sohaib")
  customer1ID match {
    case CustomerID(name) => println(name) // Sohaib
    case _ => println("Could not extract a customerID")
  }

  val customer2ID = CustomerID("Nico")
  val CustomerID(name) = customer2ID
  println(name) // Nico
}
