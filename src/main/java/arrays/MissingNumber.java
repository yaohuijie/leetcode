package arrays;

/**
 * 268. 丢失的数字
 *
 * <p>
 * 给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/8 17:14
 */
public class MissingNumber {

  public static void main(String[] args) {
    MissingNumber solution = new MissingNumber();
    int[] nums = {3, 0, 1};
    System.out.println(solution.missingNumber(nums));
  }

  public int missingNumber(int[] nums) {
    int[] cop = new int[nums.length + 1];
    for (int num : nums) {
      cop[num]++;
    }
    for (int i = 0; i < cop.length; i++) {
      if (cop[i] == 0) {
        return i;
      }
    }
    return -1;
  }

}
