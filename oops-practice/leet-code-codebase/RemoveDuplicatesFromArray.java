
public class RemoveDuplicatesFromArray {

  public int removeDuplicates(int[] nums) {
    int k = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != nums[k])
        nums[++k] = nums[i];
    }
    return k + 1;

  }

  public static void main(String[] args) {
    RemoveDuplicatesFromArray solution = new RemoveDuplicatesFromArray();
    int[] nums = { 1, 1, 2, 2, 3, 4, 4 };
    int k = solution.removeDuplicates(nums);
    System.out.println("Length of array after removing duplicates: " + k);
    System.out.print("Array after removing duplicates: ");
    for (int i = 0; i < k; i++) {
      System.out.print(nums[i] + " ");
    }
  }

}
