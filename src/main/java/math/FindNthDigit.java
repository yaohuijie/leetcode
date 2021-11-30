package math;

/**
 * 400.第 N 位数字
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/30 18:11
 */
public class FindNthDigit {

  public static void main(String[] args) {
    FindNthDigit solution = new FindNthDigit();
    System.out.println(solution.findNthDigit(11));
  }

  public int findNthDigit(int n) {
    int d = 1, count = 9;
    while (n > (long) d * count) {
      n -= d * count;
      d++;
      count *= 10;
    }
    int index = n - 1;
    int start = (int) Math.pow(10, d - 1);
    int num = start + index / d;
    int digitIndex = index % d;
    return (num / (int) (Math.pow(10, d - digitIndex - 1))) % 10;
  }
}
