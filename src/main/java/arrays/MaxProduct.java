package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 318. 最大单词长度乘积
 *
 * <p>
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回
 * 0。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/17 11:20
 */
public class MaxProduct {

  public static void main(String[] args) {
    MaxProduct solution = new MaxProduct();
    String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
    System.out.println(solution.maxProduct(words));
  }

  public int maxProduct(String[] words) {
    Map<Integer, Integer> map = new HashMap<>(words.length);
    for (String word : words) {
      int mask = 0;
      int wordLen = word.length();
      for (int j = 0; j < wordLen; j++) {
        mask |= 1 << (word.charAt(j) - 'a');
      }
      if (wordLen > map.getOrDefault(mask, 0)) {
        map.put(mask, wordLen);
      }
    }
    int max = 0;
    Set<Integer> maskSet = map.keySet();
    for (Integer m1 : maskSet) {
      int wordLen1 = map.get(m1);
      for (Integer m2 : maskSet) {
        if ((m1 & m2) == 0) {
          int wordLen2 = map.get(m2);
          max = Math.max(max, wordLen2 * wordLen1);
        }
      }
    }
    return max;
  }

}
