package arrays;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * 496. 下一个更大元素 Ⅰ
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2，其中 nums1 是 nums2 的子集。
 * <p>
 * 请你找出 nums1 中每个元素在nums2中的下一个比其大的值。
 * <p>
 * nums1中数字 x 的下一个更大元素是指x在nums2中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/next-greater-element-i
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/26 11:05
 */
public class NextGreaterElementSolution {

  public static void main(String[] args) {
    NextGreaterElementSolution solution = new NextGreaterElementSolution();
    int[] nums1 = {4, 1, 2};
    int[] nums2 = {1, 3, 4, 2};
    System.out.println(Arrays.toString(solution.nextGreaterElement(nums1, nums2)));
    System.out.println(Arrays.toString(solution.nextGreaterElement1(nums1, nums2)));
  }

  /**
   * 单调栈 + hash表
   */
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    Map<Integer, Integer> map = new HashMap<>(nums2.length);
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = nums2.length - 1; i >= 0; i--) {
      int num = nums2[i];
      while (!stack.isEmpty() && num >= stack.peek()) {
        stack.pop();
      }
      map.put(num, stack.isEmpty() ? -1 : stack.peek());
      stack.push(num);
    }
    int[] ans = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      ans[i] = map.get(nums1[i]);
    }
    return ans;
  }

  /**
   * 暴力循环
   */
  public int[] nextGreaterElement1(int[] nums1, int[] nums2) {
    int[] ans = new int[nums1.length];
    for (int i = 0; i < nums1.length; i++) {
      boolean flag = false;
      for (int k : nums2) {
        if (nums1[i] == k) {
          flag = true;
        }
        if (flag && (k > nums1[i])) {
          ans[i] = k;
          break;
        }
      }
      if (flag && ans[i] == 0) {
        ans[i] = -1;
      }
    }
    return ans;
  }
}
