import java.util.List;

public interface RideService {

  void registerUser(User user);

  void registerDriver(Driver driver);

  Ride bookRide(String userId, String pickupLocation, String dropLocation, double distance,
      boolean isPeakHour) throws NoDriverAvailableException;

  void acceptRide(String driverId, String rideId);

  void completeRide(String rideId);

  void cancelRide(String rideId);

  List<Ride> getUserRideHistory(String userId);

  List<Ride> getDriverRideHistory(String driverId);

  double getUserTotalSpent(String userId);

  double getDriverTotalEarnings(String driverId);

  List<Ride> getAllRides();

  List<Driver> getAvailableDrivers();
}
