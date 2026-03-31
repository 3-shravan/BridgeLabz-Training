import java.util.List;

class RobotSafetyException extends Exception {
  public RobotSafetyException(String message) {
    super(message);
  }
}

public class FactoryRobotHazardAnalyzer {

  public static void main(String[] args) {
    RobotHazardAuditor auditor = new RobotHazardAuditor();
    try {
      double risk = auditor.calculateHazardRisk(0.5, 10, "Critical");
      System.out.println("Robot Hazard Risk Score: " + risk);
    } catch (RobotSafetyException e) {
      System.err.println(e.getMessage());
    }
  }

}

class RobotHazardAuditor {
  private static final List<String> MACHINERY_STATES = List.of("Worn", "Faulty", "Critical");

  public double calculateHazardRisk(double armPrecision, int workerDensity, String machineryState)
      throws RobotSafetyException {
    if (armPrecision < 0.0 && armPrecision > 1.0) {
      throw new RobotSafetyException("Arm precision must be between 0.0 and 1.0");
    }
    if (workerDensity < 1 && workerDensity > 20) {
      throw new RobotSafetyException("Worker density must be between 1 and 20");
    }
    if (!MACHINERY_STATES.contains(machineryState)) {
      throw new RobotSafetyException("Error: Unsupported machinery state.");
    }
    return ((1.0 - armPrecision) * 15.0) + (workerDensity * getMachineryStateRiskFactor(machineryState));

  }

  private double getMachineryStateRiskFactor(String machineryState) {
    return switch (machineryState) {
    case "Worn" -> 1.3;
    case "Faulty" -> 2.0;
    case "Critical" -> 3.0;
    default -> 1.0;
    };
  }
}
