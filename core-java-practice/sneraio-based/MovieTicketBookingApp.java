
/**
 * Movie Ticket Booking App
 * Allows multiple customers to book movie tickets with seat and snack options
 * Uses switch and if statements for pricing logic
 */

import java.util.Scanner;

public class MovieTicketBookingApp {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean continueBooking = true;
    int totalRevenue = 0;
    int customerCount = 0;

    System.out.println("   Welcome to Movie Ticket Booking App   ");

    while (continueBooking) {
      customerCount++;
      System.out.println("\n--- Customer " + customerCount + " ---");

      System.out.println("\nAvailable Movies:");
      System.out.println("1. Action");
      System.out.println("2. Comedy");
      System.out.println("3. Drama");
      System.out.println("4. Horror");
      System.out.print("Enter movie type (1-4): ");
      int movieChoice = scanner.nextInt();

      String movieType = "";
      int moviePrice = 0;

      switch (movieChoice) {
        case 1:
          movieType = "Action";
          moviePrice = 200;
          break;
        case 2:
          movieType = "Comedy";
          moviePrice = 180;
          break;
        case 3:
          movieType = "Drama";
          moviePrice = 220;
          break;
        case 4:
          movieType = "Horror";
          moviePrice = 250;
          break;
        default:
          System.out.println("Invalid movie choice. Defaulting to Action.");
          movieType = "Action";
          moviePrice = 200;
      }

      System.out.println("\nSeat Types:");
      System.out.println("1. Silver (Standard)");
      System.out.println("2. Gold (Premium)");
      System.out.print("Enter seat type (1-2): ");
      int seatChoice = scanner.nextInt();

      String seatType = "";
      int seatPrice = 0;

      switch (seatChoice) {
        case 1:
          seatType = "Silver";
          seatPrice = 0;
          break;
        case 2:
          seatType = "Gold";
          seatPrice = 150;
          break;
        default:
          System.out.println("Invalid seat choice. Defaulting to Silver.");
          seatType = "Silver";
          seatPrice = 0;
      }

      System.out.println("\nSnack Options:");
      System.out.println("1. No Snacks");
      System.out.println("2. Popcorn (₹100)");
      System.out.println("3. Combo (Popcorn + Cold Drink) (₹200)");
      System.out.println("4. Premium Pack (Popcorn + Drink + Candy) (₹300)");
      System.out.print("Enter snack choice (1-4): ");
      int snackChoice = scanner.nextInt();

      String snackType = "";
      int snackPrice = 0;

      switch (snackChoice) {
        case 1:
          snackType = "No Snacks";
          snackPrice = 0;
          break;
        case 2:
          snackType = "Popcorn";
          snackPrice = 100;
          break;
        case 3:
          snackType = "Combo (Popcorn + Cold Drink)";
          snackPrice = 200;
          break;
        case 4:
          snackType = "Premium Pack";
          snackPrice = 300;
          break;
        default:
          System.out.println("Invalid snack choice. No snacks selected.");
          snackType = "No Snacks";
          snackPrice = 0;
      }

      int ticketPrice = moviePrice + seatPrice;
      int totalPrice = ticketPrice + snackPrice;

      double discountPercentage = 0.0;
      String discountReason = "";

      if (totalPrice >= 600) {
        discountPercentage = 15.0;
        discountReason = "Premium booking discount";
      } else if (totalPrice >= 400) {
        discountPercentage = 10.0;
        discountReason = "Standard booking discount";
      } else if (seatType.equals("Gold")) {
        discountPercentage = 5.0;
        discountReason = "Gold seat discount";
      }

      int discountAmount = (int) (totalPrice * discountPercentage / 100);
      int finalPrice = totalPrice - discountAmount;

      System.out.println("\n========== BOOKING SUMMARY ==========");
      System.out.println("Movie: " + movieType);
      System.out.println("Seat Type: " + seatType);
      System.out.println("Snacks: " + snackType);
      System.out.println("\nPrice Breakdown:");
      System.out.println("  Movie Ticket: ₹" + moviePrice);
      if (seatPrice > 0) {
        System.out.println("  Seat Upgrade: ₹" + seatPrice);
      }
      if (snackPrice > 0) {
        System.out.println("  Snacks: ₹" + snackPrice);
      }
      System.out.println("  Subtotal: ₹" + totalPrice);

      if (discountAmount > 0) {
        System.out.println("  Discount (" + discountPercentage + "%): -₹" + discountAmount +
            " (" + discountReason + ")");
      }
      System.out.println("  FINAL PRICE: ₹" + finalPrice);
      System.out.println("=====================================\n");

      totalRevenue += finalPrice;

      System.out.print("Does another customer want to book a ticket? (yes/no): ");
      String response = scanner.next().toLowerCase();
      continueBooking = response.equals("yes") || response.equals("y");
    }

    System.out.println("Total customers: " + customerCount);
    System.out.println("Total revenue: ₹" + totalRevenue);
    if (customerCount > 0) {
      System.out.println("Average ticket value: ₹" + (totalRevenue / customerCount));
    }
    System.out.println("\nThank you for using Movie Ticket Booking App!");

    scanner.close();
  }
}
