// Problem: Random Number Analysis
// Write a program that generates five 4 digit random values and then finds their 
// average value, and their minimum and maximum value. 
// Use Math.random(), Math.min(), and Math.max().
// Hint:
// - Write a method that generates array of 4 digit random numbers given the size as a parameter
//   public int[] generate4DigitRandomArray(int size)
// - Write a method to find average, min and max value of an array
//   public double[] findAverageMinMax(int[] numbers)

public class RandomNumberAnalysis {
  private static final int NUM_RANDOM_VALUES = 5;

  public static void main(String[] args) {
    int[] randomNumbers = generate4DigitRandomArray(NUM_RANDOM_VALUES);

    System.out.println("Generated 4-digit Random Numbers:");
    for (int i = 0; i < randomNumbers.length; i++) {
      System.out.println("Number " + (i + 1) + ": " + randomNumbers[i]);
    }

    double[] stats = findAverageMinMax(randomNumbers);

    System.out.println("Average: " + stats[0]);
    System.out.println("Minimum: " + (int) stats[1]);
    System.out.println("Maximum: " + (int) stats[2]);
  }

  public static int[] generate4DigitRandomArray(int size) {
    int[] randomArray = new int[size];

    for (int i = 0; i < size; i++) {
      randomArray[i] = 1000 + (int) (Math.random() * 9000);
    }

    return randomArray;
  }

  public static double[] findAverageMinMax(int[] numbers) {
    double[] result = new double[3];

    int min = numbers[0];
    int max = numbers[0];
    double sum = 0;

    for (int number : numbers) {
      sum += number;
      min = Math.min(min, number);
      max = Math.max(max, number);
    }

    double average = sum / numbers.length;

    result[0] = average;
    result[1] = min;
    result[2] = max;

    return result;
  }
}
