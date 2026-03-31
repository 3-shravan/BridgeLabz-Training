
public class MissingNo {

  public static void main(String[] args) {
    MissingNo missingNo = new MissingNo();
    int[] nums = { 3, 0, 1 };
    System.out.println(missingNo.missingNumber(nums));
  }

  public int missingNumber(int[] nums) {

    int sumOfElements = 0;
    int sumOfIndices = nums.length;

    for (int i = 0; i < nums.length; i++) {
      sumOfElements += nums[i];
      sumOfIndices += i;
    }
    return sumOfIndices - sumOfElements;

  }

}
