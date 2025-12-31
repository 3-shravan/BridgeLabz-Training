public class Circle {
  private double radius;

  Circle() {
    this(1.0);
  }

  Circle(double radius) {
    this.radius = radius;
  }

  double getArea() {
    return Math.PI * radius * radius;
  }

}
