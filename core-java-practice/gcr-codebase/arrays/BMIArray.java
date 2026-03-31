/*
An organization took up an exercise to find the Body Mass Index (BMI) of all the persons in the team. Create a program to find the BMI and display the height, weight, BMI and status of each individual.
Hint =>
- Take input for a number of persons
- Create arrays to store the weight, height, BMI, and weight status of the persons
- Take input for the weight and height of the persons
- Calculate the BMI of all the persons and store them in an array and also find the weight status of the persons
- Display the height, weight, BMI, and weight status of each person
- Use the table to determine the weight status of the person
*/

import java.util.Scanner;

public class BMIArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of persons: ");
    int n = sc.nextInt();
    if (n <= 0) {
      System.out.println("Invalid number of persons.");
      sc.close();
      return;
    }

    double[] weights = new double[n];
    double[] heights = new double[n];
    double[] bmis = new double[n];
    String[] statuses = new String[n];

    for (int i = 0; i < n; i++) {
      double w;
      double h;

      while (true) {
        System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
        w = sc.nextDouble();
        if (w > 0)
          break;
        System.out.println("Invalid weight. Please enter a positive value.");
      }

      while (true) {
        System.out.print("Enter height (meters) for person " + (i + 1) + ": ");
        h = sc.nextDouble();
        if (h > 0)
          break;
        System.out.println("Invalid height. Please enter a positive value.");
      }

      weights[i] = w;
      heights[i] = h;

      double bmi = w / (h * h);
      bmis[i] = bmi;
      statuses[i] = classifyBMI(bmi);
    }

    System.out.println();
    System.out.println("Results:");
    for (int i = 0; i < n; i++) {
      System.out.printf(
          "Person %d -> Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
          (i + 1), heights[i], weights[i], bmis[i], statuses[i]);
    }

    sc.close();
  }

  private static String classifyBMI(double bmi) {
    if (bmi < 18.4)
      return "Underweight";
    if (bmi >= 18.5 && bmi <= 24.9)
      return "Normal";
    if (bmi >= 25.0 && bmi <= 29.9)
      return "Overweight";
    if (bmi >= 40.0)
      return "Obese";
    return "Unknown";
  }
}
