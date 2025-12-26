/*
 Write a program calculate the wind chill temperature given the temperature and wind speed
 Write a method to calculate the wind chill temperature using the formula
 windChill = 35.74 + 0.6215 * temp + (0.4275 * temp - 35.75) * windSpeed^0.16
  public double calculateWindChill(double temperature, double windSpeed)
 */

import java.util.Scanner;

public class WindChillTemperature {

  public double calculateWindChill(double temperature, double windSpeed) {
    return 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * Math.pow(windSpeed, 0.16);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter the temperature (in Fahrenheit): ");
    double temperature = scanner.nextDouble();

    System.out.print("Enter the wind speed (in mph): ");
    double windSpeed = scanner.nextDouble();

    WindChillTemperature wct = new WindChillTemperature();
    double windChill = wct.calculateWindChill(temperature, windSpeed);

    System.out.println("Wind Chill Temperature: " + windChill + " °F");

    scanner.close();
  }
}
