import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideServiceImpl implements RideService {

  private final Map<String, User> usersById = new HashMap<>();
  private final Map<String, Driver> driversById = new HashMap<>();
  private final Map<String, Ride> ridesById = new HashMap<>();
  private final FareCalculator normalCalculator = new NormalFareCalculator();
  private final FareCalculator peakCalculator = new PeakFareCalculator();
  private int rideCounter = 0;

  @Override
  public void registerUser(User user) {
    if (user == null) {
      throw new IllegalArgumentException("user cannot be null");
    }
    usersById.put(user.getId(), user);
  }

  @Override
  public void registerDriver(Driver driver) {
    if (driver == null) {
      throw new IllegalArgumentException("driver cannot be null");
    }
    driversById.put(driver.getId(), driver);
  }

  @Override
  public Ride bookRide(String userId, String pickupLocation, String dropLocation,
      double distance, boolean isPeakHour) throws NoDriverAvailableException {
    User user = requireUser(userId);
    Driver driver = findAvailableDriver();

    FareCalculator calculator = isPeakHour ? peakCalculator : normalCalculator;
    double fare = calculator.calculateFare(distance);

    String rideId = "R" + System.currentTimeMillis() + (++rideCounter);
    Ride ride = new Ride(rideId, user, driver, pickupLocation, dropLocation, distance,
        isPeakHour, fare);

    driver.setAvailable(false);
    ridesById.put(rideId, ride);
    user.addRideToHistory(ride);

    return ride;
  }

  @Override
  public void acceptRide(String driverId, String rideId) {
    Driver driver = requireDriver(driverId);
    Ride ride = requireRide(rideId);

    if (ride.getDriver().getId().equals(driverId)) {
      ride.setStatus(Ride.RideStatus.IN_PROGRESS);
    } else {
      throw new IllegalArgumentException("Driver not assigned to this ride");
    }
  }

  @Override
  public void completeRide(String rideId) {
    Ride ride = requireRide(rideId);
    ride.setStatus(Ride.RideStatus.COMPLETED);
    Driver driver = ride.getDriver();
    driver.setAvailable(true);
    driver.addCompletedRide(ride);
  }

  @Override
  public void cancelRide(String rideId) {
    Ride ride = requireRide(rideId);
    if (!ride.getStatus().equals(Ride.RideStatus.COMPLETED)) {
      ride.setStatus(Ride.RideStatus.CANCELLED);
      Driver driver = ride.getDriver();
      driver.setAvailable(true);
    } else {
      throw new IllegalStateException("Cannot cancel completed ride");
    }
  }

  @Override
  public List<Ride> getUserRideHistory(String userId) {
    User user = requireUser(userId);
    return user.getRideHistory();
  }

  @Override
  public List<Ride> getDriverRideHistory(String driverId) {
    Driver driver = requireDriver(driverId);
    return driver.getCompletedRides();
  }

  @Override
  public double getUserTotalSpent(String userId) {
    User user = requireUser(userId);
    return user.getTotalSpent();
  }

  @Override
  public double getDriverTotalEarnings(String driverId) {
    Driver driver = requireDriver(driverId);
    return driver.getTotalEarnings();
  }

  @Override
  public List<Ride> getAllRides() {
    List<Ride> rides = new ArrayList<>(ridesById.values());
    return Collections.unmodifiableList(rides);
  }

  @Override
  public List<Driver> getAvailableDrivers() {
    List<Driver> available = new ArrayList<>();
    for (Driver driver : driversById.values()) {
      if (driver.isAvailable()) {
        available.add(driver);
      }
    }
    return Collections.unmodifiableList(available);
  }

  private User requireUser(String userId) {
    if (userId == null || userId.isBlank()) {
      throw new IllegalArgumentException("userId cannot be empty");
    }
    User user = usersById.get(userId);
    if (user == null) {
      throw new IllegalArgumentException("User not found: " + userId);
    }
    return user;
  }

  private Driver requireDriver(String driverId) {
    if (driverId == null || driverId.isBlank()) {
      throw new IllegalArgumentException("driverId cannot be empty");
    }
    Driver driver = driversById.get(driverId);
    if (driver == null) {
      throw new IllegalArgumentException("Driver not found: " + driverId);
    }
    return driver;
  }

  private Ride requireRide(String rideId) {
    if (rideId == null || rideId.isBlank()) {
      throw new IllegalArgumentException("rideId cannot be empty");
    }
    Ride ride = ridesById.get(rideId);
    if (ride == null) {
      throw new IllegalArgumentException("Ride not found: " + rideId);
    }
    return ride;
  }

  private Driver findAvailableDriver() throws NoDriverAvailableException {
    for (Driver driver : driversById.values()) {
      if (driver.isAvailable()) {
        return driver;
      }
    }
    throw new NoDriverAvailableException("No drivers available at the moment");
  }
}
