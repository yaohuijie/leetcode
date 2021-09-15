package data.structure.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 *
 * <p>
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 你可以按任意顺序返回答案。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/15 11:47
 */
public class TwoSumSolution {

  /**
   * hash
   */
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int m = target - nums[i];
      if (map.containsKey(m)) {
        return new int[]{map.get(m), i};
      }
      map.put(nums[i], i);
    }
    throw new IllegalArgumentException("no result");
  }

  /**
   * 暴力枚举
   */
  public int[] twoSum1(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      int m = target - nums[i];
      for (int j = 0; j < nums.length; j++) {
        if (m == nums[j] && j != i) {
          return new int[]{i, j};
        }
      }
    }
    throw new IllegalArgumentException("no result");
  }

}
