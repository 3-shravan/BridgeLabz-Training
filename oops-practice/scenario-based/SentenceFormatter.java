
import java.util.Scanner;

public class SentenceFormatter {
  public static String formatParagraph(String paragraph) {
    // Trim leading and trailing spaces
    paragraph = paragraph.trim();

    // Replace multiple spaces with a single space
    paragraph = paragraph.replaceAll("\\s+", " ");

    // Ensure one space after punctuation marks
    paragraph = paragraph.replaceAll("([.!?])\\s*", "$1 ");

    // Capitalize the first letter of each sentence
    StringBuilder formattedParagraph = new StringBuilder();
    boolean capitalizeNext = true;

    for (char c : paragraph.toCharArray()) {
      if (capitalizeNext && Character.isLetter(c)) {
        formattedParagraph.append(Character.toUpperCase(c));
        capitalizeNext = false;
      } else {
        formattedParagraph.append(c);
      }
      if (c == '.' || c == '!' || c == '?') {
        capitalizeNext = true;
      }
    }

    return formattedParagraph.toString().trim();
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    System.out.println("Choose your snerio:\n1. Format a paragraph. \n2. Also Analyze the paragraph.");
    int choice = sc.nextInt();
    sc.nextLine(); // Consume newline

    System.out.println("Enter the paragraph (type 'END' on a new line to finish):");
    String paragraph = takeParagraphInput(sc);
    String formatted = formatParagraph(paragraph);

    System.out.println(formatted);
    if (choice == 2) {
      System.out.println("Enter the target word and replacement word:");
      String target = sc.next();
      String replacement = sc.next();
      analyzeParagraph(formatted, target, replacement);
    }
    sc.close();

  }

  static String takeParagraphInput(Scanner sc) {
    StringBuilder paragraph = new StringBuilder();
    while (true) {
      String line = sc.nextLine();
      if (line.equals("END"))
        break;
      paragraph.append(line).append("\n");
    }
    return paragraph.toString().trim();
  }

  static void analyzeParagraph(String paragraph, String target, String replacement) {
    if (paragraph.trim().isEmpty()) {
      System.out.println("The paragraph is empty or contains only spaces.");
      return;
    }

    String[] words = paragraph.split("\\s+");
    int wordCount = words.length;

    String longestWord = "";
    for (String word : words) {
      if (word.length() > longestWord.length()) {
        longestWord = word;
      }
    }
    paragraph = replaceWord(paragraph, target, replacement);

    System.out.println("Word Count: " + wordCount);
    System.out.println("Longest Word: " + longestWord);
    System.out.println("Modified Paragraph: " + paragraph);
  }

  // Method to replace target word with replacement word as case sensitive
  static String replaceWord(String paragraph, String target, String replacement) {
    return paragraph.replaceAll("(?i)" + target, replacement);
  }

}
