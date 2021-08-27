import java.util.HashSet;
import java.util.Set;

/**
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2021/8/27 18:32
 *
 */
public class Solution {

  /**
   * 3.无重复字符的最长子串
   *   给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
   * @param s 给定字符串
   * @return  最长子串长度
   */
  public int lengthOfLongestSubstring(String s) {
    int res = 0;
    Set<Character> set = new HashSet<>();

    //定义滑动窗口左右边界 右边界初始值为-1，表示刚开始窗口还不存在
    int left = 0;
    int right = -1;
    while (left < s.length()) {
      //如果还有元素可考察，且当前考察元素在set中不存在
      //同时将当前考察元素存入set，同时扩大窗口右边界
      if (right + 1 < s.length() && !set.contains(s.charAt(right + 1))) {
        set.add(s.charAt(right + 1));
        right++;
      } else {
        //当前考察元素在set中有，需要缩小窗口左边界
        //在缩小边界时，要将对应的元素从set移除
        set.remove(s.charAt(left));
        left++;
      }
      //计算子串最大长度
      res = Math.max(res, right - left + 1);
    }

    return res;
  }

}
