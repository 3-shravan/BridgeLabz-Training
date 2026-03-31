import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class NoDriverAvailableException extends Exception {
  public NoDriverAvailableException(String message) {
    super(message);
  }
}

interface FareCalculator {
  double calculateFare(double distanceInKm);
}

class PeekFare implements FareCalculator {
  private static final double RATE_PER_KM = 2.0;

  @Override
  public double calculateFare(double distanceInKm) {
    return distanceInKm * RATE_PER_KM * 1.5;
  }

  public double getRatePerKm() {
    return RATE_PER_KM * 1.5;
  }
}

class NormalFare implements FareCalculator {
  private static final double RATE_PER_KM = 2.0;

  @Override
  public double calculateFare(double distanceInKm) {
    return distanceInKm * RATE_PER_KM;
  }

  public double getRatePerKm() {
    return RATE_PER_KM;
  }
}

class User {
  private String userId;
  private String name;

  public User(String userId, String name) {
    this.userId = userId;
    this.name = name;
  }

  public String getUserId() {
    return userId;
  }

  public String getName() {
    return name;
  }
}

class Driver {
  private String driverId;
  private String name;
  private boolean isAvailable;

  public Driver(String driverId, String name) {
    this.driverId = driverId;
    this.name = name;
    this.isAvailable = true;
  }

  public String getDriverId() {
    return driverId;
  }

  public String getName() {
    return name;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean available) {
    isAvailable = available;
  }
}

class Ride {
  private User user;
  private Driver driver;
  private double fare;

  public Ride(User user, Driver driver, double fare) {
    this.user = user;
    this.driver = driver;
    this.fare = fare;
  }

  public void displayRide() {
    System.out.println("Ride Details:");
    System.out.println("User: " + user.getName() + " (ID: " + user.getUserId() + ")");
    System.out.println("Driver: " + driver.getName() + " (ID: " + driver.getDriverId() + ")");
    System.out.println("Fare: $" + fare);
  }

  public Driver getDriver() {
    return driver;
  }

  public double getFare() {
    return fare;
  }

  public User getUser() {
    return user;
  }

}

class Service {
  private List<Driver> drivers = new ArrayList<>();
  private List<Ride> rides = new ArrayList<>();

  public Service(List<Driver> drivers) {
    this.drivers = drivers;
  }

  public Ride bookRide(User user, double distanceInKm, FareCalculator fareCalculator)
      throws NoDriverAvailableException {

    for (Driver driver : drivers) {
      if (driver.isAvailable()) {
        double fare = fareCalculator.calculateFare(distanceInKm);
        driver.setAvailable(false);
        Ride ride = new Ride(user, driver, fare);
        rides.add(ride);
        return ride;
      }
    }
    throw new NoDriverAvailableException("No drivers available at the moment.");
  }

  public Ride bookRideWithDriver(User user, Driver selectedDriver, double distanceInKm,
      FareCalculator fareCalculator) throws NoDriverAvailableException {
    if (selectedDriver.isAvailable()) {
      double fare = fareCalculator.calculateFare(distanceInKm);
      selectedDriver.setAvailable(false);
      Ride ride = new Ride(user, selectedDriver, fare);
      rides.add(ride);
      return ride;
    } else {
      throw new NoDriverAvailableException("Selected driver is not available.");
    }
  }

  public void endRide(Ride ride) {
    ride.getDriver().setAvailable(true);
  }

  public Driver addDriver(String driverId, String name) {
    Driver driver = new Driver(driverId, name);
    drivers.add(driver);
    return driver;
  }

  public List<Driver> getDrivers() {
    return drivers;
  }

  public void displayRides() {
    if (rides.isEmpty()) {
      System.out.println("No rides have been booked yet.");
      return;
    }
    System.out.println("All Rides:");
    for (Ride ride : rides) {
      ride.displayRide();
      System.out.println("-------------------");
    }
  }
}

class RideManage {
  public void showOptions() {
    System.out.println("\nRide Management System");
    System.out.println("\n1. Book a Ride");
    System.out.println("2. View Drivers");
    System.out.println("3. Add a Driver");
    System.out.println("4. View Rides");
    System.out.println("5. Show Prices");
    System.out.println("6. Exit");
    System.out.print("Choose an option: ");
  }

  public boolean isTrafficPeakHour() {
    int value = (int) (Math.random() * 2);
    return value == 1;
  }

  public void showPrices() {
    FareCalculator normalFare = new NormalFare();
    FareCalculator peekFare = new PeekFare();
    System.out.println("Normal Fare Rate per KM: $" + normalFare.calculateFare(1));
    System.out.println("Peak Hour Fare Rate per KM: $" + peekFare.calculateFare(1));
  }

  public void addRandomDrivers(List<Driver> drivers) {
    drivers.add(new Driver("D4", "David"));
    drivers.add(new Driver("D5", "Eva"));
    drivers.add(new Driver("D6", "Frank"));
  }

  public User createUser(Scanner scanner) {
    System.out.print("Enter User ID: ");
    String userId = scanner.next();
    System.out.print("Enter User Name: ");
    String userName = scanner.next();
    User user = new User(userId, userName);
    return user;
  }

  public Ride autoAssignRide(Service service, User user, double distanceInKm, FareCalculator fareCalculator)
      throws NoDriverAvailableException {
    return service.bookRide(user, distanceInKm, fareCalculator);
  }

  public Ride bookRideWithSelectedDriver(Service service, User user, Driver selectedDriver,
      double distanceInKm, FareCalculator fareCalculator) throws NoDriverAvailableException {
    return service.bookRideWithDriver(user, selectedDriver, distanceInKm, fareCalculator);
  }

  public void HandleRideBooking() {
  }

}

public class RideManagementSystem {
  public static void main(String[] args) {

    RideManage rideManage = new RideManage();
    List<Driver> drivers = new ArrayList<>();
    rideManage.addRandomDrivers(drivers);
    Service service = new Service(drivers);
    Scanner scanner = new Scanner(System.in);

    while (true) {
      rideManage.showOptions();
      int choice = scanner.nextInt();
      if (choice == 6) {
        System.out.println("Exiting the system. Goodbye!");
        break;
      }
      try {
        handleUserChoice(choice, rideManage, service, scanner);
      } catch (NoDriverAvailableException e) {
        System.out.println(e.getMessage());
      }
    }
    scanner.close();

  }

  static void handleUserChoice(int choice, RideManage rideManage, Service service, Scanner scanner)
      throws NoDriverAvailableException {
    switch (choice) {
      case 1:
        User user = rideManage.createUser(scanner);
        System.out.print("Enter distance in KM: ");
        double distanceInKm = scanner.nextDouble();
        FareCalculator fareCalculator = rideManage.isTrafficPeakHour() ? new PeekFare() : new NormalFare();
        System.out.println("\n1. Select Driver \n2. Auto Assign Driver");
        int driverChoice = scanner.nextInt();
        Ride ride;
        if (driverChoice == 1) {
          System.out.println("Available Drivers:");
          for (Driver driver : service.getDrivers()) {
            System.out.println(driver.getName() + " (ID: " + driver.getDriverId() + ") - "
                + (driver.isAvailable() ? "Available" : "Not Available"));
          }
          System.out.print("Enter Driver ID to select: ");
          String selectedDriverId = scanner.next();
          Driver selectedDriver = null;
          for (Driver driver : service.getDrivers()) {
            if (driver.getDriverId().equals(selectedDriverId)) {
              selectedDriver = driver;
              break;
            }
          }
          if (selectedDriver != null) {
            ride = rideManage.bookRideWithSelectedDriver(service, user, selectedDriver, distanceInKm,
                fareCalculator);
          } else {
            System.out.println("Invalid Driver ID.");
            return;
          }
        } else {
          ride = rideManage.autoAssignRide(service, user, distanceInKm, fareCalculator);
        }

        System.out.println("\n\n Ride booked successfully!");
        ride.displayRide();
        System.out.println("Ending the ride...");
        service.endRide(ride);
        System.out.println("Ride ended. Driver is now available.");
        break;
      case 2:
        System.out.println("Available Drivers:");
        for (Driver driver : service.getDrivers()) {
          System.out.println(driver.getName() + " (ID: " + driver.getDriverId() + ") - "
              + (driver.isAvailable() ? "Available" : "Not Available"));
        }
        break;
      case 3:
        System.out.print("Enter Driver ID: ");
        String driverId = scanner.next();
        System.out.print("Enter Driver Name: ");
        String driverName = scanner.next();
        Driver driver = service.addDriver(driverId, driverName);
        System.out.println("Driver " + driver.getName() + " added successfully!");
        break;
      case 4:
        service.displayRides();
        break;
      case 5:
        rideManage.showPrices();
        break;
      default:
        System.out.println("Invalid choice. Please try again.");
    }

  }

}
