package arrays;

import java.util.Arrays;

/**
 * 506.相对名次
 *
 * <p>
 * 给你一个长度为 n 的整数数组 score ，其中 score[i] 是第 i 位运动员在比赛中的得分。所有得分都 互不相同 。
 * <p>
 * 运动员将根据得分 决定名次 ，其中名次第 1 的运动员得分最高，名次第 2 的运动员得分第 2 高，依此类推。运动员的名次决定了他们的获奖情况：
 * <p>
 * 名次第 1 的运动员获金牌 "Gold Medal" 。
 * <p>
 * 名次第 2 的运动员获银牌 "Silver Medal" 。
 * <p>
 * 名次第 3 的运动员获铜牌 "Bronze Medal" 。
 * <p>
 * 从名次第 4 到第 n 的运动员，只能获得他们的名次编号（即，名次第 x 的运动员获得编号 "x"）。
 * <p>
 * 使用长度为 n 的数组 answer 返回获奖，其中 answer[i] 是第 i 位运动员的获奖情况。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/relative-ranks
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/2 14:52
 */
public class FindRelativeRanks {

  public static void main(String[] args) {
    FindRelativeRanks solution = new FindRelativeRanks();
    int[] arr = {10, 3, 8, 9, 4};
    System.out.println(Arrays.toString(solution.findRelativeRanks(arr)));
  }

  public String[] findRelativeRanks(int[] score) {
    int len = score.length;
    String[] desc = {"Gold Medal", "Silver Medal", "Bronze Medal"};
    int[][] arr = new int[len][2];
    for (int i = 0; i < len; i++) {
      arr[i][0] = score[i];
      arr[i][1] = i;
    }
    Arrays.sort(arr, (a, b) -> b[0] - a[0]);
    String[] ans = new String[len];
    for (int i = 0; i < len; i++) {
      if (i >= 3) {
        ans[arr[i][1]] = Integer.toString(i + 1);
      } else {
        ans[arr[i][1]] = desc[i];
      }
    }
    return ans;
  }
}
