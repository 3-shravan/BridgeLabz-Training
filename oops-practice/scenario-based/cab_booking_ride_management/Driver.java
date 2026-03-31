import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Driver extends Person {

  private boolean available;
  private double rating;
  private final List<Ride> completedRides;

  public Driver(String driverId, String name, String phone) {
    super(driverId, name, phone);
    this.available = true;
    this.rating = 5.0;
    this.completedRides = new ArrayList<>();
  }

  public boolean isAvailable() {
    return available;
  }

  public void setAvailable(boolean available) {
    this.available = available;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    if (rating < 0.0 || rating > 5.0) {
      throw new IllegalArgumentException("rating must be between 0 and 5");
    }
    this.rating = rating;
  }

  public void addCompletedRide(Ride ride) {
    if (ride != null) {
      completedRides.add(ride);
    }
  }

  public List<Ride> getCompletedRides() {
    return Collections.unmodifiableList(completedRides);
  }

  public double getTotalEarnings() {
    return completedRides.stream().mapToDouble(Ride::getFare).sum();
  }
}
