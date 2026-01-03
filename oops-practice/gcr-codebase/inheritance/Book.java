public class Book {
  private String title;
  private int publicationYear;

  Book(String title, int publicationYear) {
    this.title = title;
    this.publicationYear = publicationYear;
  }

  void displayInfo() {
    System.out.println("Title: " + title);
    System.out.println("Publication Year: " + publicationYear);
  }

  public static void main(String[] args) {
    Author author = new Author("The Great Gatsby", 1925, "F. Scott Fitzgerald",
        "American novelist and short story writer.");
    author.displayInfo();
  }
}

class Author extends Book {
  String name;
  String bio;

  Author(String title, int publicationYear, String name, String bio) {
    super(title, publicationYear);
    this.name = name;
    this.bio = bio;
  }

  @Override
  void displayInfo() {
    super.displayInfo();
    System.out.println("Author Name: " + name);
    System.out.println("Author Bio: " + bio);
  }
}
