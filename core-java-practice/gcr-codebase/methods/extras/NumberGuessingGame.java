// Problem 1: Number Guessing Game
// Write a Java program where the user thinks of a number between 1 and 100, and
// the computer tries to guess the number by generating random guesses.
// The user provides feedback by indicating whether the guess is high, low, or
// correct. The program should be modular, with different functions for generating
// guesses, receiving user feedback, and determining the next guess.

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Think of a number between 1 and 100.");
    scanner.nextLine(); 
    int min = 1, max = 100;

    while (true) {
      int guess = generateGuess(min, max);
      System.out.println("Is your number " + guess + "?");

      String feedback = getFeedback(scanner);

      if (feedback.equalsIgnoreCase("correct")) {
        System.out.println("Yay! I guessed your number: " + guess);
        break;
      }
      if (feedback.equalsIgnoreCase("high")) {
        max = guess - 1;
      } else if (feedback.equalsIgnoreCase("low")) {
        min = guess + 1;
      }

    }

    scanner.close();
  }

  private static int generateGuess(int min, int max) {
    Random random = new Random();
    return random.nextInt(max - min + 1) + min;
  }

  private static String getFeedback(Scanner scanner) {
    System.out.print("Is it high, low, or correct? ");
    String feedback = scanner.nextLine().toLowerCase();

    if (!feedback.equals("high") &&
        !feedback.equals("low") &&
        !feedback.equals("correct")) {
      System.out.println("Invalid input. Try again.");
      return getFeedback(scanner);
    }

    return feedback;
  }

}
