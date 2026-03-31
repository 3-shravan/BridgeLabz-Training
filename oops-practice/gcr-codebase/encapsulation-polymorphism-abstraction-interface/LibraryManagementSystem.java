import java.util.ArrayList;
import java.util.List;

/*
 * Interface defining reservation-related behavior
 */
interface Reservable {
  void reserveItem(String borrowerName);

  boolean checkAvailability();
}

abstract class LibraryItem {
  private final int itemId;
  private String title;
  private String author;

  private String borrowerName;
  private boolean isAvailable = true;

  public LibraryItem(int itemId, String title, String author) {
    this.itemId = itemId;
    setTitle(title);
    setAuthor(author);
  }

  // Abstract method
  public abstract int getLoanDuration();

  // Concrete method
  public void getItemDetails() {
    System.out.println("Item ID        : " + itemId);
    System.out.println("Title          : " + title);
    System.out.println("Author         : " + author);
    System.out.println("Loan Duration  : " + getLoanDuration() + " days");
    System.out.println("Availability   : " + (isAvailable ? "Available" : "Reserved"));
  }

  // getters and setters
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  // Protected methods to manage sensitive borrower data
  protected void assignBorrower(String borrowerName) {
    this.borrowerName = borrowerName;
    this.isAvailable = false;
  }

  protected boolean isAvailable() {
    return isAvailable;
  }

  protected String getBorrowerDetails() {
    if (borrowerName == null)
      return "N/A";
    return "Borrower: " + borrowerName;
  }
}

/*
 * Book implementation
 */
class Book extends LibraryItem implements Reservable {

  public Book(int id, String title, String author) {
    super(id, title, author);
  }

  @Override
  public int getLoanDuration() {
    return 14; // days
  }

  @Override
  public void reserveItem(String borrowerName) {
    if (checkAvailability()) {
      assignBorrower(borrowerName);
    }
  }

  @Override
  public boolean checkAvailability() {
    return isAvailable();
  }
}

/*
 * Magazine implementation
 */
class Magazine extends LibraryItem implements Reservable {

  public Magazine(int id, String title, String author) {
    super(id, title, author);
  }

  @Override
  public int getLoanDuration() {
    return 7; // days
  }

  @Override
  public void reserveItem(String borrowerName) {
    if (checkAvailability()) {
      assignBorrower(borrowerName);
    }
  }

  @Override
  public boolean checkAvailability() {
    return isAvailable();
  }
}

/*
 * DVD implementation
 */
class DVD extends LibraryItem implements Reservable {

  public DVD(int id, String title, String director) {
    super(id, title, director);
  }

  @Override
  public int getLoanDuration() {
    return 3; // days
  }

  @Override
  public void reserveItem(String borrowerName) {
    if (checkAvailability()) {
      assignBorrower(borrowerName);
    }
  }

  @Override
  public boolean checkAvailability() {
    return isAvailable();
  }
}

public class LibraryManagementSystem {
  public static void main(String[] args) {

    List<LibraryItem> items = new ArrayList<>();

    LibraryItem b1 = new Book(1, "Clean Code", "Robert C. Martin");
    LibraryItem m1 = new Magazine(2, "Java Monthly", "Oracle");
    LibraryItem d1 = new DVD(3, "Inception", "Christopher Nolan");

    items.add(b1);
    items.add(m1);
    items.add(d1);

    // Reserve some items
    ((Reservable) b1).reserveItem("Alice");
    ((Reservable) d1).reserveItem("Bob");

    for (LibraryItem item : items) {
      item.getItemDetails();
    }

  }
}
