import java.util.Scanner;

public class AreaOfCircle {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the radius of the circle: ");
    double radius = scanner.nextDouble();
    double area = Math.PI * radius * radius;
    System.out.println("The area of a circle with radius " + radius + " is: " + area);
    scanner.close();
  }
}
