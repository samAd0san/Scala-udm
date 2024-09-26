package Revise

import scala.io.Source
import scala.io.Source.*

/** 
 * Student Grading System: 
 * Concepts: Collections (List, Map), case classes, pattern matching, file handling, Option/Some/None.
 * Task: Create a system to read student grades from a file, calculate averages, and assign letter grades.
 * */

object StudentMarks {
  case class Student(name: String, grades: List[Int])

  object DisplayMarks {
    // Display the content from the file
    def readStudentGrades(filePath: String): List[Student] = {
      val source = Source.fromFile(filePath)

      try {
        source.getLines().toList.flatMap { line =>
          // Split the line and trim whitespace
          val parts = line.split(",").map(_.trim)

          // Check if there are at least 2 parts (name + at least one grade)
          if (parts.length < 2) {
            println(s"Invalid line format: '$line'. Expected format: 'Name, Grade1, Grade2, ...'")
            None // Skip this line
          } else {
            val name = parts(0) // First part is the student name
            try {
              // Parse grades and handle any parsing errors
              val grades = parts.drop(1).map(_.toInt).toList
              Some(Student(name, grades)) // Wrap in Some for successful parsing
            } catch {
              case e: NumberFormatException =>
                println(s"Error parsing grades for student '$name': ${e.getMessage}")
                None
            }
          }
        }
      } finally {
        source.close()
      }
    }

    def calculateAverage(grades: List[Int]): Double = {
      if (grades.isEmpty) 0.0 else (grades.sum.toDouble / grades.size).floor
    }

    def letterGrade(average: Double): String = {
      average match {
        case avg if avg >= 90 => "A"
        case avg if avg >= 80 => "B"
        case avg if avg >= 70 => "C"
        case avg if avg >= 60 => "D"
        case _ => "Fail"
      }
    }

    def displayStudentsDetail(filePath: String): Unit = {
      val students = readStudentGrades(filePath)

      students.foreach { student =>
        val avg = calculateAverage(student.grades)
        val grade = letterGrade(avg)
        println(s"Student ${student.name}, Average: $avg, Grade: $grade")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val studentMarks = "src/main/scala/Revise/StudentMarks.txt"
    DisplayMarks.displayStudentsDetail(studentMarks)
  }
}

/**
 * Invalid line format: 'adfsafds'. Expected format: 'Name, Grade1, Grade2, ...'
 * Student Alice, Average: 84.0, Grade: B
 * Student Bob, Average: 83.0, Grade: B
 * Student Charlie, Average: 62.0, Grade: D
 * Student Logan, Average: 75.0, Grade: C
 *
 * Process finished with exit code 0
 */