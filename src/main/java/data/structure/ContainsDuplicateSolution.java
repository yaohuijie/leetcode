package data.structure;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 217. 存在重复元素
 * <p>给定一个整数数组，判断是否存在重复元素。
 * 如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。</p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/14 11:40
 */
public class ContainsDuplicateSolution {

  public static void main(String[] args) {
    ContainsDuplicateSolution solution = new ContainsDuplicateSolution();
    int[] nums = new int[]{1, 2, 3, 1};
    System.out.println(solution.containsDuplicate(nums));
  }

  /**
   * 排序
   */
  public boolean containsDuplicate(int[] nums) {
    Arrays.sort(nums);
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] == nums[i + 1]) {
        return true;
      }
    }
//    return Arrays.stream(nums).distinct().count() < nums.length;
    return false;
  }

  /**
   * hashSet
   */
  public boolean containsDuplicate1(int[] nums) {
    HashSet<Integer> set = new HashSet<>();
    for (int i : nums) {
      if (!set.add(i)) {
        return true;
      }
    }
    return false;
  }
}
