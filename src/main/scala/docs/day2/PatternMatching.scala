package docs.day2

import scala.util.Random

object PatternMatching extends App {
  /*
  Pattern matching in Scala is a powerful feature that allows you to match and
  (destructure) data based on its shape and structure. It's often used with case
  classes, but it can also be applied to various other data types like tuples,
  lists, options, and even custom classes.
  */

  // Matching on Integers
  def matchTest(num: Int):String = num match {
    case 0 => "zero"
    case 1 => "one"
    case 2 => "two"
    case _ => "other" // The last case _ is a “catch all” case for any other possible Int values.
  }

  println(matchTest(2)) // two
  // Random integer between 0 and 9
  println(matchTest(Random.nextInt(10)))
  println(matchTest(Random.nextInt(10)))

  // Matching on case classes
  sealed trait Notification

  case class Email(sender: String, title: String, body: String) extends Notification

  case class SMS(caller: String, message: String) extends Notification

  case class VoiceRecording(contactName: String, link: String) extends Notification

  // In all the case classes we are extending the trait, that trait is used for pattern matching
  // as we can see the parameter in the method consist of Type Notification which is a trait
  def showNotification(notification: Notification): String = {
    notification match {
      case Email(sender, title, _) =>
        s"You got and email from $sender with title: $title"
      case SMS(caller, message) =>
        s"You got an SMS from $caller with the message: $message"
      case _ =>
        s"Unknown notification type"
    }
  }

  val someEmail = Email("Friend","Where are you?","")
  val someSMS = SMS("+1 2423 121","Are you there?")
  val someVR = VoiceRecording("Sam","voice-recording.org/id/123")

  println(showNotification(someEmail)) // You got and email from Friend with title: Where are you?
  println(showNotification(someSMS)) // You got an SMS from +1 2423 121 with the message: Are you there?
  println(showNotification(someVR)) // Unknown notification type


  // Matching on Type only
  sealed trait Device
  case class Phone(model: String) extends Device {
    def screenOff = s"The screen of $model is off"
  }
  case class Computer(model: String) extends Device {
    def powerSaver = s"The power saver of $model is on"
  }

  def goIdle(device: Device): String = device match {
    case p: Phone => p.screenOff
    case c: Computer => c.powerSaver
  }

  val iphone = new Phone("Iphone")
  val acer = new Computer("Acer Nitro 5")

  println(goIdle(iphone)) // The screen of Iphone is off
  println(goIdle(acer)) // The power saver of Acer Nitro 5 is on
}
