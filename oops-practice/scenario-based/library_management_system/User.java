package scenario_based.library_management_system;

public class User {
  private final String id;
  private String name;
  private String phone;

  public User(String id, String name, String phone) {
    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("User id cannot be empty");
    }
    this.id = id.trim();
    this.name = name;
    this.phone = phone;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "id='" + id + "', name='" + name + "', phone='" + phone + "'";
  }
}
