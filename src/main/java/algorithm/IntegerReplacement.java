package algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * 397. 整数替换
 * <p>
 * 给定一个正整数n， 你可以做如下操作：
 * <p>
 * <br>1.如果n是偶数，则用 n/2 替换 n。
 * <br>2.如果n是奇数，则可以用 n+1 或 n-1 替换n。
 * <p>
 * 求：n变为1所需的最小替换次数使是多少？
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/19 14:27
 */
public class IntegerReplacement {

  /**
   * 记忆化搜索
   */
  Map<Integer, Integer> memo = new HashMap<>();

  public static void main(String[] args) {
    IntegerReplacement solution = new IntegerReplacement();
    //17
    System.out.println(solution.integerReplacement(65535));
    //14
    System.out.println(solution.integerReplacement(1234));
    System.out.println(solution.integerReplacement1(1234));
    System.out.println(solution.integerReplacement2(1234));
  }

  /**
   * 暴力
   */
  public int integerReplacement(int n) {
    if (n == 1) {
      return 0;
    }
    if (n % 2 == 0) {
      return 1 + integerReplacement(n / 2);
    }
    return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
  }

  public int integerReplacement1(int n) {
    if (n == 1) {
      return 0;
    }
    if (!memo.containsKey(n)) {
      if (n % 2 == 0) {
        memo.put(n, 1 + integerReplacement1(n / 2));
      } else {
        memo.put(n, 2 + Math.min(integerReplacement1(n / 2), integerReplacement1(n / 2 + 1)));
      }
    }
    return memo.get(n);
  }

  /**
   * 贪心
   */
  public int integerReplacement2(int n) {
    int ans = 0;
    while (n != 1) {
      if (n % 2 == 0) {
        ans++;
        n /= 2;
      } else if (n % 4 == 1) {
        ans += 2;
        n /= 2;
      } else {
        if (n == 3) {
          ans += 2;
          n = 1;
        } else {
          ans += 2;
          n = n / 2 + 1;
        }
      }

    }
    return ans;
  }
}
