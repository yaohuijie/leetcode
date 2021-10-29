package geometry;

/**
 * 335. 路径交叉
 *
 * <p>
 * 给你一个整数数组 distance 。
 * <p>
 * 从 X-Y 平面上的点(0,0)开始，先向北移动 distance[0] 米，然后向西移动 distance[1] 米，向南移动 distance[2] 米，向东移动 distance[3]
 * 米，持续移动。也就是说，每次移动后你的方位会发生逆时针变化。
 * <p>
 * 判断你所经过的路径是否相交。如果相交，返回 true ；否则，返回 false 。
 *
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/29 11:03
 */
public class IsSelfCrossingSolution {

  public static void main(String[] args) {
    IsSelfCrossingSolution solution = new IsSelfCrossingSolution();
    int[] distance = {1, 1, 2, 2, 1, 1};
    System.out.println(solution.isSelfCrossing(distance));
    System.out.println(solution.isSelfCrossing1(distance));
  }

  /**
   * <br>            i-2
   * <br> case 1 : i-1┌─┐
   * <br>             └─┼─>i
   * <br>              i-3
   *
   * <br>                 i-2
   * <br>  case 2 : i-1 ┌────┐
   * <br>               └─══>┘i-3
   * <br>              i  i-4      (i overlapped i-4)
   *
   * <br>case 3 :    i-4
   * <br>           ┌──┐
   * <br>           │i<┼─┐
   * <br>        i-3│ i-5│i-1
   * <br>           └────┘
   * <br>            i-2
   */
  public boolean isSelfCrossing(int[] distance) {

    for (int i = 3; i < distance.length; i++) {
      //第 1 类路径交叉的情况
      if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
        return true;
      }
      //第 2 类路径交叉的情况
      if (i == 4 && (distance[3] == distance[1]) && distance[4] >= distance[2] - distance[0]) {
        return true;
      }
      //第 3 类路径交叉的情况
      if (i >= 5 && (distance[i - 3] - distance[i - 5] <= distance[i - 1]
          && distance[i - 1] <= distance[i - 3]
          && distance[i] >= distance[i - 2] - distance[i - 4]
          && distance[i - 2] > distance[i - 4])) {
        return true;
      }

    }
    return false;
  }

  /**
   * 归纳（路径不交叉）
   */
  public boolean isSelfCrossing1(int[] distance) {
    int n = distance.length;
    //处理第 1 种情况（第i次移动都比第i-2次移动距离长）
    int i = 0;
    while (i < n && (i < 2 || distance[i] > distance[i - 2])) {
      i++;
    }
    if (i == n) {
      return false;
    }
    //处理 j 次移动的情况
    if ((i == 3 && distance[i] == distance[i - 2]) || (i >= 4
        && distance[i] >= distance[i - 2] - distance[i - 4])) {
      distance[i - 1] -= distance[i - 3];
    }
    i++;
    // 处理第 2 种情况（第i次移动都比第i-2次移动距离短）
    while (i < n && distance[i] < distance[i - 2]) {
      i++;
    }
    return i != n;
  }
}
