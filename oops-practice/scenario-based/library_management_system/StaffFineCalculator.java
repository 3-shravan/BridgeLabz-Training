package scenario_based.library_management_system;

public class StaffFineCalculator implements FineCalculator {
  private static final double FINE_PER_DAY = 1.0;

  @Override
  public double calculateFine(long daysLate) {
    if (daysLate <= 0) {
      return 0.0;
    }
    return daysLate * FINE_PER_DAY;
  }
}
