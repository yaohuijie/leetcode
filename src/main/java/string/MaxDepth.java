package string;

/**
 * 1614.括号的最大嵌套深度
 * <p>
 * 如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：
 *
 * <hr>字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
 * <hr>字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
 * <hr>字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
 * <hr>类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：
 *
 * <hr>depth("") = 0
 * <hr>depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
 * <hr>depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
 * <hr>depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
 * <hr>例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。
 * <p>
 * 给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-nesting-depth-of-the-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2022/1/7 16:45
 */
public class MaxDepth {

  public static void main(String[] args) {
    MaxDepth solution = new MaxDepth();
    System.out.println(solution.maxDepth("(1+(2*3)+((8)/4))+1"));
  }

  public int maxDepth(String s) {
    if (s == null || s.isEmpty()) {
      return 0;
    }
    int depth = 0, num = 0;
    for (int i = 0; i < s.length(); i++) {
      char index = s.charAt(i);
      if ('(' == index) {
        num++;
      }
      if (')' == index) {
        num--;
      }
      depth = Math.max(depth, num);

    }
    return depth;
  }

}
