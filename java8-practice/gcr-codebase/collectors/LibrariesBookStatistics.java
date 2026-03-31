import java.util.Arrays;
import java.util.stream.Collectors;

class Book {
  private String genre;
  private int pages;

  public Book(String genre, int pages) {
    this.genre = genre;
    this.pages = pages;
  }

  public String getGenre() {
    return genre;
  }

  public int getPages() {
    return pages;
  }
}

public class LibrariesBookStatistics {
  public static void main(String[] args) {
    Arrays.asList(
        new Book("Science Fiction", 300),
        new Book("Fantasy", 500),
        new Book("Science Fiction", 250),
        new Book("Mystery", 400)).stream()
        .collect(Collectors.groupingBy(Book::getGenre, Collectors.summarizingInt(Book::getPages)))
        .forEach((genre, pageInfo) -> System.out.println(genre + " -> " + pageInfo));

  }
}
