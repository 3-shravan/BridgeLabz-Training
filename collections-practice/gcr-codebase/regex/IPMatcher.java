public class IPMatcher {
  private static boolean isValidIP(String ip) {
    String ipPattern = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)(\\.(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)){3}$";

    return ip.matches(ipPattern);
  }

  public static void main(String[] args) {
    String[] testIPs = { "192.168.1.1", "255.255.255.255", "0.0.0.0", "256.1.1.1", "192.168.1", "192.168.01.1" };

    for (String ip : testIPs) {
      System.out.println(ip + " is valid: " + isValidIP(ip));
    }
  }
}
