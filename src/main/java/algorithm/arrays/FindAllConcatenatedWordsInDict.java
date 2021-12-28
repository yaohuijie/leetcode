package algorithm.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 472.连接词
 * <p>
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * <p>
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词组成的字符串。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/concatenated-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/28 10:58
 */
public class FindAllConcatenatedWordsInDict {

  Trie trie = new Trie();

  public static void main(String[] args) {
    FindAllConcatenatedWordsInDict solution = new FindAllConcatenatedWordsInDict();
    String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat",
        "ratcatdogcat"};
    System.out.println(solution.findAllConcatenatedWordsInDict(words));
  }

  /**
   * 字典树 + 深度优先搜索
   *
   * @param words String[]
   * @return List<String>
   */
  public List<String> findAllConcatenatedWordsInDict(String[] words) {
    List<String> ans = new ArrayList<>();
    Arrays.sort(words, Comparator.comparingInt(String::length));
    for (String word : words) {
      if (word.length() == 0) {
        continue;
      }
      if (dfs(word, 0)) {
        ans.add(word);
      } else {
        insert(word);
      }
    }
    return ans;
  }

  private boolean dfs(String word, int start) {
    if (word.length() == start) {
      return true;
    }
    Trie node = trie;
    for (int i = start; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      node = node.children[index];
      if (node == null) {
        return false;
      }
      if (node.isEnd) {
        if (dfs(word, i + 1)) {
          return true;
        }
      }
    }
    return false;
  }

  private void insert(String word) {
    Trie node = trie;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      int index = ch - 'a';
      if (node.children[index] == null) {
        node.children[index] = new Trie();
      }
      node = node.children[index];
    }
    node.isEnd = true;
  }

}

