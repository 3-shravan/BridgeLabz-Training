public class FibonacciComparison {

    public static void main(String[] args) {
        int n = 30;

        long start = System.nanoTime();
        fibonacciRecursive(n);
        long end = System.nanoTime();
        System.out.println("Recursive Fibonacci: " + (end - start) / 1_000_000.0 + " ms");

        start = System.nanoTime();
        fibonacciIterative(n);
        end = System.nanoTime();
        System.out.println("Iterative Fibonacci: " + (end - start) / 1_000_000.0 + " ms");
    }

    static int fibonacciRecursive(int n) {
        if (n <= 1)
            return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    static int fibonacciIterative(int n) {
        if (n <= 1)
            return n;
        int a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            int sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }
}
