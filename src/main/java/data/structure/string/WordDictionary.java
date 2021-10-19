package data.structure.string;

/**
 * 211. 添加与搜索单词 -数据结构设计
 * <p>
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <br>
 * 1 <= word.length <= 500
 * <br>
 * addWord 中的 word 由小写英文字母组成
 * <br>
 * search 中的 word 由 ‘.’ 或小写英文字母组成 最多调用50000 次 addWord 和 search
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/19 14:33
 */
public class WordDictionary {

  private final Trie root;

  public WordDictionary() {
    root = new Trie();
  }

  public static void main(String[] args) {
    WordDictionary dictionary = new WordDictionary();
    dictionary.addWord("bad");
    dictionary.addWord("dad");
    dictionary.addWord("mad");
    //false
    System.out.println(dictionary.search("pad"));
    //false
    System.out.println(dictionary.search("bd"));
    //true
    System.out.println(dictionary.search("bad"));
    //true
    System.out.println(dictionary.search(".ad"));
    //true
    System.out.println(dictionary.search("b.."));
  }

  public void addWord(String word) {
    root.insert(word);
  }

  public boolean search(String word) {
    return dfs(word, 0, root);
  }

  private boolean dfs(String word, int index, Trie node) {
    if (index == word.length()) {
      return node.isEnd();
    }
    char ch = word.charAt(index);
    if (Character.isLetter(ch)) {
      int childIndex = ch - 'a';
      Trie child = node.getChildren()[childIndex];
      return child != null && dfs(word, index + 1, child);
    } else {
      int num = 26;
      for (int i = 0; i < num; i++) {
        Trie child = node.getChildren()[i];
        if (child != null && dfs(word, index + 1, child)) {
          return true;
        }
      }
    }
    return false;
  }
}

/**
 * 字典树（前缀树）
 * <p>存储 'a-z'26个子集</p>
 */
class Trie {

  private final Trie[] children;
  private boolean isEnd;

  public Trie() {
    this.children = new Trie[26];
    this.isEnd = false;
  }

  public void insert(String word) {
    Trie node = this;
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

  public Trie[] getChildren() {
    return children;
  }

  public boolean isEnd() {
    return this.isEnd;
  }
}
