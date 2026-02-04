package method_references;

import java.util.Arrays;
import java.util.List;

class Patient {
  private int id;

  Patient(int id) {
    this.id = id;
  }

  public int getId() {
    return id;
  }

  @Override
  public String toString() {
    return "Patient [id=" + id + "]";
  }

}

public class HospitalAdmin {

  public static void main(String[] args) {

    List<Patient> patients = Arrays.asList(
        new Patient(101),
        new Patient(102),
        new Patient(103));

    patients.forEach(System.out::println);
  }
}
