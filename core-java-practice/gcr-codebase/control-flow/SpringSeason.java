// Write a program SpringSeason that takes two int values month and day from the command line and prints “Its a Spring Season” otherwise prints “Not a Spring Season”. 
// Hint => 
// Spring Season is from March 20 to June 20

public class SpringSeason {
  public static void main(String[] args) {
    if (args.length < 2) {
      System.out.println("Please provide month and day as arguments");
      return;
    }

    int month = Integer.parseInt(args[0]);
    int day = Integer.parseInt(args[1]);

    if ((month == 3 && day >= 20 && day <= 31) || (month == 4 && day >= 1 && day <= 30) ||
        (month == 5 && day >= 1 && day <= 31) || (month == 6 && day >= 1 && day <= 20)) {
      System.out.println("It's a Spring Season");
    } else {
      System.out.println("Not a Spring Season");
    }

  }
}
