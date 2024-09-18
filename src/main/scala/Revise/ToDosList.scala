package Revise

import scala.collection.mutable.ListBuffer

object ToDosList {
  case class Task(var id: Int, var description: String, var isComplete: Boolean)

  object TaskManager {
    var tasks = ListBuffer[Task]()

    def addTask(id: Int, description: String, isComplete: Boolean): Unit = {
      println("Task Added")
      tasks += Task(id, description, isComplete)
    }

    def removeTask(id: Int): Unit = {
      println("Task Removed")
      tasks = tasks.filterNot(_.id == id)
    }

    def updateTask(id: Int, newDescription: String, newIsComplete: Boolean): Unit = {
      println("Task Updated")
      val index = tasks.indexWhere(_.id == id)
      if (index != -1) {
        tasks.update(index, Task(id, newDescription, newIsComplete))
      }
    }

    def displayTask(): Unit = {
      println("Printing all the tasks")
      tasks.foreach(println)
    }
  }

  def main(arg: Array[String]): Unit = {
    TaskManager.addTask(1, "Complete the chores before 10AM", false)
    TaskManager.addTask(2, "Learn Scala", true)
    TaskManager.displayTask()
    TaskManager.removeTask(1)
    TaskManager.addTask(3, "Do the Next Project", false)
    TaskManager.displayTask()
  }
}
