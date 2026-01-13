public interface HospitalService {

  // Patient CRUD
  void addPatient(Patient patient);

  void updatePatient(String patientId, String name, String phone, int age, String gender);

  void deletePatient(String patientId);

  Patient getPatient(String patientId);

  java.util.List<Patient> getAllPatients();

  // Doctor CRUD
  void addDoctor(Doctor doctor);

  void updateDoctor(String doctorId, String name, String phone, String specialization);

  void deleteDoctor(String doctorId);

  Doctor getDoctor(String doctorId);

  java.util.List<Doctor> getAllDoctors();

  // Appointment booking & cancellation
  Appointment bookAppointment(String patientId, String doctorId, String slot)
      throws AppointmentNotAvailableException;

  void cancelAppointment(String appointmentId);

  java.util.List<Appointment> getAllAppointments();

  // View medical history
  java.util.List<MedicalRecordEntry> viewMedicalHistory(String patientId);
}
