package string;

/**
 * 639. 解码方法Ⅱ
 *
 * <p>
 * 给你一个字符串 s ，由数字和 '*' 字符组成，返回 解码 该字符串的方法 数目 。 编码消息中可能包含 '*' 字符，可以表示从 '1' 到 '9' 的任一个数字（不包括 '0')
 * <p>
 * 由于答案数目可能非常大，返回对 109 + 7 取余 的结果。 1-26 对应 ‘A-Z’
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/27 16:21
 */
public class NumDecodingsSolution {

  private final char zero = '0';
  private final char star = '*';

  public static void main(String[] args) {
    NumDecodingsSolution solution = new NumDecodingsSolution();
    System.out.println(solution.numDecoding("*"));
  }

  public int numDecoding(String s) {
    int max = 1000000007;
    int n = s.length();
    // a= f[i-2], b=f[i-1], c=f[i]
    long a = 0, b = 1, c = 0;
    for (int i = 1; i <= n; i++) {
      c = b * check1digit(s.charAt(i - 1)) % max;
      if (i > 1) {
        c = (c + a * check2digits(s.charAt(i - 2), s.charAt(i - 1))) % max;
      }
      a = b;
      b = c;
    }
    return (int) c;
  }

  public int check1digit(char ch) {
    if (ch == zero) {
      return 0;
    }
    return ch == star ? 9 : 1;
  }

  public int check2digits(char c1, char c2) {
    if (c1 == star && c2 == star) {
      return 15;
    }
    if (c1 == star) {
      return c2 <= '6' ? 2 : 1;
    }
    if (c2 == star) {
      char one = '1';
      if (c1 == one) {
        return 9;
      }
      char two = '2';
      if (c1 == two) {
        return 6;
      }
      return 0;
    }
    return (c1 != zero && (c1 - '0') * 10 + (c2 - '0') <= 26) ? 1 : 0;
  }

}
