public class MaxOfThreeNumber {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        int c = 15;

        int max = findMax(a, b, c);
        System.out.println("The maximum number is: " + max);
    }

    public static int findMax(int a, int b, int c) {
        int max = a;

        if (b > max) {
            max = b;
        }

        if (c > max) {
            max = c;
        }

        return max;
    }
  
}
