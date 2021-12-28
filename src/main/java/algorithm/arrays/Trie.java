package algorithm.arrays;

/**
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2021/12/28 15:36
 */
public class Trie {

  Trie[] children;
  boolean isEnd;

  public Trie() {
    children = new Trie[26];
    isEnd = false;
  }
}
