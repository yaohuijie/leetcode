package string;

import java.util.Random;

/**
 * 686.重复叠加字符串匹配
 *
 * <p>
 * 给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。
 * <p>
 * 注意：字符串 "abc"重复叠加 0 次是 ""，重复叠加 1 次是"abc"，重复叠加 2 次是"abcabc"。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/repeated-string-match
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/22 14:44
 */
public class RepeatedStringMatch {

  public static void main(String[] args) {
    RepeatedStringMatch solution = new RepeatedStringMatch();
    System.out.println(solution.repeatedStringMatch("abcd", "cdabcdab"));
    System.out.println(solution.repeatedStringMatch1("abcd", "cdabcdab"));
  }

  /**
   * Rabin-Karp 算法
   *
   * @param a string
   * @param b string
   * @return int
   */
  public int repeatedStringMatch1(String a, String b) {
    int an = a.length(), bn = b.length();
    int index = rabinKarp(a, b);
    if (index == -1) {
      return -1;
    }
    if (an - index >= bn) {
      return 1;
    }
    return (bn + index - an - 1) / an + 2;
  }

  private int rabinKarp(String haystack, String needle) {
    int n = haystack.length(), m = needle.length();
    if (m == 0) {
      return 0;
    }
    int k1 = 1000000009;
    int k2 = 1337;
    Random random = new Random();
    int kMod1 = random.nextInt(k1) + k1;
    int kMod2 = random.nextInt(k2) + k2;

    long hashNeedle = 0;
    for (int i = 0; i < m; i++) {
      char c = needle.charAt(i);
      hashNeedle = (hashNeedle * kMod2 + c) % kMod1;
    }
    long hashHaystack = 0, extra = 1;
    for (int i = 0; i < m - 1; i++) {
      hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
      extra = (extra * kMod2) % kMod1;
    }
    for (int i = m - 1; (i - m + 1) < n; i++) {
      hashHaystack = (hashHaystack * kMod2 + haystack.charAt(i % n)) % kMod1;
      if (hashHaystack == hashNeedle) {
        return i - m + 1;
      }
      hashHaystack = (hashHaystack - extra * haystack.charAt((i - m + 1) % n)) % kMod1;
      hashHaystack = (hashHaystack + kMod1) % kMod1;
    }
    return -1;
  }

  /**
   * Knuth-Morris-Pratt 算法
   *
   * @param a string
   * @param b string
   * @return int
   */
  public int repeatedStringMatch(String a, String b) {
    int an = a.length(), bn = b.length();
    int index = knuthMorrisPratt(a, b);
    if (index == -1) {
      return -1;
    }
    if (an - index >= bn) {
      return 1;
    }
    return (bn + index - an - 1) / an + 2;
  }

  private int knuthMorrisPratt(String a, String b) {
    int n = a.length(), m = b.length();
    if (m == 0) {
      return -1;
    }
    int[] pi = new int[m];
    for (int i = 1, j = 0; i < m; i++) {
      while (j > 0 && b.charAt(i) != b.charAt(j)) {
        j = pi[j - 1];
      }
      if (b.charAt(i) == b.charAt(j)) {
        j++;
      }
      pi[i] = j;
    }
    //b 开始匹配的位置是否超过第一个叠加的 a
    for (int i = 0, j = 0; i - j < n; i++) {
      // a是循环叠加的字符串，所以取 i % n
      while (j > 0 && a.charAt(i % n) != b.charAt(j)) {
        j = pi[j - 1];
      }
      if (a.charAt(i % n) == b.charAt(j)) {
        j++;
      }
      if (j == m) {
        return i - m + 1;
      }
    }
    return -1;
  }

}
