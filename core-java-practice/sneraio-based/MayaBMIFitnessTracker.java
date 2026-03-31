/*
Maya’s BMI Fitness Tracker 🏃‍♀️
Maya, a fitness coach, wants to record the BMI of her clients.
● Ask for height and weight.
● Use formula BMI = weight / (height * height)
● Print category using if-else: Underweight, Normal, Overweight. 
*/

import java.util.Scanner;

public class MayaBMIFitnessTracker {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    // getting user input for weight and height
    System.out.print("Enter weight in kg: ");
    double weight = scanner.nextDouble();
    System.out.print("Enter height in meters: ");
    double height = scanner.nextDouble();

    if (height <= 0) {
      System.out.println("Height must be greater than zero.");
      scanner.close();
      return;
    }
    if (weight <= 0) {
      System.out.println("Weight must be greater than zero.");
      scanner.close();
      return;
    }

    double bmi = calculateBmi(weight, height);
    String category = bmiCategory(bmi);

    // displaying the results
    System.out.printf("Your BMI is: %.2f\n", bmi);
    System.out.println("BMI Category: " + category);

    scanner.close();

  }

  // method to calculate BMI
  private static double calculateBmi(double weight, double height) {
    return weight / (height * height);
  }

  // method to determine BMI category
  private static String bmiCategory(double bmi) {
    if (bmi < 18.5) {
      return "Underweight";
    } else if (bmi >= 18.5 && bmi < 24.9) {
      return "Normal";
    } else {
      return "Overweight";
    }
  }

}
