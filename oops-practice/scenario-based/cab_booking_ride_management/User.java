import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class User extends Person {

  private final List<Ride> rideHistory;

  public User(String userId, String name, String phone) {
    super(userId, name, phone);
    this.rideHistory = new ArrayList<>();
  }

  public void addRideToHistory(Ride ride) {
    if (ride != null) {
      rideHistory.add(ride);
    }
  }

  public List<Ride> getRideHistory() {
    return Collections.unmodifiableList(rideHistory);
  }

  public double getTotalSpent() {
    return rideHistory.stream().mapToDouble(Ride::getFare).sum();
  }
}
