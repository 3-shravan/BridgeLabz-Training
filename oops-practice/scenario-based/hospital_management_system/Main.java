import java.util.List;
import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    HospitalService service = new HospitalServiceImpl();

    // Optional starter data
    Doctor d1 = new GeneralDoctor("D101", "Dr. Sharma", "9000000001");
    d1.addAvailableSlot("2026-01-13 10:00");
    d1.addAvailableSlot("2026-01-13 11:00");
    service.addDoctor(d1);

    Doctor d2 = new SpecialistDoctor("D102", "Dr. Mehta", "9000000002", "Cardiology");
    d2.addAvailableSlot("2026-01-13 12:00");
    service.addDoctor(d2);

    java.util.Scanner scanner = new java.util.Scanner(System.in);

    boolean running = true;
    while (running) {
      printMenu();
      int choice = readInt(scanner, "Enter choice: ");

      try {
        switch (choice) {
          case 1:
            handleAddPatient(scanner, service);
            break;
          case 2:
            handleUpdatePatient(scanner, service);
            break;
          case 3:
            handleDeletePatient(scanner, service);
            break;
          case 4:
            handleListPatients(service);
            break;
          case 5:
            handleAddDoctor(scanner, service);
            break;
          case 6:
            handleUpdateDoctor(scanner, service);
            break;
          case 7:
            handleDeleteDoctor(scanner, service);
            break;
          case 8:
            handleListDoctors(service);
            break;
          case 9:
            handleBookAppointment(scanner, service);
            break;
          case 10:
            handleCancelAppointment(scanner, service);
            break;
          case 11:
            handleListAppointments(service);
            break;
          case 12:
            handleViewMedicalHistory(scanner, service);
            break;
          case 0:
            running = false;
            System.out.println("Exiting...");
            break;
          default:
            System.out.println("Invalid choice. Try again.");
        }
      } catch (AppointmentNotAvailableException e) {
        System.out.println("Booking failed: " + e.getMessage());
      } catch (IllegalArgumentException | IllegalStateException e) {
        System.out.println("Error: " + e.getMessage());
      } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
      }

      System.out.println();
    }

    scanner.close();
  }

  private static void printMenu() {
    System.out.println("==== Hospital Management System ====");
    System.out.println("1. Add Patient");
    System.out.println("2. Update Patient");
    System.out.println("3. Delete Patient");
    System.out.println("4. List Patients");
    System.out.println("5. Add Doctor");
    System.out.println("6. Update Doctor");
    System.out.println("7. Delete Doctor");
    System.out.println("8. List Doctors");
    System.out.println("9. Book Appointment");
    System.out.println("10. Cancel Appointment");
    System.out.println("11. List Appointments");
    System.out.println("12. View Medical History");
    System.out.println("0. Exit");
  }

  private static void handleAddPatient(Scanner scanner, HospitalService service) {
    String id = readNonEmpty(scanner, "Patient ID: ");
    String name = readNonEmpty(scanner, "Name: ");
    String phone = readNonEmpty(scanner, "Phone: ");
    int age = readInt(scanner, "Age: ");
    String gender = readNonEmpty(scanner, "Gender: ");
    service.addPatient(new Patient(id, name, phone, age, gender));
    System.out.println("Patient added.");
  }

  private static void handleUpdatePatient(Scanner scanner, HospitalService service) {
    String id = readNonEmpty(scanner, "Patient ID: ");
    String name = readNonEmpty(scanner, "New Name: ");
    String phone = readNonEmpty(scanner, "New Phone: ");
    int age = readInt(scanner, "New Age: ");
    String gender = readNonEmpty(scanner, "New Gender: ");
    service.updatePatient(id, name, phone, age, gender);
    System.out.println("Patient updated.");
  }

  private static void handleDeletePatient(Scanner scanner, HospitalService service) {
    String id = readNonEmpty(scanner, "Patient ID: ");
    service.deletePatient(id);
    System.out.println("Patient deleted.");
  }

  private static void handleListPatients(HospitalService service) {
    List<Patient> patients = service.getAllPatients();
    if (patients.isEmpty()) {
      System.out.println("No patients found.");
      return;
    }
    System.out.println("Patients:");
    for (Patient p : patients) {
      System.out.println("- " + p);
    }
  }

  private static void handleAddDoctor(java.util.Scanner scanner, HospitalService service) {
    String type = readNonEmpty(scanner, "Doctor type (general/specialist): ");
    String id = readNonEmpty(scanner, "Doctor ID: ");
    String name = readNonEmpty(scanner, "Name: ");
    String phone = readNonEmpty(scanner, "Phone: ");

    Doctor doctor;
    if (type.equalsIgnoreCase("general")) {
      doctor = new GeneralDoctor(id, name, phone);
    } else {
      String specialization = readNonEmpty(scanner, "Specialization: ");
      doctor = new SpecialistDoctor(id, name, phone, specialization);
    }

    int slotCount = readInt(scanner, "How many slots to add now?: ");
    for (int i = 0; i < slotCount; i++) {
      String slot = readNonEmpty(scanner, "Slot (e.g., 2026-01-13 10:00): ");
      doctor.addAvailableSlot(slot);
    }

    service.addDoctor(doctor);
    System.out.println("Doctor added.");
  }

  private static void handleUpdateDoctor(Scanner scanner, HospitalService service) {
    String id = readNonEmpty(scanner, "Doctor ID: ");
    String name = readNonEmpty(scanner, "New Name: ");
    String phone = readNonEmpty(scanner, "New Phone: ");
    String specialization = readNonEmpty(scanner, "New Specialization: ");
    service.updateDoctor(id, name, phone, specialization);
    System.out.println("Doctor updated.");
  }

  private static void handleDeleteDoctor(Scanner scanner, HospitalService service) {
    String id = readNonEmpty(scanner, "Doctor ID: ");
    service.deleteDoctor(id);
    System.out.println("Doctor deleted.");
  }

  private static void handleListDoctors(HospitalService service) {
    java.util.List<Doctor> doctors = service.getAllDoctors();
    if (doctors.isEmpty()) {
      System.out.println("No doctors found.");
      return;
    }
    System.out.println("Doctors:");
    for (Doctor d : doctors) {
      System.out.println("- " + d);
      if (!d.getAvailableSlots().isEmpty()) {
        System.out.println("  Slots: " + d.getAvailableSlots());
      }
    }
  }

  private static void handleBookAppointment(java.util.Scanner scanner, HospitalService service)
      throws AppointmentNotAvailableException {
    String patientId = readNonEmpty(scanner, "Patient ID: ");
    String doctorId = readNonEmpty(scanner, "Doctor ID: ");
    String slot = readNonEmpty(scanner, "Slot (e.g., 2026-01-13 10:00): ");
    Appointment appointment = service.bookAppointment(patientId, doctorId, slot);
    System.out.println("Appointment booked: " + appointment);
  }

  private static void handleCancelAppointment(java.util.Scanner scanner, HospitalService service) {
    String appointmentId = readNonEmpty(scanner, "Appointment ID: ");
    service.cancelAppointment(appointmentId);
    System.out.println("Appointment cancelled.");
  }

  private static void handleListAppointments(HospitalService service) {
    java.util.List<Appointment> appointments = service.getAllAppointments();
    if (appointments.isEmpty()) {
      System.out.println("No appointments.");
      return;
    }
    System.out.println("Appointments:");
    for (Appointment a : appointments) {
      System.out.println("- " + a);
    }
  }

  private static void handleViewMedicalHistory(java.util.Scanner scanner, HospitalService service) {
    String patientId = readNonEmpty(scanner, "Patient ID: ");
    java.util.List<MedicalRecordEntry> history = service.viewMedicalHistory(patientId);
    if (history.isEmpty()) {
      System.out.println("No medical history.");
      return;
    }
    System.out.println("Medical History:");
    for (MedicalRecordEntry entry : history) {
      System.out.println("- " + entry);
    }
  }

  private static String readNonEmpty(java.util.Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      if (value != null) {
        value = value.trim();
      }
      if (value != null && !value.isBlank()) {
        return value;
      }
      System.out.println("Input cannot be empty. Try again.");
    }
  }

  private static int readInt(java.util.Scanner scanner, String prompt) {
    while (true) {
      System.out.print(prompt);
      String value = scanner.nextLine();
      try {
        return Integer.parseInt(value.trim());
      } catch (NumberFormatException e) {
        System.out.println("Please enter a valid number.");
      }
    }
  }
}
