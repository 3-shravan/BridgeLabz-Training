public class LibraryManagementSystem {
  public static void main(String[] args) {

    Library library = new Library(5);

    library.addBook(new Book("Java Programming", "James Gosling"));
    library.addBook(new Book("Data Structures", "Mark Allen"));
    library.addBook(new Book("Clean Code", "Robert C. Martin"));

    System.out.println("All Books:");
    library.displayBooks();

    System.out.println("\nSearch Result:");
    library.searchBook("java");

    System.out.println("\nCheckout Book:");
    library.checkoutBook("Java Programming");

    System.out.println("\nUpdated Book List:");
    library.displayBooks();
  }
}

class Library {
  private Book[] books;
  private int bookCount;
  private static final int MAX_BOOKS = 100;

  public Library(int capacity) {
    books = new Book[capacity];
    bookCount = 0;
  }

  public void addBook(Book book) {
    if (bookCount < MAX_BOOKS) {
      books[bookCount++] = book;
    } else {
      System.out.println("Library is full. Cannot add more books.");
    }

  }

  public void displayBooks() {
    for (int i = 0; i < bookCount; i++) {
      books[i].displayBook();
    }
  }

  public void searchBook(String keyword) {
    boolean found = false;
    for (int i = 0; i < bookCount; i++) {
      if (books[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
        books[i].displayBook();
        found = true;
      }

    }
    if (!found) {
      System.out.println("No books found with the keyword: " + keyword);
    }
  }

  public void checkoutBook(String title) {
    for (int i = 0; i < bookCount; i++) {
      if (books[i].getTitle().equalsIgnoreCase(title)) {
        if (books[i].isAvailable()) {
          books[i].checkout();
          System.out.println("Book checked out successfully.");
        } else {
          System.out.println("Book already checked out.");
        }
        return;
      }
    }
    System.out.println("Book not found.");
  }

}

class Book {
  private String title;
  private String author;
  private boolean isAvailable;

  public Book(String title, String author) {
    this.title = title;
    this.author = author;
    this.isAvailable = true;
  }

  public String getTitle() {
    return title;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void checkout() {
    isAvailable = false;
  }

  public void returnBook() {
    isAvailable = true;
  }

  public void displayBook() {
    System.out.println("Title: " + title +
        ", Author: " + author +
        ", Status: " + (isAvailable ? "Available" : "Checked Out"));
  }

}
