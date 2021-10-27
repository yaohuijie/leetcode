package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. 删除无效的括号
 * <p>
 * 给你一个由 若干 括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。
 * <p>
 * 返回所有可能的结果。答案可以按 任意顺序 返回。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/27 11:11
 */
public class RemoveInvalidParenthesesSolution {

  private final List<String> list = new ArrayList<>();

  public static void main(String[] args) {
    RemoveInvalidParenthesesSolution solution = new RemoveInvalidParenthesesSolution();
    System.out.println(solution.removeInvalidParentheses("()())()"));
  }

  /**
   * 广度优先搜索
   */
  public List<String> removeInvalidParentheses(String s) {
    List<String> ans = new ArrayList<>();
    Set<String> currSet = new HashSet<>();
    currSet.add(s);
    while (true) {
      for (String str : currSet) {
        if (isValid(str)) {
          ans.add(str);
        }
      }
      if (ans.size() > 0) {
        return ans;
      }
      Set<String> nextSet = new HashSet<>();
      for (String str : currSet) {
        for (int i = 0; i < str.length(); i++) {
          if (i > 0 && str.charAt(i) == str.charAt(i - 1)) {
            continue;
          }
          if (str.charAt(i) == '(' || str.charAt(i) == ')') {
            nextSet.add(str.substring(0, i) + str.substring(i + 1));
          }
        }
      }
      currSet = nextSet;
    }
  }


  private boolean isValid(String str) {
    int cnt = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') {
        cnt++;
      } else if (str.charAt(i) == ')') {
        cnt--;
        if (cnt < 0) {
          return false;
        }
      }
    }
    return cnt == 0;
  }
}
