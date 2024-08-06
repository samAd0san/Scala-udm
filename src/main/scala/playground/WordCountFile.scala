package playground

import java.io.PrintWriter
import java.nio.charset.StandardCharsets
import java.nio.file.{Files, Paths}
import scala.io.Source

object WordCountFile {

  def countWordsInFile1(inputFilePath: String, outputFilePath: String): Unit = {
    try {
      // Read the entire file content
      val fileContent = Source.fromFile(inputFilePath).getLines().mkString(" ")

      // Split the content of the file into words and count them
      val wordCount = fileContent.split("\\s+").length // ("\\s+") is a regular expression that matches one or more whitespace characters (spaces, tabs, etc.).

      // Write the word count into a new file
      val writer = new PrintWriter(outputFilePath) // PrintWriter will automatically create the output file if it does not already exist:
      writer.write(s"Word Count: $wordCount") // The write function in PrintWriter writes a string to the output file.
      writer.close()

      println(s"Word count of the file is writtern to $outputFilePath")
    } catch {
      case e: Exception => println(s"An Error occurred: ${e.getMessage}")
    }
  }

  def countWordsInFile2(inputFilePath: String, outputFilePath: String): Unit = {
    try {
      // Read the entire content of the input file into a single string
      val fileContent = scala.io.Source.fromFile(inputFilePath).getLines().mkString(" ")

      // Split the file content into words based on whitespace and count them
      val wordCount = fileContent.split("\\s+").length

      // Write the word count to the output file using Files.write
      Files.write(Paths.get(outputFilePath), s"Word count: $wordCount".getBytes(StandardCharsets.UTF_8))

      // Print a confirmation message
      println(s"Word count of the file is written to $outputFilePath")
    } catch {
      // Handle any exceptions that occur during file operations
      case e: Exception => println(s"An error occurred: ${e.getMessage}")
    }
  }

  def main(args: Array[String]): Unit = {
    val inputFilePath = "D:\\Scala\\Scala-udm\\src\\main\\scala\\playground\\inputfile.txt"
    val outputFilePath = "D:\\Scala\\Scala-udm\\src\\main\\scala\\playground\\outputfile.txt"

    countWordsInFile2(inputFilePath,outputFilePath)
  }
}
