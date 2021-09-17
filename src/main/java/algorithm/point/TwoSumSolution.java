package algorithm.point;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. 两数之和Ⅱ -输入有序数组
 * <p>
 * 给定一个已按照 非递减顺序排列 的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
 * <p>
 * 函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <=
 * numbers.length 。
 * <p>
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/17 16:29
 */
public class TwoSumSolution {

  /**
   * 双指针
   */
  public int[] twoSum(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1;
    while (low < high) {
      int sum = numbers[low] + numbers[high];
      if (sum == target) {
        return new int[]{low + 1, high + 1};
      } else if (sum < target) {
        low++;
      } else {
        high--;
      }
    }
    return new int[]{0, 0};
  }

  public int[] twoSum1(int[] numbers, int target) {
    int[] ans = new int[2];
    Map<Integer, Integer> map = new HashMap<>(numbers.length);
    for (int i = 0; i < numbers.length; i++) {
      map.put(numbers[i], i);
    }
    for (int i = 0; i < numbers.length; i++) {
      int m = target - numbers[i];
      if (map.containsKey(m) && map.get(m) != i) {
        Integer j = map.get(m);
        if (i > j) {
          ans[0] = j + 1;
          ans[1] = i + 1;
        } else {
          ans[0] = i + 1;
          ans[1] = j + 1;
        }
        break;
      }
    }
    return ans;
  }

}
