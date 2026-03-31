import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ride {

  private final String rideId;
  private final User user;
  private final Driver driver;
  private final String pickupLocation;
  private final String dropLocation;
  private final double distance;
  private final boolean isPeakHour;
  private final double fare;
  private final LocalDateTime bookingTime;
  private RideStatus status;

  public enum RideStatus {
    BOOKED, IN_PROGRESS, COMPLETED, CANCELLED
  }

  public Ride(String rideId, User user, Driver driver, String pickupLocation,
      String dropLocation, double distance, boolean isPeakHour, double fare) {
    if (rideId == null || rideId.isBlank()) {
      throw new IllegalArgumentException("rideId cannot be empty");
    }
    if (user == null || driver == null) {
      throw new IllegalArgumentException("user and driver cannot be null");
    }
    if (distance <= 0) {
      throw new IllegalArgumentException("distance must be positive");
    }
    if (fare < 0) {
      throw new IllegalArgumentException("fare cannot be negative");
    }
    this.rideId = rideId;
    this.user = user;
    this.driver = driver;
    this.pickupLocation = pickupLocation != null ? pickupLocation : "Unknown";
    this.dropLocation = dropLocation != null ? dropLocation : "Unknown";
    this.distance = distance;
    this.isPeakHour = isPeakHour;
    this.fare = fare;
    this.bookingTime = LocalDateTime.now();
    this.status = RideStatus.BOOKED;
  }

  public String getRideId() {
    return rideId;
  }

  public User getUser() {
    return user;
  }

  public Driver getDriver() {
    return driver;
  }

  public String getPickupLocation() {
    return pickupLocation;
  }

  public String getDropLocation() {
    return dropLocation;
  }

  public double getDistance() {
    return distance;
  }

  public boolean isPeakHour() {
    return isPeakHour;
  }

  public double getFare() {
    return fare;
  }

  public LocalDateTime getBookingTime() {
    return bookingTime;
  }

  public RideStatus getStatus() {
    return status;
  }

  public void setStatus(RideStatus status) {
    this.status = status;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return rideId + " | " + user.getName() + " -> " + driver.getName() + " | "
        + pickupLocation + " to " + dropLocation + " (" + distance + "km) | "
        + "Fare: Rs." + fare + " | " + status + " | " + bookingTime.format(formatter);
  }
}
