/*
Festival Lucky Draw 🎉
At Diwali mela, each visitor draws a number.
● If the number is divisible by 3 and 5, they win a gift.
● Use if, modulus, and loop for multiple visitors.
● continue if input is invalid.
*/

import java.util.Scanner;

public class FestivalLuckyDraw {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    while (true) {

      System.out.println("Enter your lucky number (or -1 to exit): ");
      int luckyno = sc.nextInt();
      if (luckyno == -1) {
        System.out.println("Exiting the lucky draw. Thank you!");
        break;
      }
      if (luckyno < 0) {
        System.out.println("Invalid input. Please enter a positive number.");
        continue;
      }
      if (luckyno % 3 == 0 && luckyno % 5 == 0) {
        System.out.println("Congratulations! You win a gift!");
      } else {
        System.out.println("Sorry, better luck next time.");
      }
    }
    sc.close();

  }

}
