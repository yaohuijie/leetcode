package algorithm.string;

/**
 * 344. 反转字符串
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/23 16:20
 */
public class ReverseStringSolution {

  /**
   * 双指针
   */
  public void reverseString(char[] s) {
    int l = 0, r = s.length - 1;
    while (l < r) {
      char a = s[l];
      s[l] = s[r];
      s[r] = a;
      l++;
      r--;
    }
  }

}
