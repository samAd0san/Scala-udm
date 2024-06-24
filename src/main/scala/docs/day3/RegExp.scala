package docs.day3

import scala.util.matching.Regex

object RegExp extends App {
  /*
  Regular expressions are strings which can be used to find patterns in data.
  Any string can be converted to a regular expression using the .r method.
  */

  def saveContactInfo(contact: String): Unit = {
    val emailPattern: Regex = """^(\w+)@(\w+(.\w+)+)$""".r
    val phonePattern: Regex = """^(\d{3}-\d{3}-\d{4})$""".r

    contact match {
      /*
      The function knows the left side of @ is localPart and the right side is domainName because the
      regular expression pattern """^(\w+)@(\w+(.\w+)+)$""".r captures these parts in separate groups
      using parentheses.

      If we interchange the name of the parameter it'll still work, but the names can be misleading.
      i.e the first part is default the first arg and the second one is second
       */
      case emailPattern(localPart, domainName, _) =>
        println(s"Hi $localPart we have saved your email address")

      case phonePattern(contactNumber) =>
        println(s"Hi we have saved your phone number $contactNumber")

      case _ =>
        println("Invalid Input")
    }
  }

  saveContactInfo("123-456-7890") // Hi we have saved your phone number 123-456-7890
  saveContactInfo("sohaibsamadhala@gmail.com") // Hi sohaibsamadhala we have saved your email address
  saveContactInfo("abc") // Invalid Input
}
