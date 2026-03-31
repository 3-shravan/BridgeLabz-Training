public class GeneralDoctor extends Doctor {

  public GeneralDoctor(String doctorId, String name, String phone) {
    super(doctorId, name, phone, "General");
  }

  @Override
  public double calculateConsultationFee() {
    return 300.0;
  }
}
