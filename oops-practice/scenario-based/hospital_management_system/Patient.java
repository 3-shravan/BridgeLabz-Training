import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Patient extends Person {

  private int age;
  private String gender;
  private final List<MedicalRecordEntry> medicalHistory;

  public Patient(String patientId, String name, String phone, int age, String gender) {
    super(patientId, name, phone);
    setAge(age);
    setGender(gender);
    this.medicalHistory = new ArrayList<>();
  }

  public void addMedicalRecord(String note) {
    if (note == null || note.isBlank()) {
      throw new IllegalArgumentException("note cannot be empty");
    }
    medicalHistory.add(new MedicalRecordEntry(note));
  }

  public List<MedicalRecordEntry> getMedicalHistory() {
    return Collections.unmodifiableList(medicalHistory);
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    if (age <= 0) {
      throw new IllegalArgumentException("age must be positive");
    }
    this.age = age;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    if (gender == null || gender.isBlank()) {
      throw new IllegalArgumentException("gender cannot be empty");
    }
    this.gender = gender;
  }

  @Override
  public String toString() {
    return getId() + " - " + getName() + " | " + age + " | " + gender + " | " + getPhone();
  }
}
