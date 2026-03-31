import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {

  private final Map<String, Patient> patientsById = new HashMap<>();
  private final Map<String, Doctor> doctorsById = new HashMap<>();
  private final Map<String, Appointment> appointmentsById = new HashMap<>();
  private int appointmentCounter = 0;

  @Override
  public void addPatient(Patient patient) {
    if (patient == null) {
      throw new IllegalArgumentException("patient cannot be null");
    }
    patientsById.put(patient.getId(), patient);
  }

  @Override
  public void updatePatient(String patientId, String name, String phone, int age, String gender) {
    Patient patient = requirePatient(patientId);
    patient.setName(name);
    patient.setPhone(phone);
    patient.setAge(age);
    patient.setGender(gender);
  }

  @Override
  public void deletePatient(String patientId) {
    requirePatient(patientId);
    patientsById.remove(patientId);
  }

  @Override
  public Patient getPatient(String patientId) {
    return requirePatient(patientId);
  }

  @Override
  public List<Patient> getAllPatients() {
    return Collections.unmodifiableList(new ArrayList<>(patientsById.values()));
  }

  @Override
  public void addDoctor(Doctor doctor) {
    if (doctor == null) {
      throw new IllegalArgumentException("doctor cannot be null");
    }
    doctorsById.put(doctor.getId(), doctor);
  }

  @Override
  public void updateDoctor(String doctorId, String name, String phone, String specialization) {
    Doctor doctor = requireDoctor(doctorId);
    doctor.setName(name);
    doctor.setPhone(phone);
    doctor.setSpecialization(specialization);
  }

  @Override
  public void deleteDoctor(String doctorId) {
    requireDoctor(doctorId);
    doctorsById.remove(doctorId);
  }

  @Override
  public Doctor getDoctor(String doctorId) {
    return requireDoctor(doctorId);
  }

  @Override
  public List<Doctor> getAllDoctors() {
    return Collections.unmodifiableList(new ArrayList<>(doctorsById.values()));
  }

  @Override
  public Appointment bookAppointment(String patientId, String doctorId, String slot)
      throws AppointmentNotAvailableException {
    Patient patient = requirePatient(patientId);
    Doctor doctor = requireDoctor(doctorId);
    if (slot == null || slot.isBlank()) {
      throw new IllegalArgumentException("slot cannot be empty");
    }
    if (!doctor.isSlotAvailable(slot)) {
      throw new AppointmentNotAvailableException("Slot not available: " + slot);
    }

    doctor.reserveSlot(slot);
    String appointmentId = "A" + System.currentTimeMillis() + (++appointmentCounter);
    Appointment appointment = new Appointment(appointmentId, patient, doctor, slot);
    appointmentsById.put(appointmentId, appointment);

    patient.addMedicalRecord("Booked appointment " + appointmentId + " with "
        + doctor.getName() + " (" + doctor.getSpecialization() + ") at " + slot
        + " | Fee Rs." + appointment.getConsultationFee());

    return appointment;
  }

  @Override
  public void cancelAppointment(String appointmentId) {
    Appointment appointment = requireAppointment(appointmentId);
    if (appointment.getStatus() == Appointment.Status.CANCELLED) {
      return;
    }
    if (appointment.getStatus() == Appointment.Status.COMPLETED) {
      throw new IllegalStateException("Cannot cancel a completed appointment");
    }

    appointment.setStatus(Appointment.Status.CANCELLED);
    appointment.getDoctor().releaseSlot(appointment.getSlot());
    appointment.getPatient().addMedicalRecord(
        "Cancelled appointment " + appointment.getAppointmentId());
  }

  @Override
  public List<Appointment> getAllAppointments() {
    return Collections.unmodifiableList(new ArrayList<>(appointmentsById.values()));
  }

  @Override
  public List<MedicalRecordEntry> viewMedicalHistory(String patientId) {
    return requirePatient(patientId).getMedicalHistory();
  }

  private Patient requirePatient(String patientId) {
    if (patientId == null || patientId.isBlank()) {
      throw new IllegalArgumentException("patientId cannot be empty");
    }
    Patient patient = patientsById.get(patientId);
    if (patient == null) {
      throw new IllegalArgumentException("Patient not found: " + patientId);
    }
    return patient;
  }

  private Doctor requireDoctor(String doctorId) {
    if (doctorId == null || doctorId.isBlank()) {
      throw new IllegalArgumentException("doctorId cannot be empty");
    }
    Doctor doctor = doctorsById.get(doctorId);
    if (doctor == null) {
      throw new IllegalArgumentException("Doctor not found: " + doctorId);
    }
    return doctor;
  }

  private Appointment requireAppointment(String appointmentId) {
    if (appointmentId == null || appointmentId.isBlank()) {
      throw new IllegalArgumentException("appointmentId cannot be empty");
    }
    Appointment appointment = appointmentsById.get(appointmentId);
    if (appointment == null) {
      throw new IllegalArgumentException("Appointment not found: " + appointmentId);
    }
    return appointment;
  }

}
