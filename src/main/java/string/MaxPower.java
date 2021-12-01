package string;

/**
 * 1446.连续字符
 *
 * <p>
 * 给你一个字符串 s ，字符串的「能量」定义为：只包含一种字符的最长非空子字符串的长度。
 * <p>
 * 请你返回字符串的能量
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/1 14:08
 */
public class MaxPower {

  public static void main(String[] args) {
    MaxPower solution = new MaxPower();
    System.out.println(solution.maxPower("leetcode"));
  }

  public int maxPower(String s) {
    int len = 1;
    int max = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == s.charAt(i)) {
        len++;
        max = Math.max(max, len);
      } else {
        len = 1;
      }
    }
    return max;
  }

}
