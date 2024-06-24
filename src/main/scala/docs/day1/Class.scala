package docs.day1

object Class extends App {
  // class only have parameters, it doesn't contain return types
  class Point(var x: Int, var y: Int) {
    override def toString: String =
      s"($x, $y)"
  }

  val point1 = new Point(2, 3)
  println(point1) // prints (2, 3)

  class anotherPoint(var x: Int = 0, var y: Int = 1) {
    override def toString: String = {
      s"$x $y"
    }
  }

  val point2 = new anotherPoint
  println(point2)

  class PrivateClass(private var _a: Int,private var _b: Int) {

    // Custom getter for a (fetching the value of '_a')
    def a: Int = _a

    // Custom getter for b
    def b: Int = _b

    // Now i want to change the value of 'a' and 'b'
    def a_(newA: Int): Unit = {
      _a = newA
    }

    // also change the value of b
    def b_(newB: Int): Unit = {
      _b = newB
    }
  }

  val pvt = new PrivateClass(10,20)

  println(pvt.a + " " + pvt.b) // 10 20

  // calling the setter methods
  pvt.a_(15)
  pvt.b_(25)

  // printing the value of 'a' and 'b' after changing it via setters
  println(pvt.a + " " + pvt.b) // 15 25
}
