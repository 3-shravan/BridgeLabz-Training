
import java.util.Scanner;

class MovieEmptyListException extends RuntimeException {
  public MovieEmptyListException(String msg) {
    super(msg);
  }
}

class MovieNotFoundException extends RuntimeException {
  public MovieNotFoundException(String msg) {
    super(msg);
  }
}

class MovieInvalidPositionException extends RuntimeException {
  public MovieInvalidPositionException(String msg) {
    super(msg);
  }
}

class MovieNode {
  String title;
  String director;
  int year;
  double rating;

  MovieNode prev;
  MovieNode next;

  MovieNode(String title, String director, int year, double rating) {
    this.title = title;
    this.director = director;
    this.year = year;
    this.rating = rating;
    this.prev = null;
    this.next = null;
  }
}

class MovieDoublyLinkedList {

  private MovieNode head;
  private MovieNode tail;

  void addAtBeginning(String title, String director, int year, double rating) {
    MovieNode newNode = new MovieNode(title, director, year, rating);

    if (head == null) {
      head = tail = newNode;
      return;
    }

    newNode.next = head;
    head.prev = newNode;
    head = newNode;
  }

  void addAtEnd(String title, String director, int year, double rating) {
    MovieNode newNode = new MovieNode(title, director, year, rating);

    if (tail == null) {
      head = tail = newNode;
      return;
    }

    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
  }

  void addAtPosition(int position, String title, String director, int year, double rating) {
    if (position < 0)
      throw new MovieInvalidPositionException("Position cannot be negative");

    if (position == 0) {
      addAtBeginning(title, director, year, rating);
      return;
    }

    if (head == null)
      throw new MovieEmptyListException("List is empty");

    MovieNode temp = head;

    for (int i = 0; i < position - 1; i++) {
      if (temp.next == null)
        throw new MovieInvalidPositionException("Position out of bounds");
      temp = temp.next;
    }

    MovieNode newNode = new MovieNode(title, director, year, rating);

    newNode.next = temp.next;
    newNode.prev = temp;

    if (temp.next != null)
      temp.next.prev = newNode;
    else
      tail = newNode;

    temp.next = newNode;
  }

  void removeByTitle(String title) {
    if (head == null)
      throw new MovieEmptyListException("Movie list is empty");

    MovieNode temp = head;

    while (temp != null && !temp.title.equalsIgnoreCase(title)) {
      temp = temp.next;
    }

    if (temp == null)
      throw new MovieNotFoundException("Movie not found: " + title);

    if (temp == head)
      head = head.next;

    if (temp == tail)
      tail = tail.prev;

    if (temp.prev != null)
      temp.prev.next = temp.next;

    if (temp.next != null)
      temp.next.prev = temp.prev;

    temp.prev = null;
    temp.next = null;
  }

  void searchByDirector(String director) {
    if (head == null)
      throw new MovieEmptyListException("Movie list is empty");

    MovieNode temp = head;
    boolean found = false;

    while (temp != null) {
      if (temp.director.equalsIgnoreCase(director)) {
        displayMovie(temp);
        found = true;
      }
      temp = temp.next;
    }

    if (!found)
      throw new MovieNotFoundException("No movies by director: " + director);
  }

  private void displayMovie(MovieNode m) {
    System.out.println(
        "Title: " + m.title +
            ", Director: " + m.director +
            ", Year: " + m.year +
            ", Rating: " + m.rating);
  }

  void displayForward() {
    if (head == null)
      throw new MovieEmptyListException("Movie list is empty");

    MovieNode temp = head;
    while (temp != null) {
      displayMovie(temp);
      temp = temp.next;
    }
  }

  void displayBackward() {
    if (tail == null)
      throw new MovieEmptyListException("Movie list is empty");

    MovieNode temp = tail;
    while (temp != null) {
      displayMovie(temp);
      temp = temp.prev;
    }
  }

  void updateRating(String title, double newRating) {
    if (head == null)
      throw new MovieEmptyListException("Movie list is empty");

    MovieNode temp = head;

    while (temp != null) {
      if (temp.title.equalsIgnoreCase(title)) {
        temp.rating = newRating;
        return;
      }
      temp = temp.next;
    }

    throw new MovieNotFoundException("Movie not found: " + title);
  }

}

class Input {

  int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      try {
        return Integer.parseInt(input);
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid integer.");
      }
    }
  }

  double readDouble(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      try {
        return Double.parseDouble(input);
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
  }

  String readNonEmptyString(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Input cannot be empty.");
    }
  }
}

public class MovieManagementSystem {

  private static void printMenu() {
    System.out.println("\n==== Movie Management System ====");
    System.out.println("1. Add movie (beginning)");
    System.out.println("2. Add movie (end)");
    System.out.println("3. Add movie (at position)");
    System.out.println("4. Remove movie (by title)");
    System.out.println("5. Search movies (by director)");
    System.out.println("6. Display movies (forward)");
    System.out.println("7. Display movies (backward)");
    System.out.println("8. Update rating (by title)");
    System.out.println("0. Exit");
  }

  public static void main(String[] args) {
    MovieDoublyLinkedList movieList = new MovieDoublyLinkedList();
    Scanner scanner = new Scanner(System.in);
    Input input = new Input();

    while (true) {
      printMenu();
      int choice = input.readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            String title = input.readNonEmptyString(scanner, "Enter title: ");
            String director = input.readNonEmptyString(scanner, "Enter director: ");
            int year = input.readInt(scanner, "Enter release year: ");
            double rating = input.readDouble(scanner, "Enter rating: ");
            movieList.addAtBeginning(title, director, year, rating);
            System.out.println("Movie added at beginning.");
            break;
          }
          case 2: {
            String title = input.readNonEmptyString(scanner, "Enter title: ");
            String director = input.readNonEmptyString(scanner, "Enter director: ");
            int year = input.readInt(scanner, "Enter release year: ");
            double rating = input.readDouble(scanner, "Enter rating: ");
            movieList.addAtEnd(title, director, year, rating);
            System.out.println("Movie added at end.");
            break;
          }
          case 3: {
            int position = input.readInt(scanner, "Enter position (0-based): ");
            String title = input.readNonEmptyString(scanner, "Enter title: ");
            String director = input.readNonEmptyString(scanner, "Enter director: ");
            int year = input.readInt(scanner, "Enter release year: ");
            double rating = input.readDouble(scanner, "Enter rating: ");
            movieList.addAtPosition(position, title, director, year, rating);
            System.out.println("Movie added at position " + position + ".");
            break;
          }
          case 4: {
            String title = input.readNonEmptyString(scanner, "Enter title to remove: ");
            movieList.removeByTitle(title);
            System.out.println("Movie removed.");
            break;
          }
          case 5: {
            String director = input.readNonEmptyString(scanner, "Enter director to search: ");
            movieList.searchByDirector(director);
            break;
          }
          case 6: {
            movieList.displayForward();
            break;
          }
          case 7: {
            movieList.displayBackward();
            break;
          }
          case 8: {
            String title = input.readNonEmptyString(scanner, "Enter title to update rating: ");
            double newRating = input.readDouble(scanner, "Enter new rating: ");
            movieList.updateRating(title, newRating);
            System.out.println("Rating updated.");
            break;
          }
          case 0: {
            System.out.println("Exiting...");
            scanner.close();
            return;
          }
          default:
            System.out.println("Invalid choice. Please try again.");
        }
      } catch (RuntimeException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }
  }
}
