package arrays;

import java.util.Arrays;
import java.util.Random;

/**
 * 384.打乱数组
 * <p>
 * 给你一个整数数组nums，设计算法来打乱一个没有重复元素的数组。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/22 14:20
 */
public class Solution {

  private final int[] arr;
  private final int[] original;

  public Solution(int[] nums) {
    this.arr = nums;
    this.original = new int[nums.length];
    System.arraycopy(nums, 0, original, 0, nums.length);
  }

  public static void main(String[] args) {
    int[] nums = {1, 2, 3};
    Solution solution = new Solution(nums);
    System.out.println(Arrays.toString(solution.shuffle()));
    System.out.println(Arrays.toString(solution.reset()));
    System.out.println(Arrays.toString(solution.shuffle()));

  }

  /**
   * 重设数组到它的初始状态并返回
   */
  public int[] reset() {
    System.arraycopy(original, 0, arr, 0, original.length);
    return arr;
  }

  /**
   * 返回数组随机打乱后的结果
   */
  public int[] shuffle() {
    if (arr == null) {
      return null;
    }
    Random random = new Random();
    for (int i = 0; i < arr.length; i++) {
      int j = i + random.nextInt(arr.length - i);
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }
    return arr;
  }

}
