package playground

import scala.util.Random

object randomGenerator extends App {
  /*
  Program that generates a random number between 1 and 100, and then checks if the number is a prime number.
   */
  // Generate a random number between 1 and 100
  val randomNumber = Random.nextInt(100) + 1
  println(s"Random number: $randomNumber")

  // Function to check if a number is prime
  def isPrime(num: Int): Boolean = {
    if (num <= 1) false
    else if (num == 2) true
    else (2 until math.sqrt(num).toInt + 1).forall(n => num % n != 0)
  }

  // Check if the generated number is prime
  val primeStatus = if (isPrime(randomNumber)) "is prime" else "is not prime"
  println(s"The number $randomNumber $primeStatus.")
}
