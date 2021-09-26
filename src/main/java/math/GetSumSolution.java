package math;

/**
 * 371. 两整数之和
 *
 * <p>
 * 给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。
 * </P>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/26 11:42
 */
public class GetSumSolution {

  /**
   * 位运算
   */
  public int getSum(int a, int b) {
    while (b != 0) {
      int carry = (a & b) << 1;
      a = a ^ b;
      b = carry;
    }
    return a;
  }

}
