package arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373.查找和最小的k对数字
 * <p>
 * 给定两个以 升序排列 的整数数组 nums1 和 nums2,以及一个整数 k。
 * <p>
 * 定义一对值(u,v)，其中第一个元素来自nums1，第二个元素来自 nums2。
 * <p>
 * 请找到和最小的 k个数对(u1,v1), (u2,v2) ... (uk,vk)。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2022/1/14 18:36
 */
public class KSmallestPairs {

  public static void main(String[] args) {
    KSmallestPairs solution = new KSmallestPairs();
    int[] arr1 = {1, 7, 11};
    int[] arr2 = {2, 4, 6};
    System.out.println(solution.kSmallestPairs(arr1, arr2, 3));
    System.out.println(solution.kSmallestPairs1(arr1, arr2, 3));
  }

  /**
   * 优先队列
   *
   * @param nums1 int[] 第一个递增数组
   * @param nums2 int[] 第二个递增数组
   * @param k     int 对数
   * @return List<List < Integer>>
   */
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>(k,
        (o1, o2) -> nums1[o1[0]] + nums2[o1[1]] - nums1[o2[0]] - nums2[o2[1]]);
    List<List<Integer>> ans = new ArrayList<>();
    int m = nums1.length;
    int n = nums2.length;
    for (int i = 0; i < Math.min(m, k); i++) {
      pq.offer(new int[]{i, 0});
    }
    while (k-- > 0 && !pq.isEmpty()) {
      int[] idxPair = pq.poll();
      List<Integer> list = new ArrayList<>();
      list.add(nums1[idxPair[0]]);
      list.add(nums2[idxPair[1]]);
      ans.add(list);
      if (idxPair[1] + 1 < n) {
        pq.offer(new int[]{idxPair[0], idxPair[1] + 1});
      }
    }
    return ans;
  }

  /**
   * 二分法
   *
   * @param nums1 int[] 第一个递增数组
   * @param nums2 int[] 第二个递增数组
   * @param k     int 对数
   * @return List<List < Integer>>
   */
  public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
    int m = nums1.length;
    int n = nums2.length;

    // 二分法查找第k小的数对和的大小
    int left = nums1[0] + nums2[0];
    int right = nums1[m - 1] + nums2[n - 1];
    int pairSum = right;
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      long cnt = 0;
      int start = 0;
      int end = n - 1;
      while (start < m && end >= 0) {
        if (nums1[start] + nums2[end] > mid) {
          end--;
        } else {
          cnt += end + 1;
          start++;
        }
      }
      if (cnt < k) {
        left = mid + 1;
      } else {
        pairSum = mid;
        right = mid - 1;
      }
    }
    List<List<Integer>> ans = new ArrayList<>();
    int pos = n - 1;
    //找到小于目标值 pairSum 的数对
    for (int value : nums1) {
      while (pos >= 0 && value + nums2[pos] >= pairSum) {
        pos--;
      }
      for (int j = 0; j < pos && k > 0; j++, k--) {
        List<Integer> list = new ArrayList<>();
        list.add(value);
        list.add(nums2[j]);
        ans.add(list);
      }
    }

    //找到等于目标值 pairSum 的数对
    pos = n - 1;
    for (int i = 0; i < m && k > 0; i++) {
      while (pos >= 0 && nums1[i] + nums2[pos] > pairSum) {
        pos--;
      }
      for (int j = i; k > 0 && j >= 0 && nums1[j] + nums2[pos] == pairSum; j--, k--) {
        List<Integer> list = new ArrayList<>();
        list.add(nums1[j]);
        list.add(nums2[pos]);
        ans.add(list);
      }
    }
    return ans;
  }

}
