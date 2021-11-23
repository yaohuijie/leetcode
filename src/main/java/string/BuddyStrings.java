package string;

/**
 * 859. 亲密字符串
 *
 * <p>
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/buddy-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/23 14:11
 */
public class BuddyStrings {

  public static void main(String[] args) {
    BuddyStrings solution = new BuddyStrings();
    System.out.println(solution.buddyStrings("aaabc", "aabca"));
  }

  public boolean buddyStrings(String s, String goal) {
    if (s.length() != goal.length()) {
      return false;
    }
    if (s.equalsIgnoreCase(goal)) {
      int[] count = new int[26];
      for (int i = 0; i < s.length(); i++) {
        int n = s.charAt(i) - 'a';
        count[n]++;
        if (count[n] > 1) {
          return true;
        }
      }
      return false;
    } else {
      int first = -1, second = -1;
      for (int i = 0; i < goal.length(); i++) {
        if (s.charAt(i) != goal.charAt(i)) {
          if (first == -1) {
            first = i;
          } else if (second == -1) {
            second = i;
          } else {
            return false;
          }
        }
      }
      return (second != -1 && s.charAt(first) == goal.charAt(second)
          && s.charAt(second) == goal.charAt(first));
    }

  }
}
