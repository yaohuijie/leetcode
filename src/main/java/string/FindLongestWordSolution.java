package string;

import java.util.Arrays;
import java.util.List;

/**
 * 524. 通过删除字母匹配到字典里最长单词
 * <p>
 * 给你一个字符串 s 和一个字符串数组 dictionary 作为字典，找出并返回字典中最长的字符串，该字符串可以通过删除 s 中的某些字符得到。
 * 如果答案不止一个，返回长度最长且字典序最小的字符串。如果答案不存在，则返回空字符串。
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/14 10:55
 */
public class FindLongestWordSolution {

  public static void main(String[] args) {
    String s = "abce";
    List<String> dictionary = Arrays.asList("abe", "abc", "monkey", "plea");
    FindLongestWordSolution solution = new FindLongestWordSolution();
    System.out.println(solution.findLongestWord(s, dictionary));
    System.out.println(solution.findLongestWord1(s, dictionary));
  }

  /**
   * 双指针
   * <p>
   * 1 <= s.length <= 1000 ;
   * <p>
   * 1 <= dictionary.length() <= 1000;
   * <p>
   * 1 <= dictionary[i].length <= 1000
   * <p>
   * s 和 dictionary[i] 仅由小写英文字母组成
   */
  public String findLongestWord(String s, List<String> dictionary) {
    String max = "";
    for (String dic : dictionary) {
      int i = 0, j = 0, len = dic.length();
      while (i < s.length() && j < len) {
        if (s.charAt(i) == dic.charAt(j)) {
          j++;
        }
        i++;
      }
      if (j == len) {
        boolean flag = len == max.length() && dic.compareTo(max) < 0;
        if (len > max.length() || flag) {
          max = dic;
        }
      }
    }
    return max;
  }

  /**
   * 排序
   */
  public String findLongestWord1(String s, List<String> dictionary) {
    dictionary.sort((s1, s2) -> {
      if (s1.length() != s2.length()) {
        return s2.length() - s1.length();
      } else {
        return s1.compareTo(s2);
      }
    });
    for (String dic : dictionary) {
      int i = 0, j = 0, len = dic.length();
      while (i < s.length() && j < len) {
        if (s.charAt(i) == dic.charAt(j)) {
          j++;
        }
        i++;
      }
      if (j == dic.length()) {
        return dic;
      }
    }
    return "";
  }

}
