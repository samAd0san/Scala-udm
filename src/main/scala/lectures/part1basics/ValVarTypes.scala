package org.jetbrains.scala.lectures.part1basics

object ValVarTypes {
  def main(args: Array[String]): Unit = {
    //1. Values
    //  val in scala are immutable i.e we cannot reassign the value
    val anInt: Int = 21
//    println(anInt)
    // Or we can also write like this,
    // COMPILERS CAN INFER TYPES
    val y = 21
//    println(y)

    val aString: String = "This is a String"
    val anotherString = "This is a String without type declaration"
//    println(aString)

    val aBoolean: Boolean = false
    val aChar: Char = 'a'
    val aInt: Int = anInt // we can assign other similar type variable

    val aShort: Short = 12323
    val aLong: Long = 4325345643L

    val aFloat: Float = 2.0f
    val aDouble: Double = 2.41

    // 2. Variables
    var aVariable: Int = 5

    // We can reassign the variable
    aVariable = 10
    println(aVariable)
  }
}
