package docs.day3

object ControlStatement {
  def main(args: Array[String]): Unit = {
    val ints = Seq(1,2,3,4,5)
    // for(i <- int) println(i)

    //   for(i <- ints) {
    // 	  val x = i * 2
    // 	  println(s"i = $i, x = $x")
    // 	}


    // for {
    //   i <- 1 to 5
    //   if i % 2 == 0
    // } 
    // println(i)

    // for {
    //   i <- 1 to 20
    //   if i > 3
    //   if i < 11
    //   if i % 2 == 0 
    // }
    // println(i)

    val list = {
      for (i <- 10 to 12)
        yield i * 2
    }
    println(list)
    
    val states = Map(
      "AK" -> "Alaska",
      "AL" -> "Alabama",
      "AR" -> "Arizona"
    )

    // println(states)
  }
}
