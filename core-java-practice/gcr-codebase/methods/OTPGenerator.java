public class OTPGenerator {

  public static void main(String[] args) {
    int[] otps = new int[10];

    System.out.println("Generating 10 OTP numbers:\n");
    for (int i = 0; i < 10; i++) {
      otps[i] = generateOTP();
      System.out.println("OTP " + (i + 1) + ": " + otps[i]);
    }

    boolean unique = areOTPsUnique(otps);
    System.out.println("\nAll OTPs Unique: " + unique);
  }

  static int generateOTP() {
    int otp = 100000 + (int) (Math.random() * 900000);
    return otp;
  }

  static boolean areOTPsUnique(int[] otps) {
    for (int i = 0; i < otps.length; i++) {
      for (int j = i + 1; j < otps.length; j++) {
        if (otps[i] == otps[j]) {
          return false;
        }
      }
    }
    return true;
  }
}
