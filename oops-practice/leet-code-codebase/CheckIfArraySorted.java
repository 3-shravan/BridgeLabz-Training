
public class CheckIfArraySorted {
  public static void main(String[] args) {
    CheckIfArraySorted solution = new CheckIfArraySorted();
    int[] nums = { 3, 4, 5, 1, 2 };
    boolean result = solution.check(nums);
    System.out.println("Is the array sorted and rotated? " + result);
  }

  public boolean check(int[] nums) {
    int count = 0;
    int n = nums.length;

    for (int i = 0; i < n; i++) {
      if (nums[i] > nums[(i + 1) % n]) {
        count++;
      }
    }

    return count <= 1;
  }

}
