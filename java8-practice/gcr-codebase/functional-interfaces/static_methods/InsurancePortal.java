package static_methods;

interface SecurityUtils {
  static boolean isStrongPassword(String password) {
    if (password == null) {
      return false;
    }
    if (password.length() < 8) {
      return false;
    }
    final boolean[] flags = new boolean[4]; // 0: uppercase, 1: lowercase, 2: digit, 3: special char
    password.chars().forEach(ch -> {
      if (Character.isUpperCase(ch)) {
        flags[0] = true;
      } else if (Character.isLowerCase(ch)) {
        flags[1] = true;
      } else if (Character.isDigit(ch)) {
        flags[2] = true;
      } else if ("!@#$%^&*()-+".indexOf(ch) >= 0) {
        flags[3] = true;
      }
    });
    return flags[0] && flags[1] && flags[2] && flags[3];
  }
}

public class InsurancePortal {
  public static void main(String[] args) {
    String password = "Passw0rd!";
    if (SecurityUtils.isStrongPassword(password)) {
      System.out.println("The password is strong.");
    } else {
      System.out.println("The password is weak.");
    }
  }

}