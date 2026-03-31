public abstract class Person {

  private String id;
  private String name;
  private String phone;

  public Person(String id, String name, String phone) {
    if (id == null || id.isBlank()) {
      throw new IllegalArgumentException("id cannot be empty");
    }
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("name cannot be empty");
    }
    if (phone == null || phone.isBlank()) {
      throw new IllegalArgumentException("phone cannot be empty");
    }
    this.id = id;
    this.name = name;
    this.phone = phone;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  @Override
  public String toString() {
    return id + " - " + name + " (" + phone + ")";
  }
}
