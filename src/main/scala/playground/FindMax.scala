package playground

object FindMax {
  def computeMaxArray(arr: List[Option[Int]]): Option[Int] = {
    arr.flatten match {
      case Nil => None
      case nonEmptyList => Some(nonEmptyList.max)
    }
  }

  def main(args: Array[String]) = {
    val list = List(Some(3), Some(7), None, Some(1))
    val result = computeMaxArray(list)
    println(result)
  }
}
