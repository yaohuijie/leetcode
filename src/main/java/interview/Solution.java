package interview;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Spliterator.OfInt;
import java.util.jar.JarEntry;

/**
 * 面试题  17.14.  最小k个数
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/3 11:26
 */
public class Solution {

  /**
   * 排序
   *
   * @param arr 任意数组
   * @param k   返回个数
   * @return 最小数数组
   */
  public int[] smallestK(int[] arr, int k) {
    int[] small = new int[k];
    Arrays.sort(arr);
    if (small.length >= 0) {
      System.arraycopy(arr, 0, small, 0, small.length);
    }
    return small;
  }

  /**
   * 堆
   *
   * @param arr 任意数组
   * @param k   返回个数
   * @return 最小数数组
   */
  public int[] smallestK1(int[] arr, int k) {
    int[] small = new int[k];
    //排除k=0的情况
    if (k == 0 || arr.length == 0) {
      return small;
    }
    PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    for (int i = 0; i < k; i++) {
      queue.offer(arr[i]);
    }
    for (int i = k; i < arr.length; i++) {
      if (queue.peek() > arr[i]) {
        queue.poll();
        queue.offer(arr[i]);
      }
    }
    for (int i = 0; i < k; i++) {
      small[i] = queue.poll();
    }
    return small;
  }

  /**
   * 快速排序
   *
   * @param arr 任意数组
   * @param k   返回个数
   * @return 最小数数组
   */
  public int[] smallestK2(int[] arr, int k) {
    int[] small = new int[k];
    randomizedSelected(arr, 0, arr.length - 1, k);
    if (k >= 0) {
      System.arraycopy(arr, 0, small, 0, k);
    }
    return small;
  }

  private void randomizedSelected(int[] arr, int l, int r, int k) {
    if (l >= r) {
      return;
    }
    int pos = randomizedPartition(arr, l, r);
    int num = pos - l + 1;
    if (k != num) {
      if (k < num) {
        randomizedSelected(arr, l, pos - 1, k);
      } else {
        randomizedSelected(arr, pos + 1, r, k - num);
      }
    }
  }

  /**
   * 基于随机的划分
   */
  private int randomizedPartition(int[] nums, int l, int r) {
    int i = new Random().nextInt(r - l + 1) + 1;
    swap(nums, r, i);
    return partition(nums, l, r);
  }

  private int partition(int[] nums, int l, int r) {
    int pivot = nums[r];
    int i = l - 1;
    for (int j = l; j <= r - 1; j++) {
      if (nums[j] <= pivot) {
        i = i + 1;
        swap(nums, i, j);
      }
    }
    swap(nums, i + 1, r);
    return i + 1;
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  /**
   * 设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可
   */
  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] arr = new int[]{5, 4, 43, 33, 3};
    int[] small = solution.smallestK(arr, 1);
    System.out.println(Arrays.toString(small));
    arr = new int[]{5, 4, 43, 33, 3};
    System.out.println(Arrays.toString(solution.smallestK1(arr, 2)));
    arr = new int[]{5, 4, 43, 33, 3};
    System.out.println(Arrays.toString(solution.smallestK2(arr, 3)));

  }

}
