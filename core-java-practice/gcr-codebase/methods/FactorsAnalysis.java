import java.util.Scanner;

public class FactorsAnalysis {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter a number: ");
    int num = sc.nextInt();

    int[] factors = findFactors(num);

    System.out.println("Number: " + num);
    System.out.print("Factors: ");
    for (int f : factors) {
      System.out.print(f + " ");
    }
    System.out.println();

    int greatest = findGreatestFactor(factors);
    System.out.println("Greatest Factor: " + greatest);

    int sum = sumOfFactors(factors);
    System.out.println("Sum of Factors: " + sum);

    long product = productOfFactors(factors);
    System.out.println("Product of Factors: " + product);

    double cubeProduct = productOfCubes(factors);
    System.out.println("Product of Cubes: " + cubeProduct);

    sc.close();
  }

  static int[] findFactors(int num) {
    int count = 0;
    for (int i = 1; i <= num; i++) {
      if (num % i == 0) {
        count++;
      }
    }

    int[] factors = new int[count];
    int idx = 0;
    for (int i = 1; i <= num; i++) {
      if (num % i == 0) {
        factors[idx++] = i;
      }
    }

    return factors;
  }

  static int findGreatestFactor(int[] factors) {
    int max = factors[0];
    for (int f : factors) {
      if (f > max) {
        max = f;
      }
    }
    return max;
  }

  static int sumOfFactors(int[] factors) {
    int sum = 0;
    for (int f : factors) {
      sum += f;
    }
    return sum;
  }

  static long productOfFactors(int[] factors) {
    long product = 1;
    for (int f : factors) {
      product *= f;
    }
    return product;
  }

  static double productOfCubes(int[] factors) {
    double product = 1;
    for (int f : factors) {
      product *= Math.pow(f, 3);
    }
    return product;
  }
}
