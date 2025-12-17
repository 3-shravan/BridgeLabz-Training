public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10; // Change this value to generate more or fewer terms
        System.out.println("Fibonacci Series up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fib(i) + " ");
        }
    }

    // Function to calculate Fibonacci number at position n
    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
