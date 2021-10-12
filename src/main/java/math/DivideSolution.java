package math;

/**
 * 29. 两数相除
 * <p>
 * 不使用 乘法、除法 和 mod运算符
 * <br> 被除数和除数均为32位有符号整数
 * <br> 除数不为0
 * <br> 假设只能存储32位有符号整数，其数值范围是[-2e31, 2e31-1]。如果除法结果溢出，则返回2e31-1.
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/12 14:35
 */
public class DivideSolution {

  public static void main(String[] args) {
    DivideSolution solution = new DivideSolution();
    System.out.println(solution.divide(100, 3));
  }

  /**
   * 二分法
   */
  public int divide(int dividend, int divisor) {
    //考虑除数为0的情况
    if (divisor == 0) {
      return 0;
    }
    //考虑被除数为最小值的情况
    if (dividend == Integer.MIN_VALUE) {
      if (divisor == 1) {
        return Integer.MIN_VALUE;
      }
      if (divisor == -1) {
        return Integer.MAX_VALUE;
      }
    }
    //考虑除数为最小值的情况
    if (divisor == Integer.MIN_VALUE) {
      return dividend == Integer.MIN_VALUE ? 1 : 0;
    }
    //一般情况，使用二分法查找
    //将所有的正数取相反数，这样就只需考虑一种情况
    boolean rev = false;
    if (dividend > 0) {
      dividend = -dividend;
      rev = true;
    }
    if (divisor > 0) {
      divisor = -divisor;
      rev = !rev;
    }
    int left = 1, right = Integer.MAX_VALUE, ans = 0;
    while (left <= right) {
      //注意溢出，并且不能使用除法
      int mid = left + ((right - left) >> 1);
      boolean check = quickAdd(divisor, mid, dividend);
      if (check) {
        ans = mid;
        //注意溢出
        if (mid == Integer.MAX_VALUE) {
          break;
        }
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return rev ? -ans : ans;
  }

  public boolean quickAdd(int y, int z, int x) {
    // x和y 是负数， z是正数
    //需要判断 z*y >= x 是否成立
    int result = 0, add = y;
    while (z != 0) {
      if ((z & 1) != 0) {
        //需要保证 result + add >= x
        if (result < x - add) {
          return false;
        }
        result += add;
      }
      if (z != 1) {
        //需要保证 add + add >= x
        if (add < x - add) {
          return false;
        }
        add += add;
      }
      z >>= 1;
    }
    return true;
  }
}
