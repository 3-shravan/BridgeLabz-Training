import java.util.Scanner;

public class LineComparison {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Line Length (Cartesian Coordinates)");

    // line 1
    System.out.print("Enter x1: ");
    double x1 = scanner.nextDouble();
    System.out.print("Enter y1: ");
    double y1 = scanner.nextDouble();
    System.out.print("Enter x2: ");
    double x2 = scanner.nextDouble();
    System.out.print("Enter y2: ");
    double y2 = scanner.nextDouble();

    // line 2
    System.out.print("Enter x3: ");
    double x3 = scanner.nextDouble();
    System.out.print("Enter y3: ");
    double y3 = scanner.nextDouble();
    System.out.print("Enter x4: ");
    double x4 = scanner.nextDouble();
    System.out.print("Enter y4: ");
    double y4 = scanner.nextDouble();

    Double length1 = calculateLength(x1, y1, x2, y2);
    Double length2 = calculateLength(x3, y3, x4, y4);

    // uc-1 : Calculate lengths
    System.out.println("Length of Line 1: " + length1);
    System.out.println("Length of Line 2: " + length2);

    // UC2: Check equality using equals()
    if (length1.equals(length2)) {
      System.out.println("Both Lines are Equal");
    } else {
      System.out.println("Both Lines are Not Equal");
    }

    // UC3: Compare lengths using compareTo()
    int result = length1.compareTo(length2);

    if (result == 0) {
      System.out.println("Both Lines are Equal");
    } else if (result < 0) {
      System.out.println("Line 1 is Smaller than Line 2");
    } else {
      System.out.println("Line 1 is Greater than Line 2");
    }

    scanner.close();
  }

  static Double calculateLength(double x1, double y1, double x2, double y2) {
    return Math.sqrt(
        Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
  }

}
