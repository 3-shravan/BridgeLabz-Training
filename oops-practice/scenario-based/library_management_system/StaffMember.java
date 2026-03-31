package scenario_based.library_management_system;

public class StaffMember extends Member {
  private static final int LOAN_DAYS = 21;

  public StaffMember(String id, String name, String phone, String email) {
    super(id, name, phone, email, new StaffFineCalculator());
  }

  @Override
  public String getMemberType() {
    return "Staff";
  }

  @Override
  public int getLoanDays() {
    return LOAN_DAYS;
  }
}
