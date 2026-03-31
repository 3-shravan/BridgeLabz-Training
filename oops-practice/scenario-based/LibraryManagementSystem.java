import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Custom Exception
class BookNotAvailableException extends Exception {
  public BookNotAvailableException(String message) {
    super(message);
  }
}

// Book Class
class Book {
  private String title;
  private String author;
  private boolean available;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    this.available = true;
  }

  public String getTitle() {
    return title;
  }

  public boolean isAvailable() {
    return available;
  }

  public void checkout() throws BookNotAvailableException {
    if (!available) {
      throw new BookNotAvailableException("Book is already checked out.");
    }
    available = false;
  }

  public void display() {
    System.out.println("Title: " + title +
        ", Author: " + author +
        ", Status: " + (available ? "Available" : "Checked Out"));
  }
}

// Library Class
class Library {
  private List<Book> bookList;

  public Library(int capacity) {
    bookList = new ArrayList<>();
  }

  public void addBook(Book book) {
    bookList.add(book);
  }

  // Display all books
  public void displayBooks() {
    for (Book book : bookList) {
      book.display();
    }
  }

  // Search by partial title
  public void searchBook(String keyword) {
    boolean found = false;
    for (Book book : bookList) {
      if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        book.display();
        found = true;
      }
    }
    if (!found) {
      System.out.println("No books found for keyword: " + keyword);
    }
  }

  // Checkout a book
  public void checkoutBook(String title) {
    for (Book book : bookList) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        try {
          book.checkout();
          System.out.println("Book checked out successfully.");
        } catch (BookNotAvailableException e) {
          System.out.println(e.getMessage());
        }
        return;
      }
    }
    System.out.println("Book not found.");
  }
}

// Main Class
public class LibraryManagementSystem {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter library capacity: ");
    int capacity = sc.nextInt();
    sc.nextLine();

    Library library = new Library(capacity);

    for (int i = 0; i < capacity; i++) {
      System.out.print("Enter book title: ");
      String title = sc.nextLine();

      System.out.print("Enter book author: ");
      String author = sc.nextLine();

      library.addBook(new Book(title, author));
    }

    while (true) {
      System.out.println("\n1. Display Books\n2. Search Book\n3. Checkout Book\n4. Exit");
      System.out.print("Enter choice: ");
      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          library.displayBooks();
          break;
        case 2:
          System.out.print("Enter search keyword: ");
          library.searchBook(sc.nextLine());
          break;
        case 3:
          System.out.print("Enter book title to checkout: ");
          library.checkoutBook(sc.nextLine());
          break;
        case 4:
          System.out.println("Exiting...");
          sc.close();
          return;
        default:
          System.out.println("Invalid choice");
      }
    }

  }
}
