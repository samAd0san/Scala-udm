package org.jetbrains.scala.lectures.part1basics

object Expressions {
  def main(args: Array[String]): Unit = {

    // OPERATORS
    val x = 1 + 2
    // + - * / & | ^ << >> >>> (right shift with zero extension)
    // println(x)

    // PRECEDENCE
    println(2 + 4 * 2)

    // COMPARISON
    println(3 == x) // true
    // ==, !=, >, <, >=, <=

    // LOGICAL
    val y = 3
    println(!(1 == x)) // true
    println((y == 2) || (x == 3)) // true
    println((y == 2) && (x == 3)) // false

    // ASSIGNMENT
    var aVar = 3
    aVar += 2 // 5
    aVar *= 4 // 20
    aVar -= 2 // 18
    aVar /= 9 // 2
    // println(aVar)

    // Instructions (DO) vs Expressions (VALUE)

    // These are all expressions not instructions
    val aCondition = true
    // Check if 'aCondition' is true return yes, if it is not true return false
    val aConditionValue = if (aCondition) "yes" else "no"
    // println(aConditionValue) // yes

     print(if(!aCondition) "yes" else "no") // yes

     var i = 0
     while (i < 10) {
       println(i)
       i += 1
     } // 1 2 3 4 5 6 7 8 9

    // Unit = void
    val aWierdVariable = (aVar = 3) // returns unit ()
     println(aWierdVariable) // ()

    // code block
    val aCodeBlock = {
      val y = 2
      val z = y + 10

      if (z < 10) "yes" else "no"
    }

    println(aCodeBlock) // no

    val someValue = {
      2 < 3
    }

    val someOtherValue = {
      if (someValue) "yes" else "no"

      12
    }

    println(someOtherValue) // 12
  }
}
