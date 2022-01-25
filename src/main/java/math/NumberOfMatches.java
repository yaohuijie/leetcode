package math;

/**
 * 1688.比赛中的配对次数
 * <p>
 * 给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 * <p>
 * ·如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * <p>
 * ·如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 * <p>
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/count-of-matches-in-tournament
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2022/1/25 15:46
 */
public class NumberOfMatches {

  public static void main(String[] args) {
    NumberOfMatches solution = new NumberOfMatches();
    System.out.println(solution.numberOfMatches(7));
    System.out.println(solution.numberOfMatches1(7));
  }

  public int numberOfMatches(int n) {
    return n - 1;
  }

  public int numberOfMatches1(int n) {
    int sum = 0;
    while (n > 1) {
      sum += n / 2;
      if (n % 2 == 0) {
        n = n >> 1;
      } else {
        n = (n + 1) >> 1;
      }
    }
    return sum;
  }

}
