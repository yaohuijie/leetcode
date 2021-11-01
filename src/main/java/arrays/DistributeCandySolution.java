package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * 575. 分糖果
 *
 * <p>
 * Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。
 * <p>
 * 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到最多不同种类的糖。
 * <p>
 * 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的最多种类数。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/1 20:36
 */
public class DistributeCandySolution {

  public static void main(String[] args) {
    DistributeCandySolution solution = new DistributeCandySolution();
    int[] candyType = {1, 1, 2, 2, 3, 3};
    System.out.println(solution.distributeCandies(candyType));
  }

  public int distributeCandies(int[] candyType) {
    int num = candyType.length / 2;
    Set<Integer> set = new HashSet<>(candyType.length);
    for (int i : candyType) {
      set.add(i);
    }
    return Math.min(num, set.size());
  }
}
