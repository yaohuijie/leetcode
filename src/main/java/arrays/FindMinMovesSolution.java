package arrays;

import java.util.Arrays;

/**
 * 517. 超级洗衣机
 *
 * <p>
 * 假设有 n 台超级洗衣机放在同一排上。开始的时候，每台洗衣机内可能有一定量的衣服，也可能是空的。
 * <p>
 * 在每一步操作中，你可以选择任意 m (1 <= m <= n) 台洗衣机，与此同时将每台洗衣机的一件衣服送到相邻的一台洗衣机。
 * <p>
 * 给定一个整数数组 machines 代表从左至右每台洗衣机中的衣物数量，请给出能让所有洗衣机中剩下的衣物的数量相等的 最少的操作步数 。如果不能使每台洗衣机中衣物的数量相等，则返回 -1
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/29 11:35
 */
public class FindMinMovesSolution {

  public int findMinMoves(int[] machines) {
    int sum = Arrays.stream(machines).sum();
    int len = machines.length;
    if (sum % len != 0) {
      return -1;
    }
    int avg = sum / len;
    int ans = 0, tot = 0;
    for (int num : machines) {
      num -= avg;
      tot += num;
      ans = Math.max(ans, Math.max(Math.abs(tot), num));
    }
    return ans;
  }
}
