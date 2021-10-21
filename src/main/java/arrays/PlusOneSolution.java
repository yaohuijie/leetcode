package arrays;

import java.util.Arrays;

/**
 * 66. 加一
 * <p>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * <br> 最高位数字存放在数组的首位，数组中每个元素只存储单个数字。
 * <br> 你可以假设除了整数 0 之外，这个整数不会以 0 开头。
 * <br> 提示：1. 1<= digits.length <= 100
 * <br/> 2. 0<= digits[i] <=9
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/21 11:46
 */
public class PlusOneSolution {

  public static void main(String[] args) {
    PlusOneSolution solution = new PlusOneSolution();
    //123 -> 124 {1, 2, 4}
    int[] digits = {1, 2, 3};
    System.out.println(Arrays.toString(solution.plusOne(digits)));
    //9 -> 10 {1, 0}
    digits = new int[]{9};
    System.out.println(Arrays.toString(solution.plusOne(digits)));
    //129 -> 130 {1, 3, 0}
    digits = new int[]{1, 2, 9};
    System.out.println(Arrays.toString(solution.plusOne(digits)));

  }

  public int[] plusOne(int[] digits) {
    int len = digits.length;
    for (int i = len - 1; i >= 0; i--) {
      if (digits[i] != 9) {
        digits[i]++;
        for (int j = i + 1; j < len; j++) {
          digits[j] = 0;
        }
        return digits;
      }
    }
    //digits 中所有元素均为9
    int[] ans = new int[len + 1];
    ans[0] = 1;
    return ans;
  }
}
