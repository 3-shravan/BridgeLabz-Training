package scenario_based.library_management_system;

public class Book {
  private final String id;
  private String title;
  private String author;
  private int totalCopies;
  private int availableCopies;

  public Book(String id, String title, String author, int totalCopies) {
    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("Book id cannot be empty");
    }
    if (totalCopies < 0) {
      throw new IllegalArgumentException("Total copies cannot be negative");
    }
    this.id = id.trim();
    this.title = title;
    this.author = author;
    this.totalCopies = totalCopies;
    this.availableCopies = totalCopies;
  }

  public String getId() {
    return id;
  }

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

  public int getTotalCopies() {
    return totalCopies;
  }

  public int getAvailableCopies() {
    return availableCopies;
  }

  public void setTotalCopies(int totalCopies) {
    if (totalCopies < 0) {
      throw new IllegalArgumentException("Total copies cannot be negative");
    }
    int issued = this.totalCopies - this.availableCopies;
    if (totalCopies < issued) {
      throw new IllegalArgumentException(
          "Total copies cannot be less than already issued copies (issued=" + issued + ")");
    }
    this.totalCopies = totalCopies;
    this.availableCopies = totalCopies - issued;
  }

  public void issueOneCopy() throws BookNotAvailableException {
    if (availableCopies <= 0) {
      throw new BookNotAvailableException("Book not available: '" + title + "' (id=" + id + ")");
    }
    availableCopies--;
  }

  public void returnOneCopy() {
    if (availableCopies < totalCopies) {
      availableCopies++;
    }
  }

  @Override
  public String toString() {
    return "Book{id='" + id + "', title='" + title + "', author='" + author + "', available=" + availableCopies + "/"
        + totalCopies + "}";
  }
}
