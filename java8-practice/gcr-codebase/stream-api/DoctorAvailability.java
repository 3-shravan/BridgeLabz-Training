import java.util.Arrays;
import java.util.Comparator;

class Doctor {

  private String name;
  private String specialization;
  private boolean isAvailableOnWeekend;

  public Doctor(String name, String specialization, boolean isAvailableOnWeekend) {
    this.name = name;
    this.specialization = specialization;
    this.isAvailableOnWeekend = isAvailableOnWeekend;
  }

  public String getName() {
    return name;
  }

  public String getSpecialization() {
    return specialization;
  }

  public boolean isAvailableOnWeekend() {
    return isAvailableOnWeekend;
  }

  @Override
  public String toString() {
    return name + " - " + specialization;
  }
}

public class DoctorAvailability {

  public static void main(String[] args) {
    Arrays.asList(
      new Doctor("Dr. Smith", "Cardiology", true),
      new Doctor("Dr. Johnson", "Neurology", false),
      new Doctor("Dr. Williams", "Pediatrics", true),
      new Doctor("Dr. Brown", "Orthopedics", false),
      new Doctor("Dr. Jones", "Dermatology", true)
    )
      .stream()
      .filter(dr -> dr.isAvailableOnWeekend())
      .sorted(Comparator.comparing(Doctor::getSpecialization))
      .toList()
      .forEach(System.out::println);
  }
}
