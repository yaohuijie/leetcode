package matrix;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 407. 接雨水 Ⅱ
 *
 * <p>
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/3 14:16
 */
public class TrapRainWaterSolution {

  /**
   * <p>
   * <br> 1   4  3  1  3   2
   * <br>    ____________
   * <br> 3 | 2  1  3  2 | 4
   * <br>   ￣￣￣￣￣￣￣
   * <br> 2   3  3  2  3   1
   * </p>
   */
  public static void main(String[] args) {
    TrapRainWaterSolution solution = new TrapRainWaterSolution();
    int[][] matrix = {{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};
    System.out.println(solution.trapRainWater(matrix));
  }

  public int trapRainWater(int[][] heightMap) {
    int m = heightMap.length, n = heightMap[0].length;
    if (m < 3 || n < 3) {
      return 0;
    }
    boolean[][] visit = new boolean[m][n];
    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
          pq.offer(new int[]{i * n + j, heightMap[i][j]});
          visit[i][j] = true;
        }
      }
    }
    int res = 0;
    int[] dirs = {-1, 0, 1, 0, -1};
    while (!pq.isEmpty()) {
      int[] curr = pq.poll();
      for (int k = 0; k < 4; k++) {
        int nx = curr[0] / n + dirs[k];
        int ny = curr[0] % n + dirs[k + 1];
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visit[nx][ny]) {
          if (curr[1] > heightMap[nx][ny]) {
            res += curr[1] - heightMap[nx][ny];
          }
          pq.offer(new int[]{nx * n + ny, Math.max(heightMap[nx][ny], curr[1])});
          visit[nx][ny] = true;
        }
      }
    }
    return res;
  }

}
