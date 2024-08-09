package playground

import scala.collection.mutable

/**
 * Use classes to define blueprints for creating objects with specific attributes and behaviors.
 * They represent entities with state and methods and are often used to model real-world concepts
 * or encapsulate data and functionality.
 *
 * @param accountNumber
 */
class BankAccount(val accountNumber: String) {
  var balance: Double = 0

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(f"Deposited Amount: $amount. New Balance: $balance%.2f")
    } else {
      println("Deposit amount must be positive")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(f"Withdrawn Amount: $amount. New Balance: $balance%.2f")
    } else if (amount > balance) {
      println("Insufficient Funds")
    } else {
      println("Withdrawn amount must be positive")
    }
  }

  def checkBalance(): Unit = {
    println(f"Account Balance: $balance%.2f")
  }
}

/**
 * Use objects to define singletons or utility functions that don't require instance creation.
 * They are used for grouping related functions and constants or managing global state, providing
 * a convenient way to access these without needing to instantiate a class.
 */
object BankSystem {
  /*
  creates an immutable reference to an empty mutable map where keys are String and values are BankAccount objects.
  e.g Map(12345 -> 10000, 67890 -> 20000) Map(BankAccount -> balance)
   */
  val accounts = mutable.Map[String, BankAccount]()

  def createAccount(accountNumber: String): Unit = {
    if (!accounts.contains(accountNumber)) {
      accounts(accountNumber) = new BankAccount(accountNumber)
      println(s"Account $accountNumber Created Successfully")
    } else {
      println(s"Account $accountNumber Already Exists")
    }
  }

  def deposit(accountNumber: String, amount: Double): Unit = {
    accounts.get(accountNumber) match {
      // account is the variable that holds the BankAccount object extracted from the Option type if it contains a value (Some(account)).
      case Some(account) => account.deposit(amount)
      case None => println(s"Account Number $accountNumber not found.")
    }
  }

  def withdraw(accountNumber: String, amount: Double): Unit = {
    accounts.get(accountNumber) match {
      case Some(account) => account.withdraw(amount)
      case None => println(s"Account Number $accountNumber not found.")
    }
  }

  def checkBalance(accountNumber: String): Unit = {
    accounts.get(accountNumber) match {
      case Some(account) => account.checkBalance()
      case None => println(s"Account Number $accountNumber not found.")
    }
  }

  def main(args: Array[String]): Unit = {
    createAccount("042022")
    deposit("042022", 500)
    withdraw("042022", 1000)
    withdraw("042022", 240)
    checkBalance("042022")
  }
}