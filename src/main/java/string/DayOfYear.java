package string;

/**
 * 1154. 一年中的第几天
 *
 * <p>
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。请你计算并返回该日期是当年的第几天。
 * <p>
 * 通常情况下，我们认为 1 月 1 日是每年的第 1 天，1 月 2 日是每年的第 2 天，依此类推。每个月的天数与现行公元纪年法（格里高利历）一致。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/day-of-the-year
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/21 14:55
 */
public class DayOfYear {

  public static void main(String[] args) {
    DayOfYear solution = new DayOfYear();
    System.out.println(solution.dayOfYear("2004-03-01"));
  }

  public int dayOfYear(String date) {
    String[] split = date.split("-");
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int sum = Integer.parseInt(split[2]);
    int year = Integer.parseInt(split[0]);
    int moon = Integer.parseInt(split[1]);
    int run = 2;
    boolean flag = year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    if (flag && moon > run) {
      sum++;
    }
    for (int i = 1; i < moon; i++) {
      sum += days[i - 1];
    }
    return sum;
  }

}
