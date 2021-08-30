package random;

import java.util.Arrays;

/**
 * 528. 按权重随机选择
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/8/30 16:05
 */
public class Solution {

  int[] pre;
  int total;

  /**
   * 给定一个正整数数组w ，其中w[i]代表下标 i的权重（下标从 0 开始），请写一个函数pickIndex， 它可以随机地获取下标 i，选取下标 i的概率与w[i]成正比
   *
   * @param w 随机整数数组 1 <= w.length <= 10000 1 <= w[i] <= 10^5 pickIndex 将被调用不超过10000次
   */
  public Solution(int[] w) {
    pre = new int[w.length];
    pre[0] = w[0];
    for (int i = 1; i < w.length; ++i) {
      pre[i] = pre[i - 1] + w[i];
    }
    total = Arrays.stream(w).sum();
  }

  public int pickIndex() {
    int x = (int) (Math.random() * total) + 1;
    return binarySearch(x);
  }

  private int binarySearch(int x) {
    int low = 0, high = pre.length - 1;
    while (low < high) {
      int mid = (high - low) / 2 + low;
      if (pre[mid] < x) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    Solution s = new Solution(new int[]{3, 12, 1, 7});
    for (int i =0; i< 1000; i++) {
      System.out.println(s.pickIndex());
    }
  }

}
