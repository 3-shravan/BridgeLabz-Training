public class Book {
  private String title;
  private String author;
  private double price;

  Book() {
    this.title = "Unknown Title";
    this.author = "Unknown Author";
    this.price = 0.0;
  }

  Book(String title, String author, double price) {
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
