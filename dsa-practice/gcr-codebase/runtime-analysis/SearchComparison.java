
public class SearchComparison {

  public static void main(String[] args) {
    int n = 1_000_000;
    int[] arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = i;
    }

    int target = n - 1;

    long start = System.nanoTime();
    linearSearch(arr, target);
    long end = System.nanoTime();
    System.out.println("Linear Search Time: " + (end - start) / 1_000_000.0 + " ms");

    start = System.nanoTime();
    binarySearch(arr, target);
    end = System.nanoTime();
    System.out.println("Binary Search Time: " + (end - start) / 1_000_000.0 + " ms");
  }

  static int linearSearch(int[] arr, int target) {
    for (int i : arr) {
      if (i == target)
        return i;
    }
    return -1;
  }

  static int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == target)
        return mid;
      if (arr[mid] < target)
        low = mid + 1;
      else
        high = mid - 1;
    }
    return -1;
  }
}
