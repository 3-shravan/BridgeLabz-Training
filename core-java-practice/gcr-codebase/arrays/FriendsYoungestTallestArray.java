/*
Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
Hint => 
Take user input for age and height for the 3 friends and store it in two arrays each to store the values for age and height of the 3 friends
Loop through the array and find the youngest of the 3 friends and the tallest of the 3 friends
Finally display the youngest and tallest of the 3 friends
*/

import java.util.Scanner;

public class FriendsYoungestTallestArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String[] names = { "Amar", "Akbar", "Anthony" };
    int[] ages = new int[3];
    double[] heights = new double[3];
    for (int i = 0; i < 3; i++) {
      System.out.print("Enter age of " + names[i] + ": ");
      ages[i] = sc.nextInt();
      System.out.print("Enter height of " + names[i] + " in cm: ");
      heights[i] = sc.nextDouble();
    }
    int youngestIndex = 0;
    int tallestIndex = 0;
    for (int i = 1; i < 3; i++) {
      if (ages[i] < ages[youngestIndex]) {
        youngestIndex = i;
      }
      if (heights[i] > heights[tallestIndex]) {
        tallestIndex = i;
      }
    }
    System.out.println("Youngest friend: " + names[youngestIndex] + " with age " + ages[youngestIndex]);
    System.out.println("Tallest friend: " + names[tallestIndex] + " with height " + heights[tallestIndex] + " cm");

    sc.close();
  }
}
