package math;

/**
 * 367. 有效的完全平方数
 *
 * <p>
 * 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 进阶：不要 使用任何内置的库函数，如 sqrt
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-perfect-square
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/4 10:50
 */
public class IsPerfectSquareSolution {

  public static void main(String[] args) {
    IsPerfectSquareSolution solution = new IsPerfectSquareSolution();
    System.out.println(solution.isPerfectSquare(33));
    System.out.println(solution.isPerfectSquare1(25));
    System.out.println(solution.isPerfectSquare2(25));
  }

  /**
   * 开平方
   */
  public boolean isPerfectSquare(int num) {
    int n = (int) Math.sqrt(num);
    return n * n == num;
  }

  /**
   * 二分法
   */
  public boolean isPerfectSquare1(int num) {
    int left = 0, right = num;
    while (left <= right) {
      int mid = (right - left) / 2 + left;
      long s = (long) mid * mid;
      if (s < num) {
        left = mid + 1;
      } else if (s == num) {
        return true;
      } else {
        right = mid - 1;
      }
    }
    return false;
  }

  /**
   * 牛顿迭代法
   */
  public boolean isPerfectSquare2(int num) {
    double a = num;
    while (true) {
      double b = (a + num / a) / 2;
      if (a - b < 1e-6) {
        break;
      }
      a = b;
    }
    int x = (int) a;
    return x * x == num;
  }

}
