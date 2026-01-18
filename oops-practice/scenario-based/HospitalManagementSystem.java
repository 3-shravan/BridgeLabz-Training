import java.util.ArrayList;
import java.util.List;

interface IPayable {
  double CalculateBill();
}

abstract class Patient implements IPayable {
  private int id;
  private String name;

  public void setName(String name) {
    this.name = name;
  }

  private int age;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  private Doctor doctor;

  public Doctor getDoctor() {
    return doctor;
  }

  public void setDoctor(Doctor doctor) {
    this.doctor = doctor;
  }

  public Patient(int id, String name, int age, Doctor doctor) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.doctor = doctor;
  }

  public abstract void displayInfo();

}

class InPatient extends Patient {
  private int daysAdmitted;
  private double dailyCharge;

  public InPatient(int id, String name, int age, Doctor doctor, int daysAdmitted, double dailyCharge) {
    super(id, name, age, doctor);
    this.daysAdmitted = daysAdmitted;
    this.dailyCharge = dailyCharge;
  }

  @Override
  public double CalculateBill() {
    return daysAdmitted * dailyCharge;
  }

  @Override
  public void displayInfo() {
    System.out.println("InPatient ID: " + getId() + ", Name: " + getName() + ", Age: " + getAge() + ", Doctor: "
        + getDoctor().getName() + ", Days Admitted: " + daysAdmitted + ", Daily Charge: " + dailyCharge);
  }
}

class OutPatient extends Patient {
  private double consultationFee;

  public OutPatient(int id, String name, int age, Doctor doctor, double consultationFee) {
    super(id, name, age, doctor);
    this.consultationFee = consultationFee;
  }

  @Override
  public double CalculateBill() {
    return consultationFee;
  }

  @Override
  public void displayInfo() {
    System.out.println("OutPatient ID: " + getId() + ", Name: " + getName() + ", Age: " + getAge() + ", Doctor: "
        + getDoctor().getName() + ", Consultation Fee: " + consultationFee);
  }
}

class Doctor {
  private int doctorId;
  private String name;
  private String specialization;

  public Doctor(int doctorId, String name, String specialization) {
    this.doctorId = doctorId;
    this.name = name;
    this.specialization = specialization;
  }

  public String getName() {
    return name;
  }

}

class Bill {
  private int billId;
  private double amount;
  private String date;

  public Bill(int billId, double amount, String date) {
    this.billId = billId;
    this.amount = amount;
    this.date = date;
  }

  public void displayBill() {
    System.out.println("Bill ID: " + billId + ", Amount: " + amount + ", Date: " + date);
  }

}

class HospitalManagement {
  private final List<Patient> patients = new ArrayList<>();

  // CREATE
  public void addPatient(Patient patient) {
    patients.add(patient);
    System.out.println("Patient added successfully.");
  }

  // READ
  public void viewPatients() {
    for (Patient p : patients) {
      p.displayInfo(); // Polymorphic call
    }
  }

  // UPDATE
  public void updatePatientName(int id, String newName) {
    for (Patient p : patients) {
      if (p.getId() == id) {
        p.setName(newName);
        System.out.println("Patient updated.");
        return;
      }
    }
    System.out.println("Patient not found.");
  }

  // DELETE
  public void deletePatient(int id) {
    boolean removed = patients.removeIf(p -> p.getId() == id);
    System.out.println(removed ? "Patient deleted." : "Patient not found.");
  }
}

public class HospitalManagementSystem {
  public static void main(String[] args) {
    HospitalManagement hm = new HospitalManagement();
    Doctor doc1 = new Doctor(1, "Dr. Smith", "Cardiology");

    Patient p1 = new InPatient(101, "John Doe", 45, doc1, 5, 200.0);
    Patient p2 = new OutPatient(102, "Jane Roe", 30, doc1, 150.0);

    hm.addPatient(p1);
    hm.addPatient(p2);
    hm.viewPatients();
    hm.updatePatientName(101, "John D.");
    hm.viewPatients();
    hm.deletePatient(102);
    hm.viewPatients();

  }

}{

}
