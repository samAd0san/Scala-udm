package lectures.part1basics
import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if(n <= 1) 1
    else {
      println(s"Computing factorial of $n - I need factorial of ${n-1}")
      val result = n * factorial(n - 1)
      println(s"Computed factorial of $n")

      result
    }
  // println(factorial(10)) // 3628800
  // println(factorial(20000)) // For calculating the big factorial, It will give StackOverFlow exception, to resolve this we use tail recursion.

  def tailFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt = {
      if(x <= 1) accumulator // at last the accumulator is returned when all the value is computed
      else factHelper(x - 1, x * accumulator) // TAIL RECURSION = It uses recursive call as the LAST expression
    }
    factHelper(n, 1)
  }
  // println(factorial(10)) // 3628800
  // println(tailFactorial(1000)) // 402387260077093773...
  /*
         Example let us take
         x = 10, acc = 1
    factHelper(x - 1, x * acc)
    factHelper(9, 10 * 1)
    factHelper(8, 9 * 10 * 1)
    factHelper(7, 8 * 9 * 10 * 1)
    .
    .
    .
    factHelper(1, 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10 * 1 )
    now since n = 1, has reached the final condition it'll return the accumulator.
  */
  // WHEN YOU NEED LOOPS, USE _TAIL_ RECURSION.

  /*
      Exercises:
      1.  Concatenate a string n times
      2.  IsPrime function tail recursive
      3.  Fibonacci function, tail recursive.
  */

  // 1. Concatenate a string n times
  @tailrec
  def concatStringNTimes(str: String, n: Int, accumulator: String): String =
    if(n < 1) accumulator
    else concatStringNTimes(str, n - 1, accumulator + str)

  println(concatStringNTimes("Hello ", 10, ""))

  // 2. isPrime using tail recursion
  def isPrime(n: Int): Boolean = {
    @tailrec
    // rather than giving the answer to the stack we are saving it in the 'isStillPrime' accumulator
    def isPrimeTailrec(t: Int, isStillPrime: Boolean): Boolean = {
      if(!isStillPrime) false // If the number is found to be divisible, it's not prime
      else if (t <= 1) true // If we have checked all numbers down to 1, it is prime
      else isPrimeTailrec(t - 1, n % t != 0 && isStillPrime) // Continue checking with t-1
    }
    isPrimeTailrec(n / 2, true)
  }
  println(isPrime(2003)) // true
  println(isPrime(268)) // false

  // 3. fibonacci using tail recursion
  def fibonacci(n: Int): Int = {
    @tailrec
    def fibTailrec(i: Int, last: Int, secondLast: Int): Int = {
      if(i >= n) last // this is the final answer which we require
      else fibTailrec(i + 1, last + secondLast, last)
    }
    if(n <= 2) 1
    else fibTailrec(2, 1, 1)
  }
  // 8th position of fib no
  println(fibonacci(8)) // 1 1 2 3 5 8 13, 21
}
