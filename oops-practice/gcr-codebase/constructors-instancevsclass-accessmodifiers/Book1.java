public class Book1 {
  private String title;
  private String author;
  private double price;

  Book1() {
    this.title = "Unknown Title";
    this.author = "Unknown Author";
    this.price = 0.0;
  }

  Book1(String title, String author, double price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }

  void displayInfo() {
    System.out.println("Title: " + title);
    System.out.println("Author: " + author);
    System.out.println("Price: $" + price);
  }
}
