package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1218. 最长定差子序列
 * <p>
 * 给你一个整数数组 arr和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
 * <p>
 * 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/longest-arithmetic-subsequence-of-given-difference
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/5 10:54
 */
public class LongestSubsequence {

  public static void main(String[] args) {
    LongestSubsequence solution = new LongestSubsequence();
    int[] arr = {1, 5, 7, 8, 5, 3, 4, 2, 1};
    //最长子序列是{7,5,3,1}
    System.out.println(solution.longestSubsequence(arr, -2));
  }

  public int longestSubsequence(int[] arr, int difference) {
    Map<Integer, Integer> dp = new HashMap<>(arr.length);
    int ans = 0;
    for (int i : arr) {
      dp.put(i, dp.getOrDefault(i - difference, 0) + 1);
      ans = Math.max(ans, dp.get(i));
    }
    return ans;
  }

}
