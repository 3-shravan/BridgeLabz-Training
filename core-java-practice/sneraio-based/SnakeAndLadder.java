public class SnakeAndLadder {

  static final int WINNING_POSITION = 100;
  static int player1Position = 0;
  static int player2Position = 0;
  static int dieRollCount = 0;
  static String turn = "Player 1";
  static String winner = "";

  public static void main(String[] args) {

    System.out.println("Starting Snake and Ladder Game");
    while (player1Position < WINNING_POSITION && player2Position < WINNING_POSITION) {
      int die = rollDie();
      int option = getOption();

      System.out.println(turn + " rolled a " + die);

      if (turn.equals("Player 1")) {
        updatePosition(player1Position, die, option);
        if (player1Position == WINNING_POSITION) {
          winner = "Player 1";
          break;
        }
        if (player1Position < WINNING_POSITION && option != 1) {
          turn = "Player 2";
        }

      } else {
        updatePosition(player2Position, die, option);
        if (player2Position == WINNING_POSITION) {
          winner = "Player 2";
          break;
        }
        if (player2Position < WINNING_POSITION && option != 1) {
          turn = "Player 1";
        }
      }

    }

    System.out.println("Congratulations! Reached position " + WINNING_POSITION);
    System.out.println("Total Die Rolls: " + dieRollCount);
    System.out.println("Winner is: " + winner);
  }

  private static int rollDie() {
    dieRollCount++;
    return (int) (Math.random() * 6) + 1;
  }

  private static int getOption() {
    return (int) (Math.random() * 3);
  }

  private static void updatePosition(int playerPosition, int die, int option) {
    switch (option) {
      // No Play
      case 0:
        System.out.println("No Play. Position remains: " + playerPosition);
        break;
      // Ladder
      case 1:
        playerPosition += die;
        if (playerPosition > WINNING_POSITION) {
          playerPosition -= die;
        }
        System.out.println("Ladder! Moved to position: " + playerPosition);
        break;
      // Snake
      case 2:
        playerPosition -= die;
        if (playerPosition < 0) {
          playerPosition = 0;
        }
        System.out.println("Snake! Moved to position: " + playerPosition);
        break;
    }
  }
}
