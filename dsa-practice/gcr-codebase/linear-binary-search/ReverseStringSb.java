public class ReverseStringSB {
  public static String reverse(String input) {
    StringBuilder sb = new StringBuilder();
    sb.append(input);
    sb.reverse();
    return sb.toString();
  }

  public static void main(String[] args) {
    System.out.println(reverse("hello")); // olleh
  }
}
