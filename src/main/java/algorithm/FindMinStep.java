package algorithm;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * 488.祖玛游戏
 *
 * <p>
 * 你正在参与祖玛游戏的一个变种。
 * <p>
 * 在这个祖玛游戏变体中，桌面上有 一排 彩球，每个球的颜色可能是：红色 'R'、黄色 'Y'、蓝色 'B'、绿色 'G' 或白色 'W' 。你的手中也有一些彩球。
 * <p>
 * 你的目标是 清空 桌面上所有的球。每一回合：
 * <p>
 * 从你手上的彩球中选出 任意一颗 ，然后将其插入桌面上那一排球中：两球之间或这一排球的任一端。 接着，如果有出现 三个或者三个以上 且 颜色相同 的球相连的话，就把它们移除掉。
 * 如果这种移除操作同样导致出现三个或者三个以上且颜色相同的球相连，则可以继续移除这些球，直到不再满足移除条件。 如果桌面上所有球都被移除，则认为你赢得本场游戏。
 * 重复这个过程，直到你赢了游戏或者手中没有更多的球。 给你一个字符串 board ，表示桌面上最开始的那排球。另给你一个字符串 hand
 * ，表示手里的彩球。请你按上述操作步骤移除掉桌上所有球，计算并返回所需的 最少 球数。如果不能移除桌上所有的球，返回 -1 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/zuma-game
 * <p>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/10 11:25
 */
public class FindMinStep {

  public static void main(String[] args) {
    FindMinStep solution = new FindMinStep();
    System.out.println(solution.findMinStep("WWRRBBWW", "WRBRW"));
  }

  public String clean(String s) {
    String prev = "";
    while (!s.equalsIgnoreCase(prev)) {
      StringBuilder sb = new StringBuilder();
      int consecutive = 1;
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (i > 0) {
          if (c == s.charAt(i - 1)) {
            consecutive++;
          } else {
            if (consecutive >= 3) {
              sb.delete(sb.length() - consecutive, sb.length());
            }
            consecutive = 1;
          }
        }
        sb.append(c);
      }
      if (consecutive >= 3) {
        sb.delete(sb.length() - consecutive, sb.length());
      }
      prev = s;
      s = sb.toString();
    }
    return s;
  }

  public int findMinStep(String board, String hand) {
    char[] arr = hand.toCharArray();
    Arrays.sort(arr);
    hand = new String(arr);

    //初始化用队列维护的状态队列：其中的三个元素分别为桌面球状态、手中球状态和回合数
    Queue<State> queue = new ArrayDeque<>();
    queue.offer(new State(board, hand, 0));
    //初始化用哈希集合维护的已访问过的状态
    Set<String> visited = new HashSet<>();
    visited.add(board + "#" + hand);
    while (!queue.isEmpty()) {
      State state = queue.poll();
      String curBoard = state.board;
      String curHand = state.hand;
      int step = state.step;
      for (int i = 0; i <= curBoard.length(); i++) {
        for (int j = 0; j < curHand.length(); j++) {
          //第 1 个剪枝条件：当前球的颜色和上一个球的颜色相同
          if (j > 0 && curHand.charAt(j) == curHand.charAt(j - 1)) {
            continue;
          }
          //第 2 个剪枝条件：只在连续相同颜色的球的开头位置插入新球
          if (i > 0 && curBoard.charAt(i - 1) == curHand.charAt(j)) {
            continue;
          }
          //第 3 个剪枝条件: 只在以下两种情况放置新球
          //1. 当前球颜色与后面的球的颜色相同
          boolean choose = i < curBoard.length() && curBoard.charAt(i) == curHand.charAt(j);
          //2. 当前后颜色相同且与当前颜色不同时候放置球
          if (i > 0 && i < curBoard.length() && curBoard.charAt(i - 1) == curBoard.charAt(i)
              && curBoard.charAt(i - 1) != curHand.charAt(j)) {
            choose = true;
          }
          if (choose) {
            String newBoard = clean(
                curBoard.substring(0, i) + curHand.charAt(j) + curBoard.substring(i));
            String newHand = curHand.substring(0, j) + curHand.substring(j + 1);
            if (newBoard.length() == 0) {
              return step + 1;
            }
            String str = newBoard + "#" + newHand;
            if (visited.add(str)) {
              queue.offer(new State(newBoard, newHand, step + 1));
            }
          }
        }
      }
    }
    return -1;
  }

  class State {

    String board;
    String hand;
    int step;

    public State(String board, String hand, int step) {
      this.board = board;
      this.hand = hand;
      this.step = step;
    }
  }

}
