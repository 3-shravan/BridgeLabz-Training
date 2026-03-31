package marker_interfaces;

interface SensitiveData {

}

class UserCredentials implements SensitiveData {
  private String username;
  private String password;

  UserCredentials(String username, String password) {
    this.username = username;
    this.password = password;
  }

  @Override
  public String toString() {
    return "UserCredentials: " + username + "/" + password;
  }
}

public class SensitiveDataTagging {

  public static void main(String[] args) {

    UserCredentials creds = new UserCredentials("admin", "1234");
    System.out.println(creds);
    System.out.println("SensitiveData: " + (creds instanceof SensitiveData));
  }
}
