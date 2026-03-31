import java.util.Arrays;

public class BinaryTarget {
  static int search(int[] arr, int target) {
    Arrays.sort(arr);
    int l = 0, r = arr.length - 1;
    while (l <= r) {
      int m = (l + r) / 2;
      if (arr[m] == target)
        return m;
      else if (arr[m] < target)
        l = m + 1;
      else
        r = m - 1;
    }
    return -1;
  }
}
