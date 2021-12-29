package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1995.统计特殊四元组
 * <p>
 * 给你一个 下标从 0 开始 的整数数组 arr ，返回满足下述条件的 不同 四元组 (a, b, c, d) 的 数目 ：
 * <p>
 * arr[a] + arr[b] + arr[c] == arr[d] ，且 a < b < c < d
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-special-quadruplets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/29 16:15
 */
public class CountQuadruplets {

  public static void main(String[] args) {
    CountQuadruplets solution = new CountQuadruplets();
    int[] arr = {1, 1, 1, 3, 5};
    System.out.println(solution.countQuadruplets(arr));
    System.out.println(solution.countQuadruplets1(arr));
  }

  /**
   * 枚举
   *
   * @param arr int[]
   * @return int
   */
  public int countQuadruplets(int[] arr) {
    int sum = 0, len = arr.length;
    for (int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        for (int k = j + 1; k < len; k++) {
          for (int l = k + 1; l < len; l++) {
            if (arr[i] + arr[j] + arr[k] == arr[l]) {
              sum++;
            }
          }
        }
      }
    }
    return sum;
  }

  /**
   * hash表存储
   *
   * @param arr int[]
   * @return int
   */
  public int countQuadruplets1(int[] arr) {
    int ans = 0, len = arr.length;
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int a = len - 3; a >= 1; a--) {
      for (int b = a + 2; b < len; b++) {
        cnt.put(arr[b] - arr[a + 1], cnt.getOrDefault(arr[b] - arr[a + 1], 0) + 1);
      }
      for (int c = 0; c < a; c++) {
        ans += cnt.getOrDefault(arr[c] + arr[a], 0);
      }
    }
    return ans;
  }

}
