package algorithm;

/**
 * 162. 寻找峰值
 *
 * <p>
 * 峰值元素是指其值严格大于左右相邻值的元素。 给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。 你可以假设nums[-1]
 * = nums[n] = -∞ 。 你必须实现时间复杂度为 O(log n) 的算法来解决此问题。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2021/9/15 11:13
 */
public class FindPeakElementSolution {

  /**
   * 二分法
   */
  public int findPeakElement2(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      int mid = l + ((l + r) >> 1);
      if (nums[mid] < nums[mid + 1]) {
        l = mid + 1;
      } else {
        r = mid;
      }
    }
    return l;
  }


  /**
   * 暴力
   */
  public int findPeakElement(int[] nums) {
    int len = nums.length - 1;
    if (len == 0) {
      return len;
    }
    if (nums[0] > nums[1]) {
      return 0;
    }
    if (nums[len] > nums[len - 1]) {
      return len;
    }
    for (int i = 1; i < len; i++) {
      if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 最大值
   */
  public int findPeakElement1(int[] nums) {
    int ids = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] > nums[ids]) {
        ids = i;
      }
    }
    return ids;
  }

}
