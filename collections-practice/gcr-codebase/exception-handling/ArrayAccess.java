
public class ArrayAccess {
  public static void main(String[] args) {
    int[] numbers = { 10, 20, 30, 40, 50 };
    int indexToAccess = 5;

    try {

      int value = numbers[indexToAccess];
      System.out.println("Value at index " + indexToAccess + ": " + value);
    } catch (ArrayIndexOutOfBoundsException e) {
      System.out.println("Error: Index out of bounds");
    } catch (NullPointerException e) {
      System.out.println("Error: Null Pointer Exception");
    }
  }
}
