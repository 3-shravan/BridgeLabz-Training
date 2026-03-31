package queue;

import java.util.PriorityQueue;

class Patient {

  String name;
  int severity;

  public Patient(String name, int severity) {
    this.name = name;
    this.severity = severity;
  }
}

public class HospitalTriage {

  public static void main(String[] args) {

    PriorityQueue<Patient> patientQueue = new PriorityQueue<>((p1, p2) -> p2.severity - p1.severity);
    patientQueue.add(new Patient("Alice", 5));
    patientQueue.add(new Patient("Bob", 8));
    patientQueue.add(new Patient("Charlie", 3));

    while (!patientQueue.isEmpty()) {

      System.out.println(patientQueue.poll().name);
    }
  }

}
