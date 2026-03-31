public class Book {
  private static String libraryName = "City Library";

  private String title;
  private String author;
  private final String ISBN;

  Book(String title, String author, String ISBN) {
    this.title = title;
    this.author = author;
    this.ISBN = ISBN;
  }

  static void displayLibraryName() {
    System.out.println("Library Name: " + libraryName);
  }

  public void showDetails() {
    if (this instanceof Book) {
      System.out.println("Title: " + title);
      System.out.println("Author: " + author);
      System.out.println("ISBN: " + ISBN);
    } else {
      System.out.println("This is not a Book instance.");
    }
  }

  public static void main(String[] args) {
    Book book1 = new Book("1984", "George Orwell", "1234567890");
    Book.displayLibraryName();
    book1.showDetails();
  }
}
