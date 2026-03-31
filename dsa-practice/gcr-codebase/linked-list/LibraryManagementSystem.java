import java.util.Scanner;

class EmptyLibraryException extends RuntimeException {
  public EmptyLibraryException(String message) {
    super(message);
  }
}

class BookNotFoundException extends RuntimeException {
  public BookNotFoundException(String message) {
    super(message);
  }
}

class BookNode {
  int bookId;
  String title;
  String author;
  String genre;
  boolean isAvailable;

  BookNode next;
  BookNode prev;

  BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
    this.bookId = bookId;
    this.title = title;
    this.author = author;
    this.genre = genre;
    this.isAvailable = isAvailable;
  }
}

class LibraryDoublyLinkedList {
  private BookNode head;
  private BookNode tail;
  private int size;

  void addAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
    BookNode newNode = new BookNode(bookId, title, author, genre, isAvailable);
    if (head == null) {
      head = tail = newNode;
      size++;
      return;
    }
    newNode.next = head;
    newNode.prev = null;
    head.prev = newNode;
    head = newNode;
    size++;
  }

  void addAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
    BookNode newNode = new BookNode(bookId, title, author, genre, isAvailable);
    if (tail == null) {
      head = tail = newNode;
      size++;
      return;
    }
    tail.next = newNode;
    newNode.prev = tail;
    tail = newNode;
    size++;
  }

  void addAtPosition(int position, int id, String title, String author, String genre, boolean available) {

    if (position == 0) {
      addAtBeginning(id, title, author, genre, available);
      return;
    }
    BookNode targetNode = getTargetNode(position);
    BookNode newNode = new BookNode(id, title, author, genre, available);

    newNode.next = targetNode.next;
    newNode.prev = targetNode;

    if (targetNode.next != null) {
      targetNode.next.prev = newNode;
    } else
      tail = newNode;

    targetNode.next = newNode;
    size++;
  }

  private BookNode getTargetNode(int position) {
    if (position < 0)
      throw new InvalidPositionException("position cannot be zero");
    if (head == null && position != 0)
      throw new EmptyLibraryException("Library is empty. cannot insert at this index");

    BookNode curr = head;

    for (int i = 1; i < position; i++) {
      if (curr.next == null)
        throw new InvalidPositionException("Position out of wounds");
      curr = curr.next;
    }
    return curr;
  }

  void removeById(int id) {
    if (head == null)
      throw new EmptyLibraryException("Library is emplty");
    BookNode curr = head;
    while (curr != null && curr.bookId != id) {
      curr = curr.next;
    }
    if (curr == null)
      throw new BookNotFoundException("Book not found by this id");

    if (curr == head && curr == tail) {
      head = tail = null;
      size--;
      return;
    }

    if (curr == head) {
      head = head.next;
      if (head != null)
        head.prev = null;
      else
        tail = null;
      size--;
      return;
    }
    if (curr == tail) {
      tail = tail.prev;
      tail.next = null;
      size--;
      return;
    }

    curr.prev.next = curr.next;
    curr.next.prev = curr.prev;
    curr.next = curr.prev = null;
    size--;
  }

  BookNode searchByTitle(String title) {
    if (head == null)
      throw new EmptyLibraryException("Library is empty");
    BookNode curr = head;
    while (curr != null) {
      if (curr.title.equalsIgnoreCase(title)) {
        return curr;
      }
      curr = curr.next;
    }
    throw new BookNotFoundException("Book not found with title: " + title);
  }

  BookNode searchByAuthor(String author) {
    if (head == null)
      throw new EmptyLibraryException("Library is empty");
    BookNode curr = head;
    while (curr != null) {
      if (curr.author.equalsIgnoreCase(author)) {
        return curr;
      }
      curr = curr.next;
    }
    throw new BookNotFoundException("Book not found with author: " + author);

  }

  BookNode updateAvailability(int id, boolean isAvailable) {
    if (head == null)
      throw new EmptyLibraryException("Library is empty");
    BookNode curr = head;
    while (curr != null) {
      if (curr.bookId == id) {
        curr.isAvailable = isAvailable;
        return curr;
      }
      curr = curr.next;
    }
    throw new BookNotFoundException("Book not found with id: " + id);
  }

  void displayBookDetails(BookNode book) {
    System.out.println("Book ID: " + book.bookId);
    System.out.println("Title: " + book.title);
    System.out.println("Author: " + book.author);
    System.out.println("Genre: " + book.genre);
    System.out.println("Availability: " + (book.isAvailable ? "Available" : "Not Available"));
  }

  void displayForward() {
    if (head == null)
      throw new EmptyLibraryException("Library is empty");

    BookNode temp = head;

    while (temp != null) {
      displayBookDetails(temp);
      temp = temp.next;
    }
  }

  void displayReverse() {
    if (head == null)
      throw new EmptyLibraryException("Library is empty");
    BookNode temp = tail;
    while (temp != null) {
      displayBookDetails(temp);
      temp = temp.prev;
    }
  }

  int getSize() {
    return size;
  }

}

class LibraryInput {

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

  boolean readBoolean(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim().toLowerCase();

      if (input.equals("y") || input.equals("yes") || input.equals("true") || input.equals("1"))
        return true;
      if (input.equals("n") || input.equals("no") || input.equals("false") || input.equals("0"))
        return false;

      System.out.println("Please enter yes/no (y/n). ");
    }
  }
}

public class LibraryManagementSystem {

  private static void printMenu() {
    System.out.println("\n==== Library Management System ====");
    System.out.println("1. Add book (beginning)");
    System.out.println("2. Add book (end)");
    System.out.println("3. Add book (at position)");
    System.out.println("4. Remove book (by id)");
    System.out.println("5. Search book (by title)");
    System.out.println("6. Search book (by author)");
    System.out.println("7. Update availability (by id)");
    System.out.println("8. Display all (forward)");
    System.out.println("9. Display all (reverse)");
    System.out.println("10. Show total books");
    System.out.println("0. Exit");
  }

  public static void main(String[] args) {
    LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();
    Scanner scanner = new Scanner(System.in);
    LibraryInput input = new LibraryInput();

    while (true) {
      printMenu();
      int choice = input.readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            int id = input.readInt(scanner, "Enter book id: ");
            String title = input.readNonEmptyString(scanner, "Enter title: ");
            String author = input.readNonEmptyString(scanner, "Enter author: ");
            String genre = input.readNonEmptyString(scanner, "Enter genre: ");
            boolean available = input.readBoolean(scanner, "Is available? (y/n): ");
            library.addAtBeginning(id, title, author, genre, available);
            System.out.println("Book added at beginning.");
            break;
          }
          case 2: {
            int id = input.readInt(scanner, "Enter book id: ");
            String title = input.readNonEmptyString(scanner, "Enter title: ");
            String author = input.readNonEmptyString(scanner, "Enter author: ");
            String genre = input.readNonEmptyString(scanner, "Enter genre: ");
            boolean available = input.readBoolean(scanner, "Is available? (y/n): ");
            library.addAtEnd(id, title, author, genre, available);
            System.out.println("Book added at end.");
            break;
          }
          case 3: {
            int position = input.readInt(scanner, "Enter position (0-based): ");
            int id = input.readInt(scanner, "Enter book id: ");
            String title = input.readNonEmptyString(scanner, "Enter title: ");
            String author = input.readNonEmptyString(scanner, "Enter author: ");
            String genre = input.readNonEmptyString(scanner, "Enter genre: ");
            boolean available = input.readBoolean(scanner, "Is available? (y/n): ");
            library.addAtPosition(position, id, title, author, genre, available);
            System.out.println("Book added at position " + position + ".");
            break;
          }
          case 4: {
            int id = input.readInt(scanner, "Enter book id to remove: ");
            library.removeById(id);
            System.out.println("Book removed.");
            break;
          }
          case 5: {
            String title = input.readNonEmptyString(scanner, "Enter title to search: ");
            BookNode book = library.searchByTitle(title);
            library.displayBookDetails(book);
            break;
          }
          case 6: {
            String author = input.readNonEmptyString(scanner, "Enter author to search: ");
            BookNode book = library.searchByAuthor(author);
            library.displayBookDetails(book);
            break;
          }
          case 7: {
            int id = input.readInt(scanner, "Enter book id to update: ");
            boolean available = input.readBoolean(scanner, "Set available? (y/n): ");
            BookNode book = library.updateAvailability(id, available);
            System.out.println("Availability updated.");
            library.displayBookDetails(book);
            break;
          }
          case 8: {
            library.displayForward();
            break;
          }
          case 9: {
            library.displayReverse();
            break;
          }
          case 10: {
            System.out.println("Total books: " + library.getSize());
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
