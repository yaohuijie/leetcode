package algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 851.喧闹和富有
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/15 14:28
 */
public class LoudAndRich {

  public static void main(String[] args) {
    LoudAndRich solution = new LoudAndRich();
    int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
    int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
    System.out.println(Arrays.toString(solution.loudAndRich(richer, quiet)));
  }

  public int[] loudAndRich(int[][] richer, int[] quiet) {
    int len = quiet.length;
    List<Integer>[] g = new List[len];
    for (int i = 0; i < len; i++) {
      g[i] = new ArrayList<>();
    }
    for (int[] ints : richer) {
      g[ints[1]].add(ints[0]);
    }
    int[] ans = new int[len];
    Arrays.fill(ans, -1);
    for (int i = 0; i < len; i++) {
      dfs(i, quiet, g, ans);
    }
    return ans;
  }

  private void dfs(int x, int[] quiet, List<Integer>[] g, int[] ans) {
    if (ans[x] != -1) {
      return;
    }
    ans[x] = x;
    for (Integer y : g[x]) {
      dfs(y, quiet, g, ans);
      if (quiet[ans[y]] < quiet[ans[x]]) {
        ans[x] = ans[y];
      }
    }
  }

}
