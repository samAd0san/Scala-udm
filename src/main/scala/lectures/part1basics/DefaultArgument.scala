package lectures.part1basics

object DefaultArgument extends App {
  /* In Scala, default arguments allow you to specify a default value for a parameter in a function,
  which will be used if no argument is provided for that parameter. */

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("Saving the picture")

  savePicture(800,200) // since we already specified the 'format', here it'll give error because the compiler is
  // thinking that the first argument is the replacement of the 'format' argument, not the width which we want to include.

  // To solve this issue there are two ways
  // 1. pass value in every argument
  // 2. name the argument

  savePicture(width = 120, format = "png", height = 200) // the argument is also not necessary to be in order

}
