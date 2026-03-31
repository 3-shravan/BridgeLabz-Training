/*
Rewrite the BMI program using a multi-dimensional array to store height, weight, and BMI for all persons.
Hint =>
- Take input for a number of persons
- Create a multi-dimensional array to store weight, height and BMI. Also create an array to store the weight status of the persons
      double[][] personData = new double[number][3];
      String[] weightStatus = new String[number];
- Take input for weight and height of the persons and for negative values, ask the user to enter positive values
- Calculate BMI of all the persons and store them in the personData array and also find the weight status and put them in the weightStatus array
- Display the height, weight, BMI and status of each person
*/

import java.util.Scanner;

public class BMIArray2D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter number of persons: ");
    int number = sc.nextInt();
    if (number <= 0) {
      System.out.println("Invalid number of persons.");
      sc.close();
      return;
    }

    double[][] personData = new double[number][3];
    String[] weightStatus = new String[number];

    for (int i = 0; i < number; i++) {
      double weight;
      double height;

      while (true) {
        System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
        weight = sc.nextDouble();
        if (weight > 0)
          break;
        System.out.println("Invalid weight. Please enter a positive value.");
      }

      while (true) {
        System.out.print("Enter height (meters) for person " + (i + 1) + ": ");
        height = sc.nextDouble();
        if (height > 0)
          break;
        System.out.println("Invalid height. Please enter a positive value.");
      }

      double bmi = weight / (height * height);

      personData[i][0] = weight;
      personData[i][1] = height;
      personData[i][2] = bmi;
      weightStatus[i] = classifyBMI(bmi);
    }

    System.out.println();
    System.out.println("Results:");
    for (int i = 0; i < number; i++) {
      System.out.printf(
          "Person %d -> Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
          (i + 1), personData[i][1], personData[i][0], personData[i][2], weightStatus[i]);
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
