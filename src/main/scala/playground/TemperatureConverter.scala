package playground

object TemperatureConverter {

  // Convert Celsius to Fahrenheit
  def celsiusToFahrenheit(celsius: Double): Double = {
    (celsius * 9/5) + 32
  }

  // Convert Fahrenheit to Celsius
  def fahrenheitToCelsius(fahrenheit: Double): Double = {
    (fahrenheit - 32) * 5/9
  }

  def main(args: Array[String]): Unit = {
    val celsius = 25.0
    val fahrenheit = 77.0

    println(s"$celsius°C is ${celsiusToFahrenheit(celsius)}°F")
    println(s"$fahrenheit°F is ${fahrenheitToCelsius(fahrenheit)}°C")
  }
}

