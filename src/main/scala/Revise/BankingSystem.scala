package Revise

import jdk.jfr.DataAmount

import scala.collection.mutable.ListBuffer

/**
 * Bank Account Simulation
 *
 * Concepts: Object-Oriented Programming (OOP), classes, objects, encapsulation, inheritance.
 * Task: Simulate a bank system with accounts, allowing deposit, withdrawal, and balance checking.
 */

object BankingSystem {
  case class BankAccount(accountNumber: Int, name: String, accountBalance: Double)

  object AccountManager {
    var accounts = ListBuffer[BankAccount]()
    def createAccount(accountNumber: Int, name: String, accountBalance: Double): Unit = {
      if(accounts.exists(_.accountNumber == accountNumber)){
        println("Account Already Exists")
      }else {
        val newAccount = BankAccount(accountNumber, name, accountBalance)
        accounts += newAccount
        println(s"Account created with [name]: $name, [account number]: ${newAccount.accountNumber} and your initial balance is ${newAccount.accountBalance}")
      }
    }

    def deposit(accountNumber: Int, amount: Double): Unit = {
      val account = accounts.find(_.accountNumber == accountNumber) match {
        case Some(account) =>
          val updatedAccount = account.copy(accountBalance = account.accountBalance + amount)
          accounts = accounts.map(acc => if(acc.accountNumber == accountNumber) updatedAccount else acc)
          println(s"Amount added: $amount and the current balance is ${updatedAccount.accountBalance}")
        case _ =>
          println("Enter valid details")
      }
    }

    def withdraw(accountNumber: Int, amount: Double): Unit = {
      val account = accounts.find(_.accountNumber == accountNumber) match {
        case Some(account) =>
          if(account.accountBalance < amount) {
            println("Insufficient Balance")
          }else {
            val updatedAccount = account.copy(accountBalance = account.accountBalance - amount)
            accounts = accounts.map(acc => if(acc.accountNumber == accountNumber) updatedAccount else acc)
            println(s"Amount deducted: $amount and the current balance is ${updatedAccount.accountBalance}")
          }
        case _ =>
          println("Enter valid details")
      }
    }

    def displayBalance(accountNumber: Int): Unit = {
      val account = accounts.find(_.accountNumber == accountNumber) match {
        case Some(account) =>
          println(s"Account Balance: ${account.accountBalance}")
        case _ =>
          println(s"Enter valid details")
      }
    }
  }
    def main(args: Array[String]): Unit = {
      AccountManager.createAccount(1005, "Sohaib Samad", 4000) // Account created with [name]: Sohaib Samad, [account number]: 1005 and your initial balance is 4000.0
      AccountManager.deposit(1005, 500) // Amount added: 500.0 and the current balance is 4500.0
      AccountManager.withdraw(1005, 1000) // Amount deducted: 1000.0 and the current balance is 3500.0
      AccountManager.displayBalance(1005) // Account Balance: 3500.0

      AccountManager.deposit(1004,800) // Enter valid details
    }
}
