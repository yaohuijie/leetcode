package math;

/**
 * 326. 3的幂
 *
 * <p>
 * 给定一个整数，写一个函数来判断它是否是 3的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/23 16:02
 */
public class IsPowerOfThreeSolution {

  /**
   * 试除法
   */
  public boolean isPowerOfThree(int n) {
    while (n != 0 && n % 3 == 0) {
      n = n / 3;
    }
    return n == 1;
  }

  /**
   * int类型的最大3次幂是3的19次方，即1162261467。 所有3的次幂都是它的约数
   */
  public boolean isPowerOfThree1(int n) {
    return n > 0 && 1162261467 % n == 0;
  }


}
