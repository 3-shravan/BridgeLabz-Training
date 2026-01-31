import java.util.Scanner;

public class FlipKey {

  public static String cleanseAndInvert(String input) {

    String result = "";

    if (input == null || input.isEmpty() || input.trim().length() < 6) {
      return result;
    }

    for (char ch : input.toCharArray()) {
      if (!Character.isLetter(ch)) {
        return result;
      }
    }
    input = input.toLowerCase();
    String filteredInput = removeEvenASCIIAndReverse(input);
    result = upperCaseEvenIndex(filteredInput);

    return result;
  }

  private static String removeEvenASCIIAndReverse(String input) {
    StringBuilder sb = new StringBuilder();
    for (char ch : input.toCharArray()) {
      if ((int) ch % 2 == 0) {
        continue;
      } else
        sb.append(ch);
    }
    return sb.reverse().toString();
  }

  private static String upperCaseEvenIndex(String input) {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    for (char ch : input.toCharArray()) {
      if (i % 2 == 0 && !isUpperCaseChar(ch))
        sb.append(Character.toUpperCase(ch));
      else
        sb.append(ch);
      i++;
    }
    return sb.toString();
  }

  private static boolean isUpperCaseChar(char c) {
    return c >= 65 && c <= 90;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the word");
    String result = cleanseAndInvert(sc.nextLine());

    if (result.equals("")) {
      System.out.println("Invalid Input");
    } else {
      System.out.println("The generated key is - " + result);
    }

    sc.close();
  }

}
