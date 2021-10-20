package arrays;

import java.util.Arrays;

/**
 * 453. 最小操作次数使数组元素相等
 * <p>
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/20 14:22
 */
public class MinMoveSolution {


  public static void main(String[] args) {
    MinMoveSolution solution = new MinMoveSolution();
    int[] nums = {1, 2, 3, 4};
    System.out.println(solution.minMoves(nums));
    nums = new int[]{1, 2, 3, 4};
    System.out.println(solution.minMoves1(nums));
    nums = new int[]{1, 2, 3, 4};
    System.out.println(solution.minMoves2(nums));
  }

  public int minMoves(int[] nums) {
    int move = 0;
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] >= min) {
        move += nums[i] - min;
      } else {
        move += (min - nums[i]) * i;
        min = nums[i];
      }
    }
    return move;
  }

  /**
   * 双循环
   */
  public int minMoves2(int[] nums) {
    int min = Arrays.stream(nums).min().orElse(Integer.MIN_VALUE);
    int move = 0;
    for (int num : nums) {
      move += num - min;
    }
    return move;
  }

  /**
   * 此方法需要考虑 int最大值问题。sum可能会超过int最大值
   */
  public int minMoves1(int[] nums) {
    if (nums.length == 1) {
      return 0;
    }
    int sum = 0;
    int min = nums[0];
    for (int num : nums) {
      min = Math.min(num, min);
      sum += num;
    }
    return sum - min * nums.length;
  }

}
