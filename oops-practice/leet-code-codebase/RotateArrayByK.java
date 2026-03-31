
public class RotateArrayByK {

  public static void main(String[] args) {
    RotateArrayByK solution = new RotateArrayByK();
    int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
    int k = 3;
    solution.rotate(nums, k);
    System.out.print("Array after left rotation: ");
    for (int num : nums) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public void rotate(int[] nums, int k) {
    k = k % nums.length;

    swap(nums, 0, nums.length - 1);
    swap(nums, 0, k - 1);
    swap(nums, k, nums.length - 1);

  }

  public void swap(int[] arr, int start, int end) {
    while (start <= end) {
      int temp = arr[start];
      arr[start] = arr[end];
      arr[end] = temp;

      start++;
      end--;
    }
  }

}
