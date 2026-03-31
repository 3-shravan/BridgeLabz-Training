import java.util.Scanner;

public class GenerateInvoice {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Logo Design - 3000 INR, Web Page - 4500 INR
    System.out
        .println("Enter the items purchased with their amounts (e.g., Logo Design - 3000 INR, Web Page - 4500 INR):");
    String input = sc.nextLine();
    String[] parsedInput = parseInput(input);

    int total = getTotalAmount(parsedInput);
    System.out.println("Total Amount: INR " + total);
    sc.close();
  }

  private static int getTotalAmount(String[] parsedInput) {
    int total = 0;
    for (String item : parsedInput) {
      String[] parts = item.split("-");
      String amount = parts[1].replace("INR", "").trim();
      total += Integer.parseInt(amount);
    }
    return total;
  }

  private static String[] parseInput(String input) {
    return input.split(",");
  }
}
