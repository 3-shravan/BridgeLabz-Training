import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Flight {
  private String flightNo;
  private String from;
  private String to;
  private boolean isAvailable;

  public boolean isAvailable() {
    return isAvailable;
  }

  public String getFlightNo() {
    return flightNo;
  }

  public String getFrom() {
    return from;
  }

  public String getTo() {
    return to;
  }

  public Flight(String flightNo, String from, String to, boolean isAvailable) {
    this.flightNo = flightNo;
    this.from = from;
    this.to = to;
    this.isAvailable = isAvailable;
  }
}

class User {
  private String userId;

  public String getUserId() {
    return userId;
  }

  private String name;

  public String getName() {
    return name;
  }

  public User(String userId, String name) {
    this.userId = userId;
    this.name = name;
  }
}

class Ticket {
  private String ticketId;

  public String getTicketId() {
    return ticketId;
  }

  private User user;
  private Flight flight;

  public Ticket(String ticketId, User user, Flight flight) {
    this.ticketId = ticketId;
    this.user = user;
    this.flight = flight;
  }

  public void displayTicketInfo() {
    System.out.println("Ticket ID: " + ticketId);
    System.out.println("Passenger ID: " + user.getUserId());
    System.out.println("Passenger Name: " + user.getName());
    System.out.println("Flight No: " + flight.getFlightNo());
    System.out.println("From: " + flight.getFrom());
    System.out.println("To: " + flight.getTo());
  }
}

class FlightService {
  List<Ticket> bookings = new ArrayList<>();

  class NotAvailableException extends Exception {
    public NotAvailableException(String message) {
      super(message);
    }
  }

  Flight[] flights = {
      new Flight("AI101", "New York", "London", true),
      new Flight("BA202", "London", "Paris", false),
      new Flight("DL303", "Paris", "Berlin", true)
  };

  public void displayAllFlights() {
    for (Flight flight : flights) {
      System.out.println("Flight No: " + flight.getFlightNo() +
          ", From: " + flight.getFrom() +
          ", To: " + flight.getTo() +
          ", Available: " + (flight.isAvailable() ? "Yes" : "No"));
    }
  }

  public Ticket bookFlight(int userId, String name, String flightno) throws NotAvailableException {
    for (Flight flight : flights) {
      if (flight.getFlightNo().equals(flightno) && flight.isAvailable()) {
        User user = new User(String.valueOf(userId), name);
        Ticket ticket = new Ticket("TCKT" + (bookings.size() + 1), user, flight);
        bookings.add(ticket);
        return ticket;
      }
    }
    throw new NotAvailableException("Flight " + flightno + " is not available.");
  }

  public void searchFlights(String keyword) {
    if (keyword == null)
      keyword = "";
    keyword = keyword.toLowerCase();

    List<Flight> results = new ArrayList<>();
    for (Flight flight : flights) {
      if (flight.getFrom().toLowerCase().contains(keyword) || flight.getTo().toLowerCase().contains(keyword)) {
        results.add(flight);
      }
    }

    if (results.isEmpty()) {
      System.out.println("No flights found for: " + keyword);
      return;
    }

    for (Flight flight : results) {
      System.out
          .println("Flight No: " + flight.getFlightNo() + ", From: " + flight.getFrom() + ", To: " + flight.getTo());
    }
  }

  public void cancelBooking(String ticketId) {
    boolean removed = bookings.removeIf(booking -> booking.getTicketId().equalsIgnoreCase(ticketId));
    if (removed) {
      System.out.println("Booking with Ticket ID " + ticketId + " has been cancelled.");
    } else {
      System.out.println("No booking found with Ticket ID " + ticketId + ".");
    }
  }

  public void displayBookings() {
    if (bookings.isEmpty()) {
      System.out.println("No bookings found.");
      return;
    }
    for (Ticket ticket : bookings) {
      ticket.displayTicketInfo();
      System.out.println("-----");
    }
  }

}

public class FlightBookingSystem {

  private static void printMenu() {
    System.out.println("\n==== Flight Booking System ====");
    System.out.println("1. View all flights");
    System.out.println("2. Search flights (by city keyword)");
    System.out.println("3. Book a flight");
    System.out.println("4. Cancel booking");
    System.out.println("5. View all bookings");
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
    FlightService service = new FlightService();
    Scanner scanner = new Scanner(System.in);

    while (true) {
      printMenu();
      int choice = readInt(scanner, "Enter your choice: ");

      try {
        switch (choice) {
          case 1: {
            service.displayAllFlights();
            break;
          }
          case 2: {
            String keyword = readNonEmptyString(scanner, "Enter city keyword (from/to): ");
            service.searchFlights(keyword);
            break;
          }
          case 3: {
            int userId = readInt(scanner, "Enter passenger id (number): ");
            String name = readNonEmptyString(scanner, "Enter passenger name: ");
            String flightNo = readNonEmptyString(scanner, "Enter flight number: ");
            Ticket ticket = service.bookFlight(userId, name, flightNo);
            System.out.println("Booking successful! Ticket details:");
            ticket.displayTicketInfo();
            break;
          }
          case 4: {
            String ticketId = readNonEmptyString(scanner, "Enter ticket id to cancel (e.g., TCKT1): ");
            service.cancelBooking(ticketId);
            break;
          }
          case 5: {
            service.displayBookings();
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
      } catch (FlightService.NotAvailableException e) {
        System.out.println("Error: " + e.getMessage());
      } catch (RuntimeException e) {
        System.out.println("Error: " + e.getMessage());
      }
    }

  }

}
