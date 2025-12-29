// Problem: Friends Youngest and Tallest
// Create a program to find the youngest friends among 3 Amar, Akbar and Anthony 
// based on their ages and tallest among the friends based on their heights and display it.
// Hint:
// - Take user input for age and height for the 3 friends and store it in two arrays 
//   each to store the values for age and height of the 3 friends
// - Write a Method to find the youngest of the 3 friends
// - Write a Method to find the tallest of the 3 friends

import java.util.Scanner;

public class FriendsYoungestTallest {
  private static final int NUM_FRIENDS = 3;
  private static final String[] FRIEND_NAMES = { "Amar", "Akbar", "Anthony" };

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int[] ages = new int[NUM_FRIENDS];
    double[] heights = new double[NUM_FRIENDS];

    // Take input for age and height
    System.out.println("Enter age and height for 3 friends:");
    for (int i = 0; i < NUM_FRIENDS; i++) {
      System.out.print("Enter age of " + FRIEND_NAMES[i] + ": ");
      ages[i] = scanner.nextInt();

      System.out.print("Enter height of " + FRIEND_NAMES[i] + " (in cm): ");
      heights[i] = scanner.nextDouble();
    }

    // Find youngest friend
    int youngestIndex = findYoungest(ages);
    System.out.println("\nYoungest Friend: " + FRIEND_NAMES[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");

    // Find tallest friend
    int tallestIndex = findTallest(heights);
    System.out.println("Tallest Friend: " + FRIEND_NAMES[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");

    scanner.close();
  }

  public static int findYoungest(int[] ages) {
    int youngestIndex = 0;
    for (int i = 1; i < ages.length; i++) {
      if (ages[i] < ages[youngestIndex]) {
        youngestIndex = i;
      }
    }
    return youngestIndex;
  }

  public static int findTallest(double[] heights) {
    int tallestIndex = 0;
    for (int i = 1; i < heights.length; i++) {
      if (heights[i] > heights[tallestIndex]) {
        tallestIndex = i;
      }
    }
    return tallestIndex;
  }
}
