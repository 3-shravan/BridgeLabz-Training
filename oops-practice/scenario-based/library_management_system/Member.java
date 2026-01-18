package scenario_based.library_management_system;

public abstract class Member extends User {
  private String email;
  private final FineCalculator fineCalculator;

  protected Member(String id, String name, String phone, String email, FineCalculator fineCalculator) {
    super(id, name, phone);
    this.email = email;
    this.fineCalculator = fineCalculator;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public FineCalculator getFineCalculator() {
    return fineCalculator;
  }

  public abstract String getMemberType();

  public abstract int getLoanDays();

  @Override
  public String toString() {
    return "Member{" + getMemberType() + ", " + super.toString() + ", email='" + email + "'}";
  }
}
