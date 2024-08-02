package playground

object FibGenerator {

  def generateFibonacci(num: Int): List[Int] = {
    // Two Base Conditions
    if (num <= 0) { // Base condition if the user enter 0, we return an empty list
      List()
    } else if (num == 1) { // Base condition two if the user enters '1' then just return the list with '0' in it
      List(0)
    } else {
      var fibList = List(0,1) // Initially we are declaring a list with first and second element 0 and 1
      while(fibList.length < num) {
        // 'last' return the last element of the List
        val nextNumber = fibList.last + fibList(fibList.length - 2) // summing up the last two elements of the list as they add up
        fibList = fibList :+ nextNumber
      }
      println(s"Length of the List ${fibList.length}")
      fibList
    }
  }

  def main(args: Array[String]): Unit = {
    println(generateFibonacci(5)) // List(0, 1, 1, 2, 3)
  }
}
