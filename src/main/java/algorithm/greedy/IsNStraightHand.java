package algorithm.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 846.一手顺子
 * <p>
 * Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。
 * <p>
 * 给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/hand-of-straights
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/30 15:03
 */
public class IsNStraightHand {

  public static void main(String[] args) {
    IsNStraightHand solution = new IsNStraightHand();
    int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
    System.out.println(solution.isNStraightHand(hand, 3));
  }

  /**
   * 贪心算法
   *
   * @param hand      int[]
   * @param groupSize int
   * @return boolean
   */
  public boolean isNStraightHand(int[] hand, int groupSize) {
    int len = hand.length;
    if (len % groupSize != 0) {
      return false;
    }
    Arrays.sort(hand);
    Map<Integer, Integer> cnt = new HashMap<>();
    for (int x : hand) {
      cnt.put(x, cnt.getOrDefault(x, 0) + 1);
    }
    for (int x : hand) {
      if (!cnt.containsKey(x)) {
        continue;
      }
      for (int j = 0; j < groupSize; j++) {
        int num = x + j;
        if (!cnt.containsKey(num)) {
          return false;
        }
        cnt.put(num, cnt.get(num) - 1);
        if (cnt.get(num) == 0) {
          cnt.remove(num);
        }
      }
    }
    return true;
  }

}
