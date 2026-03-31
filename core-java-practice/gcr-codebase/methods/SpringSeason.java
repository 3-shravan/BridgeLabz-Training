/*
 * Write a program SpringSeason that takes two int values month and day from the command line
 * and prints "Its a Spring Season" otherwise prints "Not a Spring Season".
 * Spring Season is from March 20 to June 20.
 * Write a Method to check for Spring season and return a boolean true or false
 */

import java.util.Scanner;

public class SpringSeason {

  public static boolean isSpringSeason(int month, int day) {
    // Spring is from March 20 (month 3, day >= 20) to June 20 (month 6, day <= 20)
    if (month < 3 || month > 6) {
      return false;
    }

    if (month == 3 && day < 20) {
      return false;
    }

    if (month == 6 && day > 20) {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter month (1-12): ");
    int month = scanner.nextInt();

    System.out.print("Enter day (1-31): ");
    int day = scanner.nextInt();

    if (isSpringSeason(month, day)) {
      System.out.println("Its a Spring Season");
    } else {
      System.out.println("Not a Spring Season");
    }

    scanner.close();
  }
}
