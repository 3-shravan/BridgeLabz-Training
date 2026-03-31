/*
Rock-Paper-Scissors is a game played between a minimum of two players. Each player can choose either rock, paper, or scissors. Here the game is played between a user and a computer. Based on the rules, either a player or a computer will win. Show the stats of player and computer win in a tabular format across multiple games. Also, show the winning percentage between the player and the computer.
Hint => 
The rule is: rock-scissors: rock will win (rock crushes scissors); rock-paper: paper wins (paper covers rock); scissors-paper: scissors win (scissors cuts paper)
Create a Method to find the Computer Choice using the Math.random
Create a Method to find the winner between the user and the computer
Create a Method to find the average and percentage of wins for the user and the computer and return a String 2D array
Create a Method to display the results of every game and also display the average and percentage wins 
In the main take user input for the number of games and call methods to display results
*/

import java.util.Scanner;

public class RockPaperScissorsStats {
  private static final String[] choices = { "rock", "paper", "scissors" };

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter number of games to play: ");
    int numberOfGames = sc.nextInt();
    int userWins = 0;
    int computerWins = 0;
    int ties = 0;

    for (int i = 0; i < numberOfGames; i++) {
      System.out.print("Enter your choice (rock, paper, scissors): ");
      String userChoice = sc.next().toLowerCase();

      String computerChoice = getComputerChoice();
      System.out.println("Computer chose: " + computerChoice);

      String winner = determineWinner(userChoice, computerChoice);
      if (winner.equals("user")) {
        userWins++;
        System.out.println("You win this round!");
        String[][] stats = calculateStats(userWins, computerWins, ties, i + 1);
        displayResults(stats, i + 1);

      } else if (winner.equals("computer")) {
        computerWins++;
        System.out.println("Computer wins this round!");
        String[][] stats = calculateStats(userWins, computerWins, ties, i + 1);
        displayResults(stats, i + 1);
      } else {
        ties++;
        System.out.println("This round is a tie!");
        String[][] stats = calculateStats(userWins, computerWins, ties, i + 1);
        displayResults(stats, i + 1);
      }

    }

    String[][] stats = calculateStats(userWins, computerWins, ties, numberOfGames);
    displayResults(stats, numberOfGames);

    sc.close();
  }

  private static String getComputerChoice() {
    int index = (int) (Math.random() * 3);
    return choices[index];
  }

  private static String determineWinner(String userChoice, String computerChoice) {
    if (userChoice.equals(computerChoice)) {
      return "tie";
    } else if ((userChoice.equals("rock") && computerChoice.equals("scissors"))
        || (userChoice.equals("paper") && computerChoice.equals("rock"))
        || (userChoice.equals("scissors") && computerChoice.equals("paper"))) {
      return "user";
    } else {
      return "computer";
    }
  }

  private static String[][] calculateStats(int userWins, int computerWins, int ties, int totalGames) {
    String[][] stats = new String[3][2];

    stats[0][0] = "User Wins";
    stats[0][1] = String.valueOf(userWins);
    stats[1][0] = "Computer Wins";
    stats[1][1] = String.valueOf(computerWins);
    stats[2][0] = "Ties";
    stats[2][1] = String.valueOf(ties);

    return stats;
  }

  private static void displayResults(String[][] stats, int totalGames) {
    System.out.println("\nGame Results:");
    System.out.println("Category\tCount");
    for (int i = 0; i < stats.length; i++) {
      System.out.println(stats[i][0] + "\t" + stats[i][1]);
    }

    double userWinPercentage = (Double.parseDouble(stats[0][1]) / totalGames) * 100;
    double computerWinPercentage = (Double.parseDouble(stats[1][1]) / totalGames) * 100;

    System.out.printf("\nUser Win Percentage: %.2f%%\n", userWinPercentage);
    System.out.printf("Computer Win Percentage: %.2f%%\n", computerWinPercentage);
  }
}
