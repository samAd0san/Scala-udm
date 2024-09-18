package Revise

import scala.collection.mutable.ListBuffer

object ToDosList {
  case class Task(var id: Int, var description: String, var isComplete: Boolean)

  object TaskManager {
    var tasks = ListBuffer[Task]()

    def addTask(id: Int, description: String, isComplete: Boolean): Unit = {
      try {
        if (id <= 0) throw new IllegalArgumentException("ID must be positive")
        if (description.isEmpty) throw new IllegalArgumentException("Enter the Description")
        val task = Task(id, description, isComplete)
        tasks += task
        println(s"Added task $task")
      } catch {
        case e: IllegalArgumentException => println(s"Error Adding Task: ${e.getMessage}")
      }
    }

    def removeTask(id: Int): Unit = {
      try {
        val taskToRemove = tasks.find(_.id == id)
        if (taskToRemove.isEmpty) throw new NoSuchElementException(s"Task Not Found with id: $id")
        tasks = tasks.filterNot(_.id == id)
        println(s"Task Removed: $taskToRemove")
      } catch {
        case e: NoSuchElementException => println(s"Error removing Task: ${e.getMessage}")
      }
    }

    def removeAll(): Unit = {
      try {
        if (tasks.isEmpty) throw new NoSuchElementException("No Tasks to Remove")
        tasks.clear()
        println("All the tasks have been removed")
      } catch {
        case e: NoSuchElementException => println(s"Error removing all tasks: ${e.getMessage}")
      }
    }

    def updateTask(id: Int, newDescription: String, newIsComplete: Boolean): Unit = {
      try {
        val index = tasks.indexWhere(_.id == id)
        if (index == -1) throw new NoSuchElementException(s"No Task found with id: $id")
        val oldTask = tasks(index)
        tasks.update(index, Task(id, newDescription, newIsComplete))
        println(s"Task Updated From $oldTask --> ${tasks(index)} ")
      } catch {
        case e: NoSuchElementException => println(s"Error Updating Task: ${e.getMessage}")
      }
    }

    def updatePartially(id: Int, newDescription: Option[String] = None, newIsComplete: Option[Boolean] = None): Unit = {
      try {
        val index = tasks.indexWhere(_.id == id)
        if (index == -1) throw new NoSuchElementException(s"No Task found with id: $id")
        val oldTask = tasks(index)
        tasks.update(index, oldTask.copy(
          description = newDescription.getOrElse(oldTask.description),
          isComplete = newIsComplete.getOrElse(oldTask.isComplete)
        ))
        println(s"Task Updated From $oldTask --> ${tasks(index)} ")
      } catch
        case e: NoSuchElementException => println(s"Error partially updating: ${e.getMessage}")
    }

    def displayTask(): Unit = {
      try {
        if (tasks.isEmpty) throw new NoSuchElementException("There are no Tasks")
        println("Printing all the tasks")
        tasks.foreach(println)
      } catch {
        case e: NoSuchElementException => println(s"Error Displaying message: ${e.getMessage}")
      }
    }
  }

  def main(arg: Array[String]): Unit = {
    TaskManager.addTask(1, "Complete the chores before 10AM", false)
    TaskManager.addTask(2, "Learn Scala", true)
    TaskManager.displayTask()

    TaskManager.removeTask(1)

    TaskManager.addTask(3, "Do the Next Project", false)
    TaskManager.updateTask(3, "Do the Next Project", true)
    TaskManager.updatePartially(2, newIsComplete = Some(false))

    TaskManager.displayTask()
    TaskManager.removeAll()
    TaskManager.displayTask()

    TaskManager.addTask(-3, description = "Go to pray", isComplete = false)
    TaskManager.addTask(5,description = "", false)

    TaskManager.removeTask(29)
  }
}
