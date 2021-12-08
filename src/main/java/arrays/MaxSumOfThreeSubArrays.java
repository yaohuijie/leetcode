package arrays;

import java.util.Arrays;

/**
 * 689. 三个无重叠子数组的最大和
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且 3 * k 项的和最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-sum-of-3-non-overlapping-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/8 16:12
 */
public class MaxSumOfThreeSubArrays {

  public static void main(String[] args) {
    MaxSumOfThreeSubArrays solution = new MaxSumOfThreeSubArrays();
    int[] arr = {1, 2, 1, 2, 6, 7, 5, 1};
    System.out.println(Arrays.toString(solution.maxSumOfThreeSubarrays(arr, 2)));
  }

  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    int[] ans = new int[3];
    int sum1 = 0, maxSum1 = 0, maxSum1Idx = 0;
    int sum2 = 0, maxSum12 = 0, maxSum12Idx1 = 0, maxSum12Idx2 = 0;
    int sum3 = 0, maxTotal = 0;
    int a = 2;
    for (int i = k * a; i < nums.length; ++i) {
      sum1 += nums[i - k * 2];
      sum2 += nums[i - k];
      sum3 += nums[i];
      if (i >= k * 3 - 1) {
        if (sum1 > maxSum1) {
          maxSum1 = sum1;
          maxSum1Idx = i - k * 3 + 1;
        }
        if (maxSum1 + sum2 > maxSum12) {
          maxSum12 = maxSum1 + sum2;
          maxSum12Idx1 = maxSum1Idx;
          maxSum12Idx2 = i - k * 2 + 1;
        }
        if (maxSum12 + sum3 > maxTotal) {
          maxTotal = maxSum12 + sum3;
          ans[0] = maxSum12Idx1;
          ans[1] = maxSum12Idx2;
          ans[2] = i - k + 1;
        }
        sum1 -= nums[i - k * 3 + 1];
        sum2 -= nums[i - k * 2 + 1];
        sum3 -= nums[i - k + 1];
      }
    }
    return ans;
  }

}
