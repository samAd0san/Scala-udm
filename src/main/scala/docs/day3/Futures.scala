package docs.day3

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Failure, Success}
import scala.concurrent.duration._

object Futures extends App {
  /*
  Future is a concurrency abstraction used for representing a value that may be
  available at some point in the future, typically as a result of an asynchronous
  computation. It allows you to perform non-blocking asynchronous operations and
  compose them in a declarative manner.

  Future can be handled by:
  map: Transform the result of the Future.
  flatMap: Chain multiple asynchronous computations.
  for-comprehension: Sequence multiple operations on Future.
  onComplete: Execute a callback after the Future completes.
  */

  // Different ways of handling future
  // 1. Using map
  val aFuture: Future[Int] = Future(31)
  val mappedFuture: Future[Int] = aFuture.map(value => value + 1)

  mappedFuture.foreach(println) // 32
  mappedFuture.foreach(result => println(s"Result using map: $result"))

  // 2. Using flatMap
  val aFutureValue: Future[Int] = Future(57)
  val anotherFutureValue: Future[Int] = {
    aFutureValue.flatMap(value => Future(value + 1))
  }
  anotherFutureValue.foreach(value => println(s"Result using flatMap: $value")) // 58

  // 3. Using for-comprehension
  val someFuture: Future[Int] = Future(10)
  val aSomeFuture: Future[Int] = Future(12)

  val resultFuture = for {
    a <- someFuture
    b <- aSomeFuture
  } yield a + b
  resultFuture.foreach(println) // 22

  // 4. Using onComplete
  // Define a function that returns a Future
  def performComputation(): Future[Int] = Future {
    // Simulate a time-consuming computation
    Thread.sleep(1000)
    42 // Return a result after computation
  }

  // Use the future
  val futureResult: Future[Int] = performComputation()

  // Define callbacks for handling the result
  futureResult.onComplete {
    case Success(result) => println(s"Computation Succeeded with the result $result")
    case Failure(error) => println(s"Computation Failed with exception $error")
  }

  // Perform other operations while waiting for the Future
  println("Performing other operations...")

  // Wait for the future to complete (avoid this in real applications)
  Await.result(futureResult, 2.seconds) // 2.seconds means that it will wait for 2 seconds
}

