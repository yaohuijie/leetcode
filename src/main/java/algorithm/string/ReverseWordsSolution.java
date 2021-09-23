package algorithm.string;

/**
 * 557. 反转字符串中的单词
 *
 * <p>
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/23 16:25
 */
public class ReverseWordsSolution {

  public String reverseWords(String s) {
    String[] s1 = s.split(" ");
    StringBuilder builder = new StringBuilder();
    for (String ss : s1) {
      int l = 0, r = ss.length() - 1;
      char[] chars = ss.toCharArray();
      while (l < r) {
        char n = chars[l];
        chars[l] = chars[r];
        chars[r] = n;
        l++;
        r--;
      }
      builder.append(chars);
      builder.append(" ");
    }
    builder.deleteCharAt(s.length());
    return builder.toString();
  }

}
