package algorithm;

/**
 * 35. 搜索插入位置
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。 请必须使用时间复杂度为 O(log n) 的算法
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/14 18:57
 */
public class SearchInsertSolution {

  /**
   * 二分法
   * <p>
   * 1 <= nums.length <= 10e4 -10e4 <= nums[i] <= 10e4 nums 为无重复元素的升序排列数组 -10e4 <= target <= 10e4
   * </p>
   */
  public int searchInsert(int[] nums, int target) {
    int l = 0, r = nums.length;
    while (l < r) {
      int mid = l + (r - l) / 2;
      if (nums[mid] > target) {
        r = mid;
      } else if (nums[mid] == target) {
        return mid;
      } else {
        l = mid + 1;
      }

    }
    return l;
  }

}
