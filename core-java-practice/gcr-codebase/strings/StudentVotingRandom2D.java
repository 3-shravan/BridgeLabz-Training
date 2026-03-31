/*
Write a program to take user input for the age of all 10 students in a class and check whether the student can vote depending on his/her age is greater or equal to 18.
Hint => 
- Create a method to define the random 2-digit age of several students provided as method parameters and return a 1D array of ages of n students
- Create a method that takes an array of age as a parameter and returns a 2D String array of age and a boolean true or false to indicate can and cannot vote. Inside the method firstly validate the age for a negative number, if a negative cannot vote. For valid age check for age is 18 or above to set true to indicate can vote.
- Create a method to display the 2D array in a tabular format.
- Finally, the main function takes user inputs, calls the user-defined methods, and displays the result.
*/

import java.util.Scanner;

public class StudentVotingRandom2D {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of students: ");
    int n = sc.nextInt();
    int[] ages = generateRandomAges(n);
    String[][] votingEligibility = checkVotingEligibility(ages);
    displayVotingEligibility(votingEligibility);

    sc.close();
  }

  private static int[] generateRandomAges(int n) {
    int[] ages = new int[n];
    for (int i = 0; i < n; i++) {
      ages[i] = (int) (Math.random() * 82) + 18; // Random age between 18 and 99
    }
    return ages;
  }

  private static String[][] checkVotingEligibility(int[] ages) {
    String[][] result = new String[ages.length][2];
    for (int i = 0; i < ages.length; i++) {
      result[i][0] = String.valueOf(ages[i]);
      if (ages[i] < 0) {
        result[i][1] = "false"; // Invalid age
      } else if (ages[i] >= 18) {
        result[i][1] = "true"; // Can vote
      } else {
        result[i][1] = "false"; // Cannot vote
      }
    }
    return result;
  }

  private static void displayVotingEligibility(String[][] votingEligibility) {
    System.out.println("Age\tCan Vote");
    for (int i = 0; i < votingEligibility.length; i++) {
      System.out.println(votingEligibility[i][0] + "\t" + votingEligibility[i][1]);
    }
  }
}
