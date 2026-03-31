
import java.util.Scanner;

public class NumberChecker {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter a number: ");
    long num = scanner.nextLong();

    System.out.println("\n--- Basic Analysis ---");
    System.out.println("Prime: " + isPrime(num));
    System.out.println("Neon: " + isNeonNumber(num));
    System.out.println("Spy: " + isSpyNumber(num));
    System.out.println("Automorphic: " + isAutomorphic(num));
    System.out.println("Buzz: " + isBuzzNumber(num));

    System.out.println("\n--- Divisor Analysis ---");
    long sumDiv = sumOfDivisors(num);
    System.out.println("Sum of Divisors: " + sumDiv);
    System.out.println("Perfect: " + isPerfectNumber(num, sumDiv));
    System.out.println("Abundant: " + isAbundantNumber(num, sumDiv));
    System.out.println("Deficient: " + isDeficientNumber(num, sumDiv));

    System.out.println("\n--- Factorial Sum ---");
    System.out.println("Strong: " + isStrongNumber(num));

    scanner.close();
  }

  static boolean isPrime(long num) {
    if (num <= 1)
      return false;
    if (num == 2)
      return true;
    if (num % 2 == 0)
      return false;
    for (long i = 3; i * i <= num; i += 2) {
      if (num % i == 0)
        return false;
    }
    return true;
  }

  static boolean isNeonNumber(long num) {
    long sq = num * num;
    long digitSum = 0;
    while (sq > 0) {
      digitSum += sq % 10;
      sq /= 10;
    }
    return digitSum == num;
  }

  static boolean isSpyNumber(long num) {
    int sum = 0;
    long prod = 1;
    long temp = num;
    while (temp > 0) {
      int digit = (int) (temp % 10);
      sum += digit;
      prod *= digit;
      temp /= 10;
    }
    return sum == prod;
  }

  static boolean isAutomorphic(long num) {
    long sq = num * num;
    long lastDig = num;
    while (lastDig > 0 && sq > 0) {
      if (sq % 10 != lastDig % 10)
        return false;
      lastDig /= 10;
      sq /= 10;
    }
    return lastDig == 0;
  }

  static boolean isBuzzNumber(long num) {
    return num % 7 == 0 || num % 10 == 7;
  }

  static long sumOfDivisors(long num) {
    long sum = 0;
    for (long i = 1; i < num; i++) {
      if (num % i == 0) {
        sum += i;
      }
    }
    return sum;
  }

  static boolean isPerfectNumber(long num, long sumDiv) {
    return sumDiv == num;
  }

  static boolean isAbundantNumber(long num, long sumDiv) {
    return sumDiv > num;
  }

  static boolean isDeficientNumber(long num, long sumDiv) {
    return sumDiv < num;
  }

  static boolean isStrongNumber(long num) {
    long sum = 0;
    long temp = num;
    while (temp > 0) {
      int digit = (int) (temp % 10);
      sum += factorial(digit);
      temp /= 10;
    }
    return sum == num;
  }

  static long factorial(int n) {
    long res = 1;
    for (int i = 2; i <= n; i++) {
      res *= i;
    }
    return res;
  }

  static int countDigits(long num) {
    return String.valueOf(num).length();
  }

  static int[] storeDigits(long num, int count) {
    int[] arr = new int[count];
    String s = String.valueOf(num);
    for (int i = 0; i < count; i++) {
      arr[i] = Character.getNumericValue(s.charAt(i));
    }
    return arr;
  }

  static int[] reverseArray(int[] arr) {
    int[] rev = new int[arr.length];
    for (int i = 0; i < arr.length; i++) {
      rev[i] = arr[arr.length - 1 - i];
    }
    return rev;
  }

  static boolean arraysEqual(int[] arr1, int[] arr2) {
    if (arr1.length != arr2.length)
      return false;
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i])
        return false;
    }
    return true;
  }

  static boolean isPalindrome(int[] original, int[] reversed) {
    return arraysEqual(original, reversed);
  }

  static boolean isDuckNumber(int[] digits) {
    for (int d : digits) {
      if (d == 0)
        return true;
    }
    return false;
  }

  static int sumOfDigits(int[] digits) {
    int sum = 0;
    for (int d : digits) {
      sum += d;
    }
    return sum;
  }

  static double sumOfSquares(int[] digits) {
    double sum = 0;
    for (int d : digits) {
      sum += Math.pow(d, 2);
    }
    return sum;
  }

  static boolean isHarshadNumber(long num, int digitSum) {
    return num % digitSum == 0;
  }

  static int[][] digitFrequency(int[] digits) {
    int[][] freq = new int[10][2];
    for (int i = 0; i < 10; i++) {
      freq[i][0] = i;
    }
    for (int d : digits) {
      freq[d][1]++;
    }
    return freq;
  }

  static boolean isArmstrongNumber(int[] digits) {
    long sum = 0;
    int power = digits.length;
    for (int d : digits) {
      sum += Math.pow(d, power);
    }
    long originalNum = 0;
    for (int d : digits) {
      originalNum = originalNum * 10 + d;
    }
    return sum == originalNum;
  }

  static int[] findLargestSecondLargest(int[] digits) {
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    for (int d : digits) {
      if (d > largest) {
        secondLargest = largest;
        largest = d;
      } else if (d > secondLargest && d != largest) {
        secondLargest = d;
      }
    }
    return new int[] { largest, secondLargest };
  }

  static int[] findSmallestSecondSmallest(int[] digits) {
    int smallest = Integer.MAX_VALUE;
    int secondSmallest = Integer.MAX_VALUE;
    for (int d : digits) {
      if (d < smallest) {
        secondSmallest = smallest;
        smallest = d;
      } else if (d < secondSmallest && d != smallest) {
        secondSmallest = d;
      }
    }
    return new int[] { smallest, secondSmallest };
  }
}
