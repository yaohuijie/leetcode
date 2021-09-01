package version;

/**
 * 165. 比较版本号
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/1 12:02
 */
public class Solution {

  /**
   * 字符串分割
   *
   * @param version1 版本1
   * @param version2 版本2
   * @return 版本1>版本2 return 1 版本1>版本2 return -1 else return 0
   */
  public int compareVersion(String version1, String version2) {
    String[] split1 = version1.split("\\.");
    String[] split2 = version2.split("\\.");
    int max = Math.max(split1.length, split2.length);
    for (int i = 0; i < max; i++) {
      int a = 0;
      if (i < split1.length) {
        a = new Integer(split1[i]);
      }
      int b = 0;
      if (i < split2.length) {
        b = new Integer(split2[i]);
      }
      if (a > b) {
        return 1;
      }
      if (a < b) {
        return -1;
      }
    }
    return 0;
  }

  /**
   * 双指针
   *
   * @param version1 版本1
   * @param version2 版本2
   * @return 版本1>版本2 return 1 版本1>版本2 return -1 else return 0
   */
  public int compareVersion1(String version1, String version2) {
    int n = version1.length();
    int m = version2.length();
    char d = '.';
    int i = 0, j = 0;
    while (i < n || j < m) {
      int x = 0;
      for (; i < n && version1.charAt(i) != d; ++i) {
        x = x * 10 + version1.charAt(i) - '0';
      }
      ++i;
      int y = 0;
      for (; j < m && version2.charAt(j) != d; ++j) {
        y = y * 10 + version2.charAt(j) - '0';
      }
      ++j;
      if (x != y) {
        return x > y ? 1 : -1;
      }
    }
    return 0;
  }

  /**
   * 给你两个版本号 version1 和 version2 ，请你比较它们。 返回规则如下：
   * <p>
   * 如果 version1 > version2 返回 1， 如果 version1 < version2 返回 -1， 除此之外返回 0。
   */
  public static void main(String[] args) {
    Solution so = new Solution();
    System.out.println(so.compareVersion1("7.5.2.4", "7.5.2"));
  }

}
