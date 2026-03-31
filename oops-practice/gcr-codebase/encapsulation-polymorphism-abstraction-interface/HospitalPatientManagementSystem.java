import java.util.ArrayList;
import java.util.List;

/*
 * Interface defining medical record behavior
 */
interface MedicalRecord {
  void addRecord(String record);

  void viewRecords();
}

/*
 * Abstract Patient class
 * Represents common patient data and behavior
 */
abstract class Patient {

  // Encapsulation: private fields
  private final int patientId; 
  private String name;
  private int age;

  // Sensitive medical data (secured)
  private List<String> medicalHistory = new ArrayList<>();

  public Patient(int patientId, String name, int age) {
    this.patientId = patientId;
    setName(name);
    setAge(age);
  }

  // Abstract billing method
  public abstract double calculateBill();

  // Concrete method
  public void getPatientDetails(double billAmount) {
    System.out.println("Patient ID   : " + patientId);
    System.out.println("Name         : " + name);
    System.out.println("Age          : " + age);
    System.out.println("Bill Amount  : ₹" + billAmount);
    System.out.println("--------------------------------");
  }

  // Encapsulation 
  public final void setName(String name) {
    if (name == null || name.trim().isEmpty()) {
      throw new IllegalArgumentException("Patient name cannot be empty");
    }
    this.name = name;
  }

  public final void setAge(int age) {
    if (age <= 0) {
      throw new IllegalArgumentException("Age must be positive");
    }
    this.age = age;
  }

  // Protected access to sensitive data
  protected void addMedicalHistory(String record) {
    medicalHistory.add(record);
  }

  protected void showMedicalHistory() {
    if (medicalHistory.isEmpty()) {
      System.out.println("Medical History: None");
      return;
    }
    System.out.println("Medical History:");
    for (String record : medicalHistory) {
      System.out.println("- " + record);
    }
  }
}

/*
 * In-patient implementation
 */
class InPatient extends Patient implements MedicalRecord {

  private int daysAdmitted;
  private double dailyCharge;

  public InPatient(int id, String name, int age, int daysAdmitted, double dailyCharge) {
    super(id, name, age);
    this.daysAdmitted = daysAdmitted;
    this.dailyCharge = dailyCharge;
  }

  @Override
  public double calculateBill() {
    return daysAdmitted * dailyCharge;
  }

  @Override
  public void addRecord(String record) {
    addMedicalHistory(record);
  }

  @Override
  public void viewRecords() {
    showMedicalHistory();
  }
}

/*
 * Out-patient implementation
 */
class OutPatient extends Patient implements MedicalRecord {

  private double consultationFee;

  public OutPatient(int id, String name, int age, double consultationFee) {
    super(id, name, age);
    this.consultationFee = consultationFee;
  }

  @Override
  public double calculateBill() {
    return consultationFee;
  }

  @Override
  public void addRecord(String record) {
    addMedicalHistory(record);
  }

  @Override
  public void viewRecords() {
    showMedicalHistory();
  }
}

/*
 * Main class
 * Demonstrates polymorphism
 */
public class HospitalPatientManagementSystem {

  public static void main(String[] args) {

    List<Patient> patients = new ArrayList<>();

    Patient p1 = new InPatient(101, "Shravan", 25, 5, 3000);
    Patient p2 = new OutPatient(102, "Amit", 30, 800);

    patients.add(p1);
    patients.add(p2);

    // Add medical records polymorphically
    ((MedicalRecord) p1).addRecord("Appendectomy");
    ((MedicalRecord) p1).addRecord("Post-surgery medication");

    ((MedicalRecord) p2).addRecord("General fever consultation");

    // Polymorphic processing
    for (Patient patient : patients) {
      double bill = patient.calculateBill();
      patient.getPatientDetails(bill);

      ((MedicalRecord) patient).viewRecords();
      System.out.println();
    }
  }
}
