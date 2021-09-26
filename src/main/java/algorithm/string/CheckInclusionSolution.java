package algorithm.string;

/**
 * 567. 字符串的排列
 * <p>
 * 给你两个字符串s1 和 s2，写一个函数来判断s2是否包含s1的排列。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2021/9/26 14:39
 */
public class CheckInclusionSolution {

  /**
   * 滑动窗口
   */
  public boolean checkInclusion(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    if (n > m) {
      return false;
    }
    int[] cnt = new int[26];
    for (int i = 0; i < n; i++) {
      cnt[s1.charAt(i) - 'a']--;
      cnt[s2.charAt(i) - 'a']++;
    }
    int diff = 0;
    for (int c : cnt) {
      if (c != 0) {
        diff++;
      }
    }
    if (diff == 0) {
      return true;
    }
    for (int i = n; i < m; i++) {
      int x = s2.charAt(i) - 'a', y = s2.charAt(i - n) - 'a';
      if (x == y) {
        continue;
      }
      if (cnt[x] == 0) {
        diff++;
      }
      cnt[x]++;
      if (cnt[x] == 0) {
        diff--;
      }
      if (cnt[y] == 0) {
        diff++;
      }
      cnt[y]--;
      if (cnt[y] == 0) {
        diff--;
      }
      if (diff == 0) {
        return true;
      }
    }
    return false;
  }

  /**
   * 双指针
   */
  public boolean checkInclusion1(String s1, String s2) {
    int n = s1.length(), m = s2.length();
    if (n > m) {
      return false;
    }
    int[] cnt = new int[26];
    for (int i = 0; i < n; i++) {
      cnt[s1.charAt(i) - 'a']--;
    }
    int left = 0;
    for (int right = 0; right < m; right++) {
      int x = s2.charAt(right) - 'a';
      cnt[x]++;
      while (cnt[x] > 0) {
        cnt[s2.charAt(left) - 'a']--;
        left++;
      }
      if ((right - left + 1) == n) {
        return true;
      }
    }
    return false;
  }

}
