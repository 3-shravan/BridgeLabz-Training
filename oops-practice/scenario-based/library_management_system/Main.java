package scenario_based.library_management_system;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    LibraryService service = new LibraryServiceImpl();
    seedData(service);

    Scanner sc = new Scanner(System.in);
    UtilInput in = new UtilInput(sc);

    while (true) {
      printMenu();
      int choice = in.readInt("Enter choice: ");
      try {
        switch (choice) {
        case 1: {
          String id = in.readNonEmptyString("Book id: ");
          String title = in.readNonEmptyString("Title: ");
          String author = in.readNonEmptyString("Author: ");
          int copies = in.readInt("Total copies: ");
          service.addBook(new Book(id, title, author, copies));
          System.out.println("Book added.");
          break;
        }
        case 2: {
          String id = in.readNonEmptyString("Book id to update: ");
          String title = in.readNonEmptyString("New title: ");
          String author = in.readNonEmptyString("New author: ");
          int copies = in.readInt("New total copies: ");
          service.updateBook(id, title, author, copies);
          System.out.println("Book updated.");
          break;
        }
        case 3: {
          String id = in.readNonEmptyString("Book id to delete: ");
          service.deleteBook(id);
          System.out.println("Book deleted.");
          break;
        }
        case 4: {
          List<Book> books = service.listBooks();
          if (books.isEmpty()) {
            System.out.println("No books found.");
            break;
          }
          System.out.println("Books:");
          for (Book b : books) {
            System.out.println("- " + b);
          }
          break;
        }
        case 5: {
          String type = in.readNonEmptyString("Member type (student/staff): ");
          String id = in.readNonEmptyString("Member id: ");
          String name = in.readNonEmptyString("Name: ");
          String phone = in.readNonEmptyString("Phone: ");
          String email = in.readNonEmptyString("Email: ");
          Member member = createMember(type, id, name, phone, email);
          service.registerMember(member);
          System.out.println("Member registered.");
          break;
        }
        case 6: {
          String id = in.readNonEmptyString("Member id to update: ");
          String name = in.readNonEmptyString("New name: ");
          String phone = in.readNonEmptyString("New phone: ");
          String email = in.readNonEmptyString("New email: ");
          service.updateMember(id, name, phone, email);
          System.out.println("Member updated.");
          break;
        }
        case 7: {
          String id = in.readNonEmptyString("Member id to delete: ");
          service.deleteMember(id);
          System.out.println("Member deleted.");
          break;
        }
        case 8: {
          List<Member> members = service.listMembers();
          if (members.isEmpty()) {
            System.out.println("No members found.");
            break;
          }
          System.out.println("Members:");
          for (Member m : members) {
            System.out.println("- " + m);
          }
          break;
        }
        case 9: {
          String memberId = in.readNonEmptyString("Member id: ");
          String bookId = in.readNonEmptyString("Book id: ");
          LocalDate issueDate = LocalDate.now();
          Transaction txn = service.issueBook(memberId, bookId, issueDate);
          System.out.println("Book issued: " + txn);
          break;
        }
        case 10: {
          String memberId = in.readNonEmptyString("Member id: ");
          String bookId = in.readNonEmptyString("Book id: ");
          LocalDate returnDate = LocalDate.now();
          Transaction txn = service.returnBook(memberId, bookId, returnDate);
          System.out.println("Book returned: " + txn);
          if (txn.getFineAmount() > 0) {
            System.out.println("Late fine: " + txn.getFineAmount());
          } else {
            System.out.println("No late fine.");
          }
          break;
        }
        case 11: {
          List<Transaction> txns = service.listTransactions();
          if (txns.isEmpty()) {
            System.out.println("No transactions.");
            break;
          }
          System.out.println("Transactions:");
          for (Transaction t : txns) {
            System.out.println("- " + t);
          }
          break;
        }
        case 0:
          System.out.println("Exiting...");
          sc.close();
          return;
        default:
          System.out.println("Invalid choice.");
        }
      } catch (BookNotAvailableException e) {
        System.out.println("Issue failed: " + e.getMessage());
      } catch (IllegalArgumentException | IllegalStateException e) {
        System.out.println("Error: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
      }
      System.out.println();
    }
  }

  private static void printMenu() {
    System.out.println("==== Library Management System ====");
    System.out.println("1. Add Book");
    System.out.println("2. Update Book");
    System.out.println("3. Delete Book");
    System.out.println("4. List Books");
    System.out.println("5. Register Member");
    System.out.println("6. Update Member");
    System.out.println("7. Delete Member");
    System.out.println("8. List Members");
    System.out.println("9. Issue Book");
    System.out.println("10. Return Book");
    System.out.println("11. List Transactions");
    System.out.println("0. Exit");
  }

  private static Member createMember(String type, String id, String name, String phone, String email) {
    if (type.equalsIgnoreCase("student")) {
      return new StudentMember(id, name, phone, email);
    }
    if (type.equalsIgnoreCase("staff")) {
      return new StaffMember(id, name, phone, email);
    }
    throw new IllegalArgumentException("Unknown member type: " + type);
  }

  private static void seedData(LibraryService service) {
    try {
      service.addBook(new Book("B101", "Clean Code", "Robert C. Martin", 2));
      service.addBook(new Book("B102", "Effective Java", "Joshua Bloch", 1));
      service.registerMember(new StudentMember("M201", "Asha", "9000000011", "asha@example.com"));
      service.registerMember(new StaffMember("M202", "Ravi", "9000000022", "ravi@example.com"));
    } catch (Exception ignored) {
      // ignore seed duplicates
    }
  }
}
