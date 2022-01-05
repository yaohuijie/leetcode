package string;

/**
 * 1576.替换所有的问号
 * <p>
 * 给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
 * <p>
 * 注意：你 不能 修改非 '?' 字符。
 * <p>
 * 题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。
 * <p>
 * 在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/replace-all-s-to-avoid-consecutive-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2022/1/5 11:20
 */
public class ModifyString {

  public static void main(String[] args) {
    ModifyString solution = new ModifyString();
    System.out.println(solution.modifyString("??yw?ipkj?"));
  }

  public String modifyString(String s) {
    if (s == null || s.isEmpty()) {
      return s;
    }
    if ("?".equalsIgnoreCase(s)) {
      return "a";
    }
    StringBuilder sb = new StringBuilder();
    char pre = (char) ('a' - 1);
    for (int i = 0; i < s.length(); i++) {
      char index = s.charAt(i);
      if (index == '?') {
        if (i == s.length() - 1) {
          index = setNewChar(pre, (char) ('z' - 1));
        } else {
          index = setNewChar(pre, s.charAt(i + 1));
        }
      }
      pre = index;
      sb.append(index);
    }
    return sb.toString();
  }

  private char setNewChar(char a, char c) {
    char b = 'a';
    while (a == b || b == c) {
      b++;
    }
    return b;
  }

}
