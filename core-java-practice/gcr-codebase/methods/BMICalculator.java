// Problem: Body Mass Index (BMI) Calculator
// An organization took up the exercise to find the Body Mass Index (BMI) of all the persons 
// in the team of 10 members.
// Hint:
// - Take user input in double for the weight (in kg) of the person and height (in cm) for the person 
//   and store it in the corresponding 2D array of 10 rows and 3 columns.
//   The First Column storing the weight, the second column storing the height in cm and the third column is the BMI
// - Create a Method to find the BMI of every person and populate the array. 
//   Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
// - Create a Method to determine the BMI status using the logic:
//   Underweight: BMI < 18.5
//   Normal weight: 18.5 <= BMI < 25
//   Overweight: 25 <= BMI < 30
//   Obese: BMI >= 30

import java.util.Scanner;

public class BMICalculator {
  private static final int NUM_PERSONS = 10;
  private static final int WEIGHT_COLUMN = 0;
  private static final int HEIGHT_COLUMN = 1;
  private static final int BMI_COLUMN = 2;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    double[][] teamData = new double[NUM_PERSONS][3];

    System.out.println("Enter weight (kg) and height (cm) for " + NUM_PERSONS + " team members:");
    for (int i = 0; i < NUM_PERSONS; i++) {
      System.out.print("\nPerson " + (i + 1) + ":");
      System.out.print("\n  Enter weight (kg): ");
      teamData[i][WEIGHT_COLUMN] = scanner.nextDouble();

      System.out.print("  Enter height (cm): ");
      teamData[i][HEIGHT_COLUMN] = scanner.nextDouble();
    }

    calculateBMI(teamData);

    System.out.println("BMI Report for All Team Members");
    System.out.printf("%-8s %-12s %-12s %-8s %-15s%n", "Person", "Weight(kg)", "Height(cm)", "BMI", "Status");

    for (int i = 0; i < NUM_PERSONS; i++) {
      String status = getBMIStatus(teamData[i][BMI_COLUMN]);
      System.out.printf("%-8d %-12.2f %-12.2f %-8.2f %-15s%n",
          (i + 1),
          teamData[i][WEIGHT_COLUMN],
          teamData[i][HEIGHT_COLUMN],
          teamData[i][BMI_COLUMN],
          status);
    }

    scanner.close();
  }

  public static void calculateBMI(double[][] data) {
    for (int i = 0; i < data.length; i++) {
      double weight = data[i][WEIGHT_COLUMN];
      double heightInCm = data[i][HEIGHT_COLUMN];

      double heightInMeters = heightInCm / 100;

      double bmi = weight / (heightInMeters * heightInMeters);

      data[i][BMI_COLUMN] = bmi;
    }
  }

  public static String getBMIStatus(double bmi) {
    if (bmi < 18.5) {
      return "Underweight";
    } else if (bmi < 25) {
      return "Normal weight";
    } else if (bmi < 30) {
      return "Overweight";
    } else {
      return "Obese";
    }
  }
}
