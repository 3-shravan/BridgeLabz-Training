import java.util.Scanner;

class EmptyTicketListException extends RuntimeException {
  public EmptyTicketListException(String message) {
    super(message);
  }
}

class TicketNotFoundException extends RuntimeException {
  public TicketNotFoundException(String message) {
    super(message);
  }
}

class TicketNode {
  int ticketId;
  String customerName;
  String movieName;
  String seatNumber;
  String bookingTime;

  TicketNode next;

  TicketNode(int ticketId, String customerName,
      String movieName, String seatNumber, String bookingTime) {
    this.ticketId = ticketId;
    this.customerName = customerName;
    this.movieName = movieName;
    this.seatNumber = seatNumber;
    this.bookingTime = bookingTime;
  }
}

class TicketReservationSystem {
  private TicketNode head;
  private TicketNode tail;

  void addTicket(int id, String customer, String movie,
      String seat, String time) {

    TicketNode newNode = new TicketNode(id, customer, movie, seat, time);

    if (head == null) {
      head = tail = newNode;
      newNode.next = newNode; // circular
      return;
    }

    tail.next = newNode;
    newNode.next = head;
    tail = newNode;
  }

  void removeTicket(int ticketId) {
    if (head == null) {
      throw new EmptyTicketListException("No tickets booked");
    }

    TicketNode curr = head;
    TicketNode prev = tail;

    do {
      if (curr.ticketId == ticketId) {

        // single ticket case
        if (head == tail) {
          head = tail = null;
          return;
        }

        prev.next = curr.next;

        if (curr == head)
          head = curr.next;
        if (curr == tail)
          tail = prev;

        return;
      }

      prev = curr;
      curr = curr.next;

    } while (curr != head);

    throw new TicketNotFoundException("Ticket not found: " + ticketId);
  }

  void displayTickets() {
    if (head == null) {
      throw new EmptyTicketListException("No tickets booked");
    }

    TicketNode temp = head;
    do {
      printTicket(temp);
      temp = temp.next;
    } while (temp != head);
  }

  void searchByCustomer(String customer) {
    if (head == null) {
      throw new EmptyTicketListException("No tickets booked");
    }

    TicketNode temp = head;
    boolean found = false;

    do {
      if (temp.customerName.equalsIgnoreCase(customer)) {
        printTicket(temp);
        found = true;
      }
      temp = temp.next;
    } while (temp != head);

    if (!found) {
      throw new TicketNotFoundException(
          "No ticket found for customer: " + customer);
    }
  }

  void searchByMovie(String movie) {
    if (head == null) {
      throw new EmptyTicketListException("No tickets booked");
    }

    TicketNode temp = head;
    boolean found = false;

    do {
      if (temp.movieName.equalsIgnoreCase(movie)) {
        printTicket(temp);
        found = true;
      }
      temp = temp.next;
    } while (temp != head);

    if (!found) {
      throw new TicketNotFoundException(
          "No tickets found for movie: " + movie);
    }
  }

  int countTickets() {
    if (head == null)
      return 0;

    int count = 0;
    TicketNode temp = head;

    do {
      count++;
      temp = temp.next;
    } while (temp != head);

    return count;
  }

  private void printTicket(TicketNode t) {
    System.out.println(
        "TicketID: " + t.ticketId +
            ", Customer: " + t.customerName +
            ", Movie: " + t.movieName +
            ", Seat: " + t.seatNumber +
            ", Time: " + t.bookingTime);
  }
}

public class OnlineTicketReservation {

  private static void printMenu() {
    System.out.println("\n==== Online Ticket Reservation ====");
    System.out.println("1. Book ticket");
    System.out.println("2. Cancel ticket (by ticket id)");
    System.out.println("3. Display all tickets");
    System.out.println("4. Search tickets (by customer name)");
    System.out.println("5. Search tickets (by movie name)");
    System.out.println("6. Count total tickets");
    System.out.println("0. Exit");
  }

  private static int readInt(Scanner scanner, String prompt) {
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

  private static String readNonEmptyString(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String input = scanner.nextLine().trim();
      if (!input.isEmpty()) {
        return input;
      }
      System.out.println("Input cannot be empty.");
    }
  }

  public static void main(String[] args) {
    TicketReservationSystem system = new TicketReservationSystem();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printMenu();
      int choice = readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            int ticketId = readInt(scanner, "Enter ticket id: ");
            String customer = readNonEmptyString(scanner, "Enter customer name: ");
            String movie = readNonEmptyString(scanner, "Enter movie name: ");
            String seat = readNonEmptyString(scanner, "Enter seat number: ");
            String time = readNonEmptyString(scanner, "Enter booking time: ");
            system.addTicket(ticketId, customer, movie, seat, time);
            System.out.println("Ticket booked successfully.");
            break;
          }
          case 2: {
            int ticketId = readInt(scanner, "Enter ticket id to cancel: ");
            system.removeTicket(ticketId);
            System.out.println("Ticket cancelled successfully.");
            break;
          }
          case 3: {
            system.displayTickets();
            break;
          }
          case 4: {
            String customer = readNonEmptyString(scanner, "Enter customer name to search: ");
            system.searchByCustomer(customer);
            break;
          }
          case 5: {
            String movie = readNonEmptyString(scanner, "Enter movie name to search: ");
            system.searchByMovie(movie);
            break;
          }
          case 6: {
            System.out.println("Total tickets: " + system.countTickets());
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
