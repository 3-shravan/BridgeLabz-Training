public class AreaOfCircle {
  int radius;

  AreaOfCircle(int r) {
    radius = r;
  }

  double area() {
    return 3.14 * radius * radius;
  }

  double circumference() {
    return 2 * 3.14 * radius;
  }

  public static void main(String[] args) {
    AreaOfCircle circle = new AreaOfCircle(5);
    System.out.println("Area: " + circle.area());
    System.out.println("Circumference: " + circle.circumference());
  }

}
