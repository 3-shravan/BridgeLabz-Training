import java.util.List;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    RideService service = new RideServiceImpl();

    // Optional starter data
    service.registerDriver(new Driver("D001", "Raj Kumar", "9876543210"));
    service.registerDriver(new Driver("D002", "Priya Singh", "9876543211"));
    service.registerDriver(new Driver("D003", "Amit Patel", "9876543212"));

    Scanner scanner = new Scanner(System.in);

    boolean running = true;
    while (running) {
      printMenu();
      int choice = readInt(scanner, "Enter choice: ");

      try {
        switch (choice) {
          case 1:
            handleRegisterUser(scanner, service);
            break;
          case 2:
            handleRegisterDriver(scanner, service);
            break;
          case 3:
            handleBookRide(scanner, service);
            break;
          case 4:
            handleAcceptRide(scanner, service);
            break;
          case 5:
            handleCompleteRide(scanner, service);
            break;
          case 6:
            handleCancelRide(scanner, service);
            break;
          case 7:
            handleViewUserRideHistory(scanner, service);
            break;
          case 8:
            handleViewDriverRideHistory(scanner, service);
            break;
          case 9:
            handleViewUserSpent(scanner, service);
            break;
          case 10:
            handleViewDriverEarnings(scanner, service);
            break;
          case 11:
            handleViewAvailableDrivers(service);
            break;
          case 12:
            handleViewAllRides(service);
            break;
          case 13:
            handleViewFareInfo(service);
            break;
          case 0:
            running = false;
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid choice. Try again.");
        }
      } catch (NoDriverAvailableException e) {
        System.out.println("Booking failed: " + e.getMessage());
      } catch (IllegalArgumentException | IllegalStateException e) {
        System.out.println("Error: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
      }

      System.out.println();
    }

    scanner.close();
  }

  private static void printMenu() {
    System.out.println("==== Cab Booking / Ride Management System ====");
    System.out.println("1. Register User");
    System.out.println("2. Register Driver");
    System.out.println("3. Book Ride");
    System.out.println("4. Accept Ride (Driver)");
    System.out.println("5. Complete Ride");
    System.out.println("6. Cancel Ride");
    System.out.println("7. View User Ride History");
    System.out.println("8. View Driver Completed Rides");
    System.out.println("9. View User Total Spent");
    System.out.println("10. View Driver Total Earnings");
    System.out.println("11. View Available Drivers");
    System.out.println("12. View All Rides");
    System.out.println("13. View Fare Pricing Info");
    System.out.println("0. Exit");
  }

  private static void handleRegisterUser(Scanner scanner, RideService service) {
    String userId = readNonEmpty(scanner, "User ID: ");
    String name = readNonEmpty(scanner, "Name: ");
    String phone = readNonEmpty(scanner, "Phone: ");
    service.registerUser(new User(userId, name, phone));
    System.out.println("User registered successfully.");
  }

  private static void handleRegisterDriver(Scanner scanner, RideService service) {
    String driverId = readNonEmpty(scanner, "Driver ID: ");
    String name = readNonEmpty(scanner, "Name: ");
    String phone = readNonEmpty(scanner, "Phone: ");
    service.registerDriver(new Driver(driverId, name, phone));
    System.out.println("Driver registered successfully.");
  }

  private static void handleBookRide(Scanner scanner, RideService service)
      throws NoDriverAvailableException {
    String userId = readNonEmpty(scanner, "User ID: ");
    String pickupLocation = readNonEmpty(scanner, "Pickup Location: ");
    String dropLocation = readNonEmpty(scanner, "Drop Location: ");
    double distance = readDouble(scanner, "Distance (km): ");
    System.out.print("Is peak hour? (yes/no): ");
    boolean isPeakHour = scanner.nextLine().trim().equalsIgnoreCase("yes");

    Ride ride = service.bookRide(userId, pickupLocation, dropLocation, distance, isPeakHour);
    System.out.println("Ride booked successfully!");
    System.out.println(ride);
  }

  private static void handleAcceptRide(Scanner scanner, RideService service) {
    String driverId = readNonEmpty(scanner, "Driver ID: ");
    String rideId = readNonEmpty(scanner, "Ride ID: ");
    service.acceptRide(driverId, rideId);
    System.out.println("Ride accepted. Ride in progress.");
  }

  private static void handleCompleteRide(Scanner scanner, RideService service) {
    String rideId = readNonEmpty(scanner, "Ride ID: ");
    service.completeRide(rideId);
    System.out.println("Ride completed successfully.");
  }

  private static void handleCancelRide(Scanner scanner, RideService service) {
    String rideId = readNonEmpty(scanner, "Ride ID: ");
    service.cancelRide(rideId);
    System.out.println("Ride cancelled.");
  }

  private static void handleViewUserRideHistory(Scanner scanner, RideService service) {
    String userId = readNonEmpty(scanner, "User ID: ");
    List<Ride> history = service.getUserRideHistory(userId);
    if (history.isEmpty()) {
      System.out.println("No rides for this user.");
      return;
    }
    System.out.println("Ride History for User " + userId + ":");
    for (Ride ride : history) {
      System.out.println("- " + ride);
    }
  }

  private static void handleViewDriverRideHistory(Scanner scanner, RideService service) {
    String driverId = readNonEmpty(scanner, "Driver ID: ");
    List<Ride> history = service.getDriverRideHistory(driverId);
    if (history.isEmpty()) {
      System.out.println("No completed rides for this driver.");
      return;
    }
    System.out.println("Completed Rides for Driver " + driverId + ":");
    for (Ride ride : history) {
      System.out.println("- " + ride);
    }
  }

  private static void handleViewUserSpent(Scanner scanner, RideService service) {
    String userId = readNonEmpty(scanner, "User ID: ");
    double totalSpent = service.getUserTotalSpent(userId);
    System.out.println("Total spent by user: Rs." + String.format("%.2f", totalSpent));
  }

  private static void handleViewDriverEarnings(Scanner scanner, RideService service) {
    String driverId = readNonEmpty(scanner, "Driver ID: ");
    double totalEarnings = service.getDriverTotalEarnings(driverId);
    System.out.println("Total earnings for driver: Rs." + String.format("%.2f", totalEarnings));
  }

  private static void handleViewAvailableDrivers(RideService service) {
    List<Driver> available = service.getAvailableDrivers();
    if (available.isEmpty()) {
      System.out.println("No drivers available.");
      return;
    }
    System.out.println("Available Drivers:");
    for (Driver driver : available) {
      System.out.println("- " + driver + " | Rating: " + driver.getRating() + "/5");
    }
  }

  private static void handleViewAllRides(RideService service) {
    List<Ride> allRides = service.getAllRides();
    if (allRides.isEmpty()) {
      System.out.println("No rides available.");
      return;
    }
    System.out.println("All Rides:");
    for (Ride ride : allRides) {
      System.out.println("- " + ride);
    }
  }

  private static void handleViewFareInfo(RideService service) {
    System.out.println("Fare Calculation Methods:");
    System.out.println("1. " + new NormalFareCalculator());
    System.out.println("2. " + new PeakFareCalculator());
  }

  private static String readNonEmpty(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      if (value != null) {
        value = value.trim();
      }
      if (value != null && !value.isBlank()) {
        return value;
      }
      System.out.println("Input cannot be empty. Try again.");
    }
  }

  private static int readInt(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      try {
        return Integer.parseInt(value.trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
  }

  private static double readDouble(Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      try {
        return Double.parseDouble(value.trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid decimal number.");
      }
    }
  }
}
