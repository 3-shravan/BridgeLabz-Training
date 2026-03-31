// Problem 3: Prime Number Checker
// Create a program that checks whether a given number is a prime number.
// The program should use a separate function to perform the prime check and
// return the result.

import java.util.Scanner;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to check if it is prime: ");
        int number = scanner.nextInt();
        boolean isPrime = isPrime(number);
        displayResult(number, isPrime);

        scanner.close();
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void displayResult(int number, boolean prime) {
        if (prime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }
    }
}
