public class PeakFareCalculator implements FareCalculator {

  private static final double BASE_FARE = 100.0;
  private static final double PRICE_PER_KM = 25.0;
  private static final double SURGE_MULTIPLIER = 1.5;

  @Override
  public double calculateFare(double distance) {
    if (distance <= 0) {
      throw new IllegalArgumentException("distance must be positive");
    }
    double baseFare = BASE_FARE + (distance * PRICE_PER_KM);
    return baseFare * SURGE_MULTIPLIER;
  }

  @Override
  public String toString() {
    return "Peak Hour Pricing (Base: Rs." + BASE_FARE + " + Rs." + PRICE_PER_KM
        + "/km, Surge: " + SURGE_MULTIPLIER + "x)";
  }
}
