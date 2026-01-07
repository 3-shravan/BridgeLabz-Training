
public class SingleNumber {
  public static void main(String[] args) {
    SingleNumber sn = new SingleNumber();
    int[] nums = { 4, 1, 2, 1, 2 };
    System.out.println(sn.singleNumber(nums)); // Output: 4
  }

  public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
      result ^= num;
    }
    return result;

  }

}
