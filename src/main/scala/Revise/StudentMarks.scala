package Revise

import scala.io.Source
import scala.io.Source.*

object StudentMarks {
  case class Student(name: String, grades: List[Int])

  object DisplayMarks {
    // Display the content from the file
    def readStudentGrades(filePath: String): List[Student] = {
      val source = Source.fromFile(filePath)

      try {
        // Read each line, split by commas, and create Student objects
        source.getLines().toList.map { //  reads lines from the file as an iterator, converts them to a list of strings, and processes each line with the provided code block using the map function.
          line =>
            val parts = line.split(",").map(_.trim) // parts = Array("Alice", "85", "90", "78")
            val name = parts(0) // name = "Alice"
            val grades = parts.drop(1).map(_.toInt).toList // grades = List(85, 90, 78)
            Student(name, grades) // Student("Alice", List(85, 90, 78))
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
