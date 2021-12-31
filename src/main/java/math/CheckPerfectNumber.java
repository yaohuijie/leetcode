package math;

/**
 * 507.完美数
 * <p>
 * 对于一个正整数，如果它和除了它自身以外的所有 正因子 之和相等，我们称它为 「完美数」。
 * <p>
 * 给定一个 整数 n，如果是完美数，返回 true，否则返回 false
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/perfect-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/31 11:44
 */
public class CheckPerfectNumber {

  public static void main(String[] args) {
    CheckPerfectNumber solution = new CheckPerfectNumber();
    System.out.println(solution.checkPerfectNumber(28));
  }

  public boolean checkPerfectNumber(int num) {
    int sum = 0;
    for (int i = 1; i < num; i++) {
      if (num % i == 0) {
        sum += i;
      }
    }
    return sum == num;
  }

  public boolean checkPerfectNumber1(int num) {
    return num == 6 || num == 28 || num == 496 || num == 8128 || num == 33550336;
  }
}
