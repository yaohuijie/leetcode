package data.structure.matrix;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.TreeSet;

/**
 * 1036.逃离大迷宫
 * <p>
 * 在一个 10e6 x 10e6 的网格中，每个网格上方格的坐标为 (x, y) 。
 * <p>
 * 现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表，其中每个 blocked[i] =
 * [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。
 * <p>
 * 每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。
 * <p>
 * 只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/escape-a-large-maze
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2022/1/11 11:19
 */
public class IsEscapePossible {

  static final int BOUNDARY = 1000000;
  static final int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

  public static void main(String[] args) {
    IsEscapePossible solution = new IsEscapePossible();
    int[][] block = {{5, 5}, {6, 6}, {7, 7}};
    int[] source = {0, 0};
    int[] target = {99999, 99999};
    System.out.println(solution.isEscapePossible(block, source, target));
  }

  /**
   * 离散化 + 广度优先搜索
   *
   * @param blocked int[][]
   * @param source  int[]
   * @param target  int[]
   * @return boolean
   */
  public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
    if (blocked.length < 2) {
      return true;
    }
    // 离散化
    TreeSet<Integer> rows = new TreeSet<>();
    TreeSet<Integer> columns = new TreeSet<>();
    for (int[] pos : blocked) {
      rows.add(pos[0]);
      columns.add(pos[1]);
    }
    rows.add(source[0]);
    rows.add(target[0]);
    columns.add(source[1]);
    columns.add(target[1]);

    Map<Integer, Integer> rMapping = new HashMap<>();
    Map<Integer, Integer> cMapping = new HashMap<>();

    int firstRow = rows.first();
    int rId = (firstRow == 0 ? 0 : 1);
    rMapping.put(firstRow, rId);
    int prevRow = firstRow;
    for (Integer row : rows) {
      if (row == firstRow) {
        continue;
      }
      rId += (row == prevRow + 1 ? 1 : 2);
      rMapping.put(row, rId);
      prevRow = row;
    }
    if (prevRow != BOUNDARY - 1) {
      rId++;
    }

    int firstColumn = columns.first();
    int cId = (firstColumn == 0 ? 0 : 1);
    cMapping.put(firstColumn, cId);
    int prevColumn = firstColumn;
    for (Integer column : columns) {
      if (column == firstColumn) {
        continue;
      }
      cId += column == prevColumn + 1 ? 1 : 2;
      cMapping.put(column, cId);
      prevColumn = column;
    }
    if (prevColumn != BOUNDARY - 1) {
      cId++;
    }
    int[][] grid = new int[rId + 1][cId + 1];
    for (int[] pos : blocked) {
      int x = pos[0], y = pos[1];
      grid[rMapping.get(x)][cMapping.get(y)] = 1;
    }
    int sx = rMapping.get(source[0]), sy = cMapping.get(source[1]);
    int tx = rMapping.get(target[0]), ty = cMapping.get(target[1]);

    Queue<int[]> queue = new ArrayDeque<>();
    queue.offer(new int[]{sx, sy});
    grid[sx][sy] = 1;
    while (!queue.isEmpty()) {
      int[] arr = queue.poll();
      int x = arr[0], y = arr[1];
      for (int d = 0; d < 4; d++) {
        int nx = x + dirs[d][0], ny = y + dirs[d][1];
        if (nx >= 0 && nx <= rId && ny >= 0 && ny <= cId && grid[nx][ny] != 1) {
          if (nx == tx && ny == ty) {
            return true;
          }
          queue.offer(new int[]{nx, ny});
          grid[nx][ny] = 1;
        }
      }
    }
    return false;
  }

}
