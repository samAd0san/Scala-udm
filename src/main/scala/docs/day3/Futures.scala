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
  */

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
  Await.result(futureResult, 5.seconds)
}
