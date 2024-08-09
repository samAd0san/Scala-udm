package playground

object PrimeNumber {

  def isPrime(num: Int): Boolean = {
    if (num <= 1) false
    else if (num == 2) true
    else if (num % 2 == 0) false
    else {
      val sqrtNum = math.sqrt(num).toInt
      // checks 3 to square root of num and increments by 2,
      !(3 to sqrtNum by 2).exists(d => num % d == 0) // It checks if none of the odd numbers from 3 to sqrtN divide n evenly, indicating that n is a prime number.
    }
  }

  def GeneratePrime(max: Int): List[Int] = {
    (2 to max).filter(isPrime).toList
  }

  def main(args: Array[String]): Unit = {
    val max = 50
    println(GeneratePrime(max)) //
  }
}
