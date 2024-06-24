# Execution Context
- In Scala, an ExecutionContext is an abstraction that represents a thread pool or an execution environment for running asynchronous computations. It is used by futures and other concurrency constructs to run their code.<br><br>
- <b>Concurrency Management:</b> An ExecutionContext manages where and how asynchronous tasks, like those created with Future, are executed.
- <b>Thread Pool:</b> Typically, an ExecutionContext is backed by a thread pool, which can be configured to optimize performance for different types of workloads.
- <b>Implicit Parameter:</b> When creating futures and other asynchronous operations, an implicit ExecutionContext is required.

# Creating an Execution Context

- <b>Global ExecutionContext:</b> A default ExecutionContext provided by the standard library.
```
import scala.concurrent.ExecutionContext.Implicits.global
``` 
<br>

- <b>Custom ExecutionContext:</b> You can create a custom ExecutionContext using a custom thread pool.
```chatinput
import scala.concurrent.ExecutionContext
import java.util.concurrent.Executors

val threadPool = Executors.newFixedThreadPool(10)
implicit val customExecutionContext: ExecutionContext = ExecutionContext.fromExecutor(threadPool)
```