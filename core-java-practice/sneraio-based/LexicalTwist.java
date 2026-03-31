import java.util.*;

public class LexicalTwist {

  private static boolean isInvalidWord(String str) {
    return str.trim().contains(" ");
  }

  private static boolean isVowel(char ch) {
    return "AEIOU".indexOf(ch) != -1;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter the first word");
    String first = sc.nextLine();
    if (isInvalidWord(first)) {
      System.out.println(first + " is an invalid word");
      sc.close();
      return;
    }

    System.out.println("Enter the second word");
    String second = sc.nextLine();
    if (isInvalidWord(second)) {
      System.out.println(second + " is an invalid word");
      sc.close();
      return;
    }

    String reversedFirst = new StringBuilder(first).reverse().toString();

    if (reversedFirst.equalsIgnoreCase(second)) {

      String transformed = reversedFirst.toLowerCase();
      transformed = transformed.replaceAll("[aeiou]", "@");
      System.out.println(transformed);

    } else {

      String combined = (first + second).toUpperCase();

      int vowels = 0, consonants = 0;

      for (char ch : combined.toCharArray()) {
        if (Character.isLetter(ch)) {
          if (isVowel(ch))
            vowels++;
          else
            consonants++;
        }
      }

      LinkedHashSet<Character> resultSet = new LinkedHashSet<>();

      if (vowels > consonants) {
        for (char ch : combined.toCharArray()) {
          if (isVowel(ch)) {
            resultSet.add(ch);
            if (resultSet.size() == 2)
              break;
          }
        }
        printSet(resultSet);

      } else if (consonants > vowels) {
        for (char ch : combined.toCharArray()) {
          if (Character.isLetter(ch) && !isVowel(ch)) {
            resultSet.add(ch);
            if (resultSet.size() == 2)
              break;
          }
        }
        printSet(resultSet);

      } else {
        System.out.println("Vowels and consonants are equal");
      }
    }

    sc.close();
  }

  private static void printSet(LinkedHashSet<Character> set) {
    for (char ch : set) {
      System.out.print(ch);
    }
    System.out.println();
  }
}
