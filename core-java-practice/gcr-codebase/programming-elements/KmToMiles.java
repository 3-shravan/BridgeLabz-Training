import java.util.Scanner;

public class KmToMiles {
  // miles = kilometers * 0.621371

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("distance in kilometers: ");
    double kilometers = scanner.nextDouble();
    double miles = kilometers * 0.621371;

    System.out.println(miles);
    scanner.close();
  }
}
