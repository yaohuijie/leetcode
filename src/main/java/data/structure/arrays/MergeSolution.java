package data.structure.arrays;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * <p>
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * <p>
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0
 * ，应忽略。nums2 的长度为 n 。
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/15 11:54
 */
public class MergeSolution {

  /**
   * 直接合并排序
   */
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }

  /**
   * 双指针
   */
  public void merge1(int[] nums1, int m, int[] nums2, int n) {
    if (n == 0) {
      return;
    }
    int n1 = 0, n2 = 0;
    int[] sort = new int[m + n];
    int cur;
    while (n1 < m || n2 < n) {
      if (n1 == m) {
        cur = nums2[n2++];
      } else if (n2 == n) {
        cur = nums1[n1++];
      } else if (nums1[n1] < nums2[n2]) {
        cur = nums1[n1++];
      } else {
        cur = nums2[n2++];
      }
      sort[n1 + n2 - 1] = cur;
    }
    System.arraycopy(sort, 0, nums1, 0, m + n);
  }

}
