package string;

/**
 * 1221. 分割平衡字符串
 *
 * 在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
 * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
 * 注意：分割得到的每个字符串都必须是平衡字符串。
 * 返回可以通过分割得到的平衡字符串的 最大数量 。
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/7 11:41
 */
public class SplitSolution {

  /**
   * 1 <= s.length <= 1000
   * s[i] = 'L' 或 'R'
   * s 是一个 平衡 字符串
   *
   * @param s 待拆分字符串
   * @return  拆分数量
   */
  public int balancedStringSplit(String s) {
    int num = 0, d = 0;
    for (char c : s.toCharArray()) {
      if (c == 'L') {
        ++d;
      } else {
        --d;
      }
      if (d == 0) {
        num ++;
      }
    }
    return num;
  }

  /**
   *在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
   *
   * 给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
   *
   * 注意：分割得到的每个字符串都必须是平衡字符串。
   *
   * 返回可以通过分割得到的平衡字符串的 最大数量 。
   *
   */
  public static void main(String[] args) {
    SplitSolution solution = new SplitSolution();
    System.out.println(solution.balancedStringSplit("RLRRLLRLRL"));
  }

}
