import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Vessel {
  String vesselId;
  String vesselName;
  double averageSpeed;
  String vesselType;

  public String getVesselId() {
    return vesselId;
  }

  public void setVesselId(String vesselId) {
    this.vesselId = vesselId;
  }

  public String getVesselName() {
    return vesselName;
  }

  public void setVesselName(String vesselName) {
    this.vesselName = vesselName;
  }

  public double getAverageSpeed() {
    return averageSpeed;
  }

  public void setAverageSpeed(double averageSpeed) {
    this.averageSpeed = averageSpeed;
  }

  public String getVesselType() {
    return vesselType;
  }

  public void setVesselType(String vesselType) {
    this.vesselType = vesselType;
  }

  public Vessel() {
  }

  public Vessel(String vesselId, String vesselName, double averageSpeed, String vesselType) {
    this.vesselId = vesselId;
    this.vesselName = vesselName;
    this.averageSpeed = averageSpeed;
    this.vesselType = vesselType;
  }
}

class VesselUtil {
  private List<Vessel> vesselList;

  public VesselUtil() {
    this.vesselList = new ArrayList<>();
  }

  public List<Vessel> getVesselList() {
    return vesselList;
  }

  public void setVesselList(List<Vessel> vesselList) {
    this.vesselList = vesselList;
  }

  public void addVesselPerformance(Vessel vessel) {
    vesselList.add(vessel);
  }

  public Vessel getVesselById(String vesselId) {
    for (Vessel vessel : vesselList) {
      if (vessel.getVesselId().equals(vesselId)) {
        return vessel;
      }
    }
    return null;
  }

  public List<Vessel> getHighPerformanceVessels() {
    List<Vessel> highPerformanceVessels = new ArrayList<>();
    double maxSpeed = 0.0;

    for (Vessel vessel : vesselList) {
      if (vessel.getAverageSpeed() > maxSpeed) {
        maxSpeed = vessel.getAverageSpeed();
        highPerformanceVessels.clear();
        highPerformanceVessels.add(vessel);
      } else if (vessel.getAverageSpeed() == maxSpeed) {
        highPerformanceVessels.add(vessel);
      }
    }

    return highPerformanceVessels;
  }

}

class UserInterface {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    VesselUtil vesselUtil = new VesselUtil();

    System.out.println("Enter the number of vessels to be added");
    int vesselCount = scanner.nextInt();
    scanner.nextLine();

    System.out.println("Enter vessel details");
    for (int i = 0; i < vesselCount; i++) {
      String input = scanner.nextLine().trim();
      while (input.isEmpty()) {
        input = scanner.nextLine().trim();
      }

      String[] parts = input.split(":");
      String vesselId = parts[0];
      String vesselName = parts[1];
      double averageSpeed = Double.parseDouble(parts[2]);
      String vesselType = parts[3];

      Vessel vessel = new Vessel(vesselId, vesselName, averageSpeed, vesselType);
      vesselUtil.addVesselPerformance(vessel);
    }

    System.out.println("Enter the Vessel Id to check speed");
    String searchId = scanner.nextLine().trim();

    Vessel found = vesselUtil.getVesselById(searchId);
    if (found != null) {
      System.out.println(found.getVesselId() + " | " + found.getVesselName() + " | "
          + found.getVesselType() + " | " + found.getAverageSpeed() + " knots");
    } else {
      System.out.println("Vessel Id " + searchId + " not found.");
    }

    System.out.println("High performance vessels are");
    List<Vessel> highPerformance = vesselUtil.getHighPerformanceVessels();
    for (Vessel vessel : highPerformance) {
      System.out.println(vessel.getVesselId() + " | " + vessel.getVesselName() + " | "
          + vessel.getVesselType() + " | " + vessel.getAverageSpeed() + " knots");
    }

    scanner.close();
  }
}

public class OceanFleet {
  public static void main(String[] args) {
    UserInterface.main(args);
  }
}
