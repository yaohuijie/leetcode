package algorithm.point;

import java.util.Arrays;

/**
 * 977. 有序数组的平方
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/15 14:20
 */
public class SortedSquaresSolution {

  /**
   * 直接平方后排序
   */
  public int[] sortedSquares(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      nums[i] = (int) Math.pow(nums[i], 2);
    }
    Arrays.sort(nums);
    return nums;
  }

  /**
   * 双指针
   */
  public int[] sortedSquares1(int[] nums) {
    int n = nums.length;
    int negative = -1;
    //找到绝对值最接近0的下标
    for (int i = 0; i < n; i++) {
      if (nums[i] < 0) {
        negative = i;
      } else {
        break;
      }
    }
    int[] ans = new int[n];
    int index = 0, i = negative, j = negative + 1;
    while (i >= 0 || j < n) {
      if (i < 0) {
        //没有负数
        ans[index] = nums[j] * nums[j];
        j++;
      } else if (j == n) {
        //全是负数
        ans[index] = nums[i] * nums[i];
        i--;
      } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
        ans[index] = nums[i] * nums[i];
        i--;
      } else {
        ans[index] = nums[j] * nums[j];
        j++;
      }
      index++;
    }
    return ans;

  }

}
