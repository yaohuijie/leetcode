package math;

/**
 * 598.范围求和
 * <p>
 * 给定一个初始元素全部为0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。
 * <p>
 * 操作用二维数组表示，其中的每个操作用一个含有两个正整数a 和 b 的数组表示，含义是将所有符合0 <= i < a 以及 0 <= j < b 的元素M[i][j]的值都增加 1。
 * <p>
 * 在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/range-addition-ii
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/8 17:23
 */
public class MaxCount {


  public static void main(String[] args) {
    MaxCount solution = new MaxCount();
    int[][] ops = {{2, 2}, {3, 3}};
    System.out.println(solution.maxCount(3, 3, ops));
  }

  public int maxCount(int m, int n, int[][] ops) {
    int minA = m, minB = n;
    for (int[] op : ops) {
      minA = Math.min(op[0], minA);
      minB = Math.min(op[1], minB);
    }
    return minA * minB;
  }
}
