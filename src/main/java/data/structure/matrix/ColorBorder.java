package data.structure.matrix;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 1034. 边界着色
 *
 * <p>
 * 给定一个 m x n 整数矩阵网格，以及三个整数 row、col 和 color。 网格中的每个值代表该位置的网格方块的颜色。
 * <p>
 * 如果两个正方形具有相同的颜色并且在 4 个方向中的任何一个方向上彼此相邻，则它们属于同一个连通分量。
 * <p>
 * 连通分量的边界是连通分量中与不在该分量中的正方形在 4 方向上相邻的所有正方形，或者在网格边界（第一行或最后一行或列）上的所有正方形。
 * <p>
 * 您应该使用颜色为包含方形 grid[row][col] 的连接组件的边框着色。
 * <p>
 * 返回最终网格。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/7 17:51
 */
public class ColorBorder {

  public static void main(String[] args) {
    ColorBorder solution = new ColorBorder();
    int[][] grid = {{1, 2, 2}, {2, 3, 2}};
    System.out.println(Arrays.deepToString(solution.colorBorder(grid, 0, 1, 3)));
  }

  public int[][] colorBorder(int[][] grid, int row, int col, int color) {
    int m = grid.length, n = grid[0].length;
    int[][] ans = new int[m][n];
    int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Deque<int[]> d = new ArrayDeque<>();
    d.addLast(new int[]{row, col});
    while (!d.isEmpty()) {
      int[] poll = d.pollFirst();
      int x = poll[0], y = poll[1], cnt = 0;
      for (int[] di : dirs) {
        int nx = x + di[0], ny = y + di[1];
        if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
          continue;
        }
        if (grid[x][y] != grid[nx][ny]) {
          continue;
        } else {
          cnt++;
        }
        if (ans[nx][ny] != 0) {
          continue;
        }
        d.addLast(new int[]{nx, ny});
      }
      ans[x][y] = cnt == 4 ? grid[x][y] : color;
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (ans[i][j] == 0) {
          ans[i][j] = grid[i][j];
        }
      }
    }
    return ans;
  }
}
