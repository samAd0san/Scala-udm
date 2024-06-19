package lectures.part1basics

object Functions extends App {

  // syntax of a method
  def print(a: String, b:String ): String = a + " " + b

  // println(print("Sohaib","Samad")); // Sohaib Samad

  def aParameterLessFun(): Int = 34
  // println(aParameterLessFun()) // 34

  // We can add braces also
  // WHEN YOU NEED LOOPS, USE RECURSION
  def aRepeadtedFunction(s: String, n: Int): String = {
    if(n == 1) s
    else s + aRepeadtedFunction(s, n - 1)
  }
  // println(aRepeadtedFunction("repeat ",3)) // repeat repeat repeat

  // If the return type is not mentioned, the compiler will infer the type itself, won't work in recursive functions
  def noReturnType(s: String, n: Int) = s + n
  // println(noReturnType("The compile can infer the return type, only in non-recursive function ", 0))

  def aFunWithSideEffects(str: String): Unit = println(str)
  // println(aFunWithSideEffects("This is a side effect")) // arg + ()

  def outerFunction(n: Int): Int = {
    def innerFunction(a: Int, b:Int): Int = a + b

    innerFunction(n,n-1) // 5 + 4
  }
  // println(outerFunction(5)) // 9

  // if we removed the return type it won't work, i.e def aRecursiveFunction(n: Int) = {}
  def aRecursiveFunction(n: Int): Unit = {
    if(n > 0){
      println(n)
      aRecursiveFunction(n - 1)
    }
  }
  // aRecursiveFunction(5) // 5 4 3 2 1

  /*
      Exercises:
      1.  A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
      2.  Factorial function 1 * 2 * 3 * .. * n
      3.  A Fibonacci function
          f(1) = 1
          f(2) = 1
          f(n) = f(n - 1) + f(n - 2)
      4.  Tests if a number is prime.
  */

  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old."
  def greet(name: String, age: Int): Unit = {
    // By adding the s prefix before the string, you enable string interpolation
    println(s"Hi, my name is $name and i am $age years old")
    // or println("Hi, my name is " + name + " and i am " + age + " years old")
  }
  // greet("Sohaib", 21)

  // 2. Factorial
  def factorial(n: Int): Int = {
    if (n <= 0) 1
    else n * factorial(n-1)
  }
  // println(factorial(5))

  // 3. Fibonacci - 1 1 2 3 5 8 ...
  def fibonacci(n: Int): Int = {
    if (n <= 2) 1
    else fibonacci(n - 1) + fibonacci(n - 2)
  }
  // println(fibonacci(1)) // 1

  // 4. prime or not
  def isPrime(n: Int): Boolean = {
    // eg. t = 37 / 2 -> 18
    def isPrimeUntil(t: Int): Boolean = {
      if (t <= 1) true
      // Checks if n is not divisible by t and recursively continues to check for primality with decreasing values of t.
      else n % t != 0 && isPrimeUntil(t - 1) // checking if 37 is divisible by 18,17,16 ... 2, on reaching 1 return true
    }
    isPrimeUntil(n / 2) // for optimization
  }
  println(isPrime(37)) // true
  println(isPrime(2003)) // true
  println(isPrime(32 * 12)) // false
}

