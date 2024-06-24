# Traits 
- Traits in Scala are similar to interfaces in other programming languages, but they can also contain concrete methods and fields can also contains abstract method. They are used to define a set of methods that can be mixed into classes, providing a way to achieve multiple inheritance.<br><br>
- Traits are abstract data types containing certain fields and methods. In Scala inheritance, a class can only extend one other class, but it can extend multiple traits.

- ### learnt so far 
- Traits are like interface in java, we can inherit multiple traits to a class, it can be done with <b>'extends'</b> follows <b>'with'</b> keyword.
- ```class Bird extends Swimming with Flying ```, where Swimming and Flying are Traits.
- We can implement <b>Abstract methods</b> as well <b>Concrete methods</b>.
- If the method name in class is same as that of in the trait we can use that method by prepending <b>'override'</b> keyword. eg. ```override def sleep(): String = {...}```
  - If we do not want to <b>override</b> and use the method of trait as it is use <b>super</b> keyword. eg. ```super.sleep()```

# When to use which whether (extends App) or (main)
<b>Extending App trait </b>: This approach allows you to write your Scala code directly within an object that extends the App trait. The App trait includes a main method where you place your program logic. Here’s a simple example:

```
object MyApp extends App {
    println("Hello, Scala!")
}
```
<b>Usage:</b> Use this approach for simple scripts or small programs where you want to avoid writing an explicit main method. It simplifies the structure by allowing you to write code directly within the object.

<b>Defining a main method:</b> This is the traditional approach where you define a main method within an object or class, which serves as the entry point of the program. Here’s an example:

```
object Main {
  def main(args: Array[String]): Unit = {
    println("Hello, Scala!")
  }
}
```

<b>Usage:</b> Use this approach for more complex programs or when you need more control over the program’s execution, such as handling command-line arguments (args parameter) or managing program lifecycle explicitly.

# Class composition with mixins
- Class composition with mixins in Scala refers to a technique where a class can be constructed by combining multiple traits (which are similar to interfaces in other languages) with a base class.

# Pattern Matching
- Pattern matching is a mechanism for checking a value against a pattern. A successful match can also deconstruct a value into its constituent parts. It is a more powerful version of the switch statement in Java and it can likewise be used in place of a series of if/else statements.

- ### basic syntax 
```chatinput
value match {
  case pattern1 => result1
  case pattern2 => result2
  // other cases
}
```

# Key Points About Singleton Objects
<b>Single Instance:</b> Only one instance of a singleton object exists throughout your program. <br><br>
<b>No Constructors:</b> Singleton objects do not have constructors as you cannot create them directly. <br><br>
<b>Companion Objects:</b> When a singleton object shares the same name as a class, it's called a companion object. Companion objects and classes can access each other's private members. <br><br>
<b>Utility Holder:</b> Singleton objects are often used to hold static methods and fields, similar to static members in Java.