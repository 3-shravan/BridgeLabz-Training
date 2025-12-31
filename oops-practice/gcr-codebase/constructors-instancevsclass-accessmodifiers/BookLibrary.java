public class BookLibrary {
  String title;
  String author;
  double price;
  boolean isAvailable;

  BookLibrary() {
    this("Unknown Title", "Unknown Author", 0.0, true);
  }

  BookLibrary(String title, String author, double price, boolean isAvailable) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.isAvailable = isAvailable;
  }

  public void borrowBook() {
    if (isAvailable) {
      isAvailable = false;
      System.out.println("You have successfully borrowed the book: " + title);
    } else {
      System.out.println("Sorry, the book: " + title + " is currently not available.");
    }
  }

}