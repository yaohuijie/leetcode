package student;

import java.util.Arrays;

/**
 * 1894. 找到需要补充粉笔的学生编号
 * <p>
 * 一个班级里有n个学生，编号为 0到 n - 1。每个学生会依次回答问题，编号为 0的学生先回答，然后是编号为 1的学生，以此类推，直到编号为 n -
 * 1的学生，然后老师会重复这个过程，重新从编号为 0的学生开始回答问题。
 * <p>
 * 给你一个长度为 n且下标从 0开始的整数数组chalk和一个整数k。一开始粉笔盒里总共有k支粉笔。当编号为i的学生回答问题时，他会消耗 chalk[i]支粉笔。如果剩余粉笔数量
 * 严格小于chalk[i]，那么学生 i需要 补充 粉笔。
 * <p>
 * 请你返回需要 补充粉笔的学生 编号
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/10 11:43
 */
public class ChalkReplacerSolution {

  /**
   * chalk.length == n 1 <= n <= 10e5 1 <= chalk[i] <= 10e5 1 <= k <= 10e9
   *
   * @return 需要补充粉笔的学生编号
   */
  public int chalkReplacer(int[] chalk, int k) {
    if (chalk.length == 1) {
      return 0;
    }
    //数组很大时，会超出int上限，所以用long
    long sum = 0;
    for (int i : chalk) {
      sum += i;
    }
    k = Math.toIntExact(k % sum);
    for (int i = 0; i < chalk.length; i++) {
      k -= chalk[i];
      if (k < 0) {
        return i;
      }
    }
    return -1;
  }

  /**
   * 二分法
   */
  public int chalkReplacer1(int[] chalk, int k) {
    int n = chalk.length;
    if (chalk[0] > k) {
      return 0;
    }
    for (int i = 1; i < n; i++) {
      chalk[i] += chalk[i - 1];
      if (chalk[i] > k) {
        return i;
      }
    }
    k %= chalk[n - 1];
    return binarySearch(chalk, k);
  }

  public int binarySearch(int[] arr, int target) {
    int low = 0, high = arr.length - 1;
    while (low < high) {
      int mid = (high + low) / 2 + low;
      if (arr[mid] <= target) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    ChalkReplacerSolution solution = new ChalkReplacerSolution();
    int[] chalk = new int[]{3, 4, 1, 2};
    int i = solution.chalkReplacer(chalk, 100000003);
    System.out.println(i);
    System.out.println(solution.chalkReplacer1(chalk, 1234));
  }

}
