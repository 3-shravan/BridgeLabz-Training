
public class MoveZeroes {
  public void moveZeroes(int[] nums) {
    int k = 0;
    for (int num : nums) {
      if (num != 0)
        nums[k++] = num;
    }
    while (k < nums.length) {
      nums[k++] = 0;
    }

  }

  public static void main(String[] args) {
    MoveZeroes mz = new MoveZeroes();
    int[] nums = { 0, 1, 0, 3, 12 };
    mz.moveZeroes(nums);
    for (int num : nums) {
      System.out.print(num + " ");
    }
  }

}
