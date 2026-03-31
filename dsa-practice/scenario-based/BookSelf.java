import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

public class BookSelf {

  // Book-------------

  static class Book {
    String title;
    String author;

    Book(String title, String author) {
      this.title = title;
      this.author = author;
    }

    @Override
    public String toString() {
      return "\"" + title + "\" by " + author;
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof Book))
        return false;
      Book b = (Book) o;
      return title.equals(b.title) && author.equals(b.author);
    }

    @Override
    public int hashCode() {
      return Objects.hash(title, author);
    }

  }
  // Library----------

  static class Library {
    private final HashMap<String, LinkedList<Book>> catalog = new HashMap<>();
    private final Set<Book> uniqueBooks = new HashSet<>();

    public void addBook(String genre, Book book) {
      if (!uniqueBooks.add(book)) {
        System.out.println("Duplicate book avoided");
        return;
      }
      catalog.putIfAbsent(genre, new LinkedList<>());
      catalog.get(genre).add(book);
      System.out.println("Added-" + book);
    }

    public void borrowBook(String genre, Book book) {
      LinkedList<Book> list = catalog.get(genre);
      if (list != null && list.remove(book)) {
        uniqueBooks.remove(book);
        System.out.println("Borrowed: " + book);
      } else {
        System.out.println("Book not available");
      }
    }

    public void printCatalog() {
      catalog.forEach((genre, books) -> {
        System.out.println(genre + " - > " + books);
      });
    }
  }

  public static void main(String[] args) {
    Library lib = new Library();

    lib.addBook("Fiction", new Book("1984", "George Orwell"));
    lib.addBook("Fiction", new Book("Dune", "Frank Herbert"));

    lib.printCatalog();

    lib.borrowBook("Fiction", new Book("1984", "George Orwell"));
    lib.printCatalog();
  }

}
