/*
An organization took up the exercise to find the Body Mass Index (BMI) of all the persons in a team of 10 members. For this create a program to find the BMI and display the height, weight, BMI, and status of each individual
Hint => 
Take user input for the person's weight (kg) and height (cm) and store it in the corresponding 2D array of 10 rows. The First Column stores the weight and the second column stores the height in cm
Create a Method to find the BMI and status of every person given the person's height and weight and return the 2D String array. Use the formula BMI = weight / (height * height). Note unit is kg/m^2. For this convert cm to meter
Create a Method that takes the 2D array of height and weight as parameters. Calls the user-defined method to compute the BMI and the BMI Status and stores in a 2D String array of height, weight, BMI, and status.
Create a method to display the 2D string array in a tabular format of Person's Height, Weight, BMI, and the Status
Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class BMITeamMembers {

  final static int TEAM_SIZE = 10;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double[][] heightWeight = new double[TEAM_SIZE][2];

    for (int i = 0; i < TEAM_SIZE; i++) {
      System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
      double weight = sc.nextDouble();

      System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
      double height = sc.nextDouble();

      heightWeight[i][0] = weight;
      heightWeight[i][1] = height;
    }

    String[][] bmiStatusTable = calculateBMIAndStatus(heightWeight);
    displayBMIReport(bmiStatusTable);

    sc.close();
  }

  private static String[][] calculateBMIAndStatus(double[][] heightWeight) {
    String[][] result = new String[TEAM_SIZE][4];

    for (int i = 0; i < TEAM_SIZE; i++) {
      double weight = heightWeight[i][0];
      double heightCm = heightWeight[i][1];
      double heightM = heightCm / 100.0;

      double bmi = weight / (heightM * heightM);
      String status = getBMIStatus(bmi);

      result[i][0] = String.format("%.2f", heightCm);
      result[i][1] = String.format("%.2f", weight);
      result[i][2] = String.format("%.2f", bmi);
      result[i][3] = status;
    }

    System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
    for (int i = 0; i < TEAM_SIZE; i++) {
      System.out
          .println((i + 1) + "\t" + result[i][0] + "\t\t" + result[i][1] + "\t\t" + result[i][2] + "\t" + result[i][3]);
    }

    return result;

  }

  private static void displayBMIReport(String[][] result) {
    System.out.println("\nPerson\tHeight(cm)\tWeight(kg)\tBMI\t\tStatus");
    for (int i = 0; i < TEAM_SIZE; i++) {
      System.out
          .println((i + 1) + "\t" + result[i][0] + "\t\t" + result[i][1] + "\t\t" + result[i][2] + "\t" + result[i][3]);
    }
  }

  private static String getBMIStatus(double bmi) {

    if (bmi < 18.5)
      return "Underweight";
    else if (bmi < 25)
      return "Normal";
    else if (bmi < 30)
      return "Overweight";
    else
      return "Obese";
  }
}
