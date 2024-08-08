package playground

import scala.collection.mutable

class BankAccount(val accountNumber: String) {
  private var balance: Double = 0.0

  def deposit(amount: Double): Unit = {
    if (amount > 0) {
      balance += amount
      println(f"Deposited $amount%.2f. New balance: $balance%.2f")
    } else {
      println("Deposit amount must be positive.")
    }
  }

  def withdraw(amount: Double): Unit = {
    if (amount > 0 && amount <= balance) {
      balance -= amount
      println(f"Withdrew $amount%.2f. New balance: $balance%.2f")
    } else if (amount > balance) {
      println("Insufficient funds.")
    } else {
      println("Withdrawal amount must be positive.")
    }
  }

  def checkBalance(): Unit = {
    println(f"Account balance: $balance%.2f")
  }
}

object BankSystem {
  private val accounts = mutable.Map[String, BankAccount]()

  def createAccount(accountNumber: String): Unit = {
    if (!accounts.contains(accountNumber)) {
      accounts(accountNumber) = new BankAccount(accountNumber)
      println(s"Account $accountNumber created successfully.")
    } else {
      println(s"Account $accountNumber already exists.")
    }
  }

  def deposit(accountNumber: String, amount: Double): Unit = {
    accounts.get(accountNumber) match {
      case Some(account) => account.deposit(amount)
      case None => println(s"Account $accountNumber not found.")
    }
  }

  def withdraw(accountNumber: String, amount: Double): Unit = {
    accounts.get(accountNumber) match {
      case Some(account) => account.withdraw(amount)
      case None => println(s"Account $accountNumber not found.")
    }
  }

  def checkBalance(accountNumber: String): Unit = {
    accounts.get(accountNumber) match {
      case Some(account) => account.checkBalance()
      case None => println(s"Account $accountNumber not found.")
    }
  }

  def main(args: Array[String]): Unit = {
    // Create some accounts
    createAccount("12345")
    createAccount("67890")

    // Perform some operations
    deposit("12345", 500.00)
    withdraw("12345", 200.00)
    checkBalance("12345")

    deposit("67890", 1000.00)
    withdraw("67890", 150.00)
    checkBalance("67890")

    // Test non-existing account
    deposit("99999", 100.00)  // Account not found
    withdraw("99999", 50.00)   // Account not found
    checkBalance("99999")     // Account not found
  }
}

