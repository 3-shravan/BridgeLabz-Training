public class SnakeAndLadder {

  static final int WINNING_POSITION = 100;
  static int playerPosition = 0;
  static int dieRollCount = 0;

  public static void main(String[] args) {

    System.out.println("Starting Snake and Ladder Game");
    while (playerPosition < WINNING_POSITION) {
      int die = rollDie();
      int option = getOption();
      updatePosition(die, option);
      System.out.println("Current Position: " + playerPosition);
    }

    System.out.println("Congratulations! Reached position " + WINNING_POSITION);
    System.out.println("Total Die Rolls: " + dieRollCount);

  }

  private static int rollDie() {
    dieRollCount++;
    return (int) (Math.random() * 6) + 1;
  }

  private static int getOption() {
    return (int) (Math.random() * 3);
  }

  private static void updatePosition(int die, int option) {
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
