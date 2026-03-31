public class BookDetails {
  String title;
  String author;
  int price;

  BookDetails(String title, String author, int price) {
    this.title = title;
    this.author = author;
    this.price = price;
  }

  void displayDetails() {
    System.out.println("Title of the book: " + title);
    System.out.println("Author of the book: " + author);
    System.out.println("Price of the book: " + price);
  }

  public static void main(String[] args) {
    BookDetails book1 = new BookDetails("The Great Gatsby", "F. Scott Fitzgerald", 10);
    BookDetails book2 = new BookDetails("1984", "George Orwell", 15);

    book1.displayDetails();
    System.out.println();
    book2.displayDetails();
  }
}
