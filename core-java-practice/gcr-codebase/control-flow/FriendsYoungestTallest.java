
/*  Create a program to find the youngest friends among 3 Amar, Akbar, and Anthony based on their ages and the tallest among the friends based on their heights
 Hint => 
 Take user input for the age and height of the 3 friends and store it in a variable
 Find the smallest of the 3 ages to find the youngest friend and display it
 Find the largest of the 3 heights to find the tallest friend and display it
  */
import java.util.Scanner;

public class FriendsYoungestTallest {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter Amar's age: ");
    int amarAge = sc.nextInt();
    System.out.print("Enter Akbar's age: ");
    int akbarAge = sc.nextInt();
    System.out.print("Enter Anthony's age: ");
    int anthonyAge = sc.nextInt();

    System.out.print("Enter Amar's height: ");
    int amarHeight = sc.nextInt();
    System.out.print("Enter Akbar's height: ");
    int akbarHeight = sc.nextInt();
    System.out.print("Enter Anthony's height: ");
    int anthonyHeight = sc.nextInt();

    // Finding the youngest friend
    String youngest;
    if (amarAge < akbarAge && amarAge < anthonyAge) {
      youngest = "Amar";
    } else if (akbarAge < amarAge && akbarAge < anthonyAge) {
      youngest = "Akbar";
    } else {
      youngest = "Anthony";
    }
    System.out.println("The youngest friend is: " + youngest);
    // Finding the tallest friend
    String tallest;
    if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
      tallest = "Amar";
    } else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
      tallest = "Akbar";
    } else {
      tallest = "Anthony";
    }
    System.out.println("The tallest friend is: " + tallest);
    sc.close();
  }
}
