import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {

  public enum Status {
    BOOKED, CANCELLED, COMPLETED
  }

  private final String appointmentId;
  private final Patient patient;
  private final Doctor doctor;
  private final String slot;
  private final double consultationFee;
  private final LocalDateTime createdAt;
  private Status status;

  public Appointment(String appointmentId, Patient patient, Doctor doctor, String slot) {
    if (appointmentId == null || appointmentId.isBlank()) {
      throw new IllegalArgumentException("appointmentId cannot be empty");
    }
    if (patient == null || doctor == null) {
      throw new IllegalArgumentException("patient/doctor cannot be null");
    }
    if (slot == null || slot.isBlank()) {
      throw new IllegalArgumentException("slot cannot be empty");
    }
    this.appointmentId = appointmentId;
    this.patient = patient;
    this.doctor = doctor;
    this.slot = slot;
    this.consultationFee = doctor.calculateConsultationFee();
    this.createdAt = LocalDateTime.now();
    this.status = Status.BOOKED;
  }

  public String getAppointmentId() {
    return appointmentId;
  }

  public Patient getPatient() {
    return patient;
  }

  public Doctor getDoctor() {
    return doctor;
  }

  public String getSlot() {
    return slot;
  }

  public double getConsultationFee() {
    return consultationFee;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  @Override
  public String toString() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    return appointmentId + " | " + patient.getName() + " with " + doctor.getName()
        + " (" + doctor.getSpecialization() + ") | Slot: " + slot
        + " | Fee: Rs." + consultationFee + " | " + status
        + " | Created: " + createdAt.format(formatter);
  }
}
