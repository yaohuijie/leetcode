package data.structure.arrays;

/**
 * 807.保持城市天际线
 *
 * <p>
 * 给你一座由 n x n 个街区组成的城市，每个街区都包含一座立方体建筑。给你一个下标从 0 开始的 n x n 整数矩阵 grid ，其中 grid[r][c] 表示坐落于 r 行 c
 * 列的建筑物的 高度 。
 * <p>
 * 城市的 天际线 是从远处观察城市时，所有建筑物形成的外部轮廓。从东、南、西、北四个主要方向观测到的 天际线 可能不同。
 * <p>
 * 我们被允许为 任意数量的建筑物 的高度增加 任意增量（不同建筑物的增量可能不同） 。 高度为 0 的建筑物的高度也可以增加。然而，增加的建筑物高度 不能影响 从任何主要方向观察城市得到的 天际线
 * 。
 * <p>
 * 在 不改变 从任何主要方向观测到的城市 天际线 的前提下，返回建筑物可以增加的 最大高度增量总和 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/max-increase-to-keep-city-skyline
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/13 17:30
 */
public class MaxIncreaseKeepingSkyline {


  public static void main(String[] args) {
    MaxIncreaseKeepingSkyline solution = new MaxIncreaseKeepingSkyline();
    int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7}, {9, 2, 6, 3}, {0, 3, 1, 0}};
    //ans = 35
    System.out.println(solution.maxIncreaseKeepingSkyline(grid));
  }

  public int maxIncreaseKeepingSkyline(int[][] grid) {
    int len = grid.length;
    int[] rowMax = new int[len];
    int[] colMax = new int[len];
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        rowMax[i] = Math.max(rowMax[i], grid[i][j]);
        colMax[j] = Math.max(colMax[j], grid[i][j]);
      }
    }
    int ans = 0;
    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        ans += Math.min(rowMax[i], colMax[j]) - grid[i][j];
      }
    }
    return ans;
  }
}
