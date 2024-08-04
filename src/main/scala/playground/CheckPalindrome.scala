package playground

object CheckPalindrome {

  def isPalindrome(str: String): Boolean = {

    if (str.isEmpty) {
      print("Enter the String: ")
      return false
    }

    var i = 0
    var j = str.length - 1

    while (i <= j) { // checks all pairs of characters from the start and end of the string.
      if (str.charAt(i) != str.charAt(j)) { // compare the characters at positions i and j.
        return false
      }
      i += 1
      j -= 1
    }
    true
  }

  def main(args: Array[String]): Unit = {
    println(isPalindrome("malayalam"))
    println(isPalindrome("banana"))
    println(isPalindrome("oko"))
    println(isPalindrome(""))
  }
}
