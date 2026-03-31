public class SpecialistDoctor extends Doctor {

  public SpecialistDoctor(String doctorId, String name, String phone, String specialization) {
    super(doctorId, name, phone, specialization);
  }

  @Override
  public double calculateConsultationFee() {
    return 600.0;
  }
}
