public class NormalFareCalculator implements FareCalculator {

  private static final double BASE_FARE = 50.0;
  private static final double PRICE_PER_KM = 15.0;

  @Override
  public double calculateFare(double distance) {
    if (distance <= 0) {
      throw new IllegalArgumentException("distance must be positive");
    }
    return BASE_FARE + (distance * PRICE_PER_KM);
  }

  @Override
  public String toString() {
    return "Normal Pricing (Base: Rs." + BASE_FARE + " + Rs." + PRICE_PER_KM + "/km)";
  }
}
