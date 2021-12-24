package algorithm.arrays;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1705.吃苹果的最大数目
 * <p>
 * 有一棵特殊的苹果树，一连 n 天，每天都可以长出若干个苹果。在第 i 天，树上会长出 apples[i] 个苹果，这些苹果将会在 days[i] 天后（也就是说，第 i + days[i]
 * 天时）腐烂，变得无法食用。也可能有那么几天，树上不会长出新的苹果，此时用 apples[i] == 0 且 days[i] == 0 表示。
 * <p>
 * 你打算每天 最多 吃一个苹果来保证营养均衡。注意，你可以在这 n 天之后继续吃苹果。
 * <p>
 * 给你两个长度为 n 的整数数组 days 和 apples ，返回你可以吃掉的苹果的最大数目。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-number-of-eaten-apples
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/24 14:32
 */
public class EatenApples {

  public static void main(String[] args) {
    EatenApples solution = new EatenApples();
    int[] apples = {1, 2, 3, 5, 2};
    int[] days = {3, 2, 1, 4, 2};
    System.out.println(solution.eatenApples(apples, days));
  }

  /**
   * 贪心 + 优先队列
   *
   * @param apples int[]
   * @param days   int[]
   * @return int
   */
  public int eatenApples(int[] apples, int[] days) {
    int ans = 0;
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
    int n = apples.length;
    int i = 0;
    while (i < n) {
      //移除 过期的苹果
      while (!pq.isEmpty() && pq.peek()[0] <= i) {
        pq.poll();
      }
      int rottenDay = i + days[i];
      int count = apples[i];
      if (count > 0) {
        pq.offer(new int[]{rottenDay, count});
      }
      if (!pq.isEmpty()) {
        int[] arr = pq.peek();
        arr[1]--;
        //移除 吃完的苹果
        if (arr[1] == 0) {
          pq.poll();
        }
        ans++;
      }
      i++;
    }
    while (!pq.isEmpty()) {
      while (!pq.isEmpty() && pq.peek()[0] <= i) {
        pq.poll();
      }
      if (pq.isEmpty()) {
        break;
      }
      int[] arr = pq.poll();
      int curr = Math.min(arr[0] - i, arr[1]);
      ans += curr;
      i += curr;
    }
    return ans;
  }
}
