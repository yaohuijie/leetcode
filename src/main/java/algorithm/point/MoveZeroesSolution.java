package algorithm.point;

import java.util.Arrays;

/**
 * 283. 移动零
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/17 15:09
 */
public class MoveZeroesSolution {

  public static void main(String[] args) {
    int[] nums = new int[]{0, 1, 0, 3, 12};
    MoveZeroesSolution solution = new MoveZeroesSolution();
    solution.moveZeroes(nums);
    solution.moveZeroes1(nums);
    System.out.println(Arrays.toString(nums));
  }

  public void moveZeroes(int[] nums) {
    if (nums.length == 1) {
      return;
    }
    int len = nums.length;
    for (int i = 0; i < len; i++) {
      if (nums[i] == 0) {
        if (nums.length - 1 >= i) {
          System.arraycopy(nums, i + 1, nums, i, nums.length - 1 - i);
        }
        nums[nums.length - 1] = 0;
        i--;
        len--;
      }
    }
  }

  /**
   * 双指针
   */
  public void moveZeroes1(int[] nums) {
    int n = nums.length, left = 0, right = 0;
    while (right < n) {
      if (nums[right] != 0) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
      }
      right++;
    }
  }

}
