public class Book2 {

  public String ISBN;
  protected String title;
  private String author;

  public Book2(String ISBN, String title, String author) {
    this.ISBN = ISBN;
    this.title = title;
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }
}

class EBook extends Book2 {

  public EBook(String ISBN, String title, String author) {
    super(ISBN, title, author);
  }

  public void printDetails() {
    System.out.println("ISBN: " + ISBN);
    System.out.println("Title: " + title);
    System.out.println("Author: " + getAuthor());
  }
}
