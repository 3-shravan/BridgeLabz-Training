
public class Patient {

  static String hospitalName = "City Hospital";
  static int totalPatients = 0;

  private final String patientID;
  private String name;
  private int age;
  private String ailment;

  public Patient(String patientID, String name, int age, String ailment) {
    this.patientID = patientID;
    this.name = name;
    this.age = age;
    this.ailment = ailment;
    totalPatients++;
  }

  public static int getTotalPatients() {
    return totalPatients;
  }

  public void displayDetails(Object obj) {
    if (obj instanceof Patient) {
      Patient patient = (Patient) obj;
      System.out.println("Hospital Name: " + hospitalName);
      System.out.println("Patient ID: " + patient.patientID);
      System.out.println("Name: " + patient.name);
      System.out.println("Age: " + patient.age);
      System.out.println("Ailment: " + patient.ailment);
    } else {
      System.out.println("Invalid patient object.");
    }
  }

  public static void main(String[] args) {
    Patient patient1 = new Patient("P001", "Lathika", 30, "Flu");
    Patient patient2 = new Patient("P002", "Lidiya", 45, "Fracture");

    System.out.println("Total Patients Admitted: " + Patient.getTotalPatients());

    patient1.displayDetails(patient1);
    patient2.displayDetails(patient2);
  }

}
