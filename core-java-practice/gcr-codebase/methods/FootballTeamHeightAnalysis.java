// Problem: Football Team Height Analysis
// Create a program to find the shortest, tallest, and mean height of players 
// present in a football team.
// Hint:
// - The formula to calculate the mean is: mean = sum of all elements/number of elements
// - Create an int array named heights of size 11 and get 3 digits random height in cms 
//   for each player in the range 150 cms to 250 cms
// - Write the method to Find the sum of all the elements present in the array.
// - Write the method to find the mean height of the players on the football team
// - Write the method to find the shortest height of the players on the football team
// - Write the method to find the tallest height of the players on the football team
// - Finally display the results

public class FootballTeamHeightAnalysis {
  private static final int NUM_PLAYERS = 11;
  private static final int MIN_HEIGHT = 150;
  private static final int MAX_HEIGHT = 250;

  public static void main(String[] args) {
    int[] heights = new int[NUM_PLAYERS];

    System.out.println("Football Team Players Heights (in cms):");
    for (int i = 0; i < NUM_PLAYERS; i++) {
      heights[i] = MIN_HEIGHT + (int) (Math.random() * (MAX_HEIGHT - MIN_HEIGHT + 1));
      System.out.println("Player " + (i + 1) + ": " + heights[i] + " cms");
    }

    int sum = findSum(heights);
    double mean = findMean(heights);
    int shortest = findShortest(heights);
    int tallest = findTallest(heights);

    System.out.println("Sum of all heights: " + sum + " cms");
    System.out.println("Mean height: " + String.format("%.2f", mean) + " cms");
    System.out.println("Shortest height: " + shortest + " cms");
    System.out.println("Tallest height: " + tallest + " cms");
  }

  public static int findSum(int[] heights) {
    int sum = 0;
    for (int height : heights) {
      sum += height;
    }
    return sum;
  }

  public static double findMean(int[] heights) {
    int sum = findSum(heights);
    return (double) sum / heights.length;
  }

  public static int findShortest(int[] heights) {
    int shortest = heights[0];
    for (int height : heights) {
      if (height < shortest) {
        shortest = height;
      }
    }
    return shortest;
  }

  public static int findTallest(int[] heights) {
    int tallest = heights[0];
    for (int height : heights) {
      if (height > tallest) {
        tallest = height;
      }
    }
    return tallest;
  }
}
