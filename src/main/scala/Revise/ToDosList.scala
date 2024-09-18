package Revise

import scala.collection.mutable.ListBuffer

object ToDosList {
  case class Task(var id: Int, var description: String, var isComplete: Boolean)

  object TaskManager {
    var tasks = ListBuffer[Task]()

    def addTask(id: Int, description: String, isComplete: Boolean): Unit = {
      val task = Task(id, description, isComplete)
      tasks += task
      println(s"Added task $task")
    }

    def removeTask(id: Int): Unit = {
      val taskToRemove = tasks.find(_.id == id)
      tasks = tasks.filterNot(_.id == id)
      taskToRemove match {
        case Some(task) => println(s"Task Removed: $task")
        case None => println(s"Task not found with id: $id")
      }
    }

    def updateTask(id: Int, newDescription: String, newIsComplete: Boolean): Unit = {
      val index = tasks.indexWhere(_.id == id)
      if (index != -1) {
        val oldTask = tasks(index)
        tasks.update(index, Task(id, newDescription, newIsComplete))
        println(s"Task Updated From $oldTask --> ${tasks(index)} ")
      } else {
        println(s"No task found with id: $id")
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
    TaskManager.updateTask(3, "Do the Next Project", true)
    TaskManager.displayTask()
  }
}
