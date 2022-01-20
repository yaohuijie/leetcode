package algorithm.greedy;

/**
 * 2029.石子游戏 Ⅸ
 * <p>
 * Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，其中 stones[i] 是第 i
 * 个石子的价值。
 * <p>
 * Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。
 * <p>
 * 如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
 * <p>
 * 如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
 * <p>
 * 假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/stone-game-ix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2022/1/20 11:54
 */
public class StoneGameIX {

  public static void main(String[] args) {
    StoneGameIX solution = new StoneGameIX();
    int[] stones = {2, 1};
    System.out.println(solution.stoneGameIX(stones));
  }

  public boolean stoneGameIX(int[] stones) {
    int cnt0 = 0, cnt1 = 0, cnt2 = 0;
    for (int val : stones) {
      int type = val % 3;
      if (type == 0) {
        cnt0++;
      } else if (type == 1) {
        cnt1++;
      } else {
        cnt2++;
      }
    }
    if (cnt0 % 2 == 0) {
      return cnt1 >= 1 && cnt2 >= 1;
    }
    return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
  }

}
