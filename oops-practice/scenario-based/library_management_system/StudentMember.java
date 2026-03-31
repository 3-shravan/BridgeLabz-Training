package scenario_based.library_management_system;

public class StudentMember extends Member {
  private static final int LOAN_DAYS = 14;

  public StudentMember(String id, String name, String phone, String email) {
    super(id, name, phone, email, new StudentFineCalculator());
  }

  @Override
  public String getMemberType() {
    return "Student";
  }

  @Override
  public int getLoanDays() {
    return LOAN_DAYS;
  }
}
