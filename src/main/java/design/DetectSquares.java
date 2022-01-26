package design;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 2013.检测正方形
 * <p>
 * 给你一个在 X-Y 平面上的点构成的数据流。设计一个满足下述要求的算法：
 *
 * <br>1.添加 一个在数据流中的新点到某个数据结构中。可以添加 重复 的点，并会视作不同的点进行处理。
 * <br>2.给你一个查询点，请你从数据结构中选出三个点，使这三个点和查询点一同构成一个 面积为正 的 轴对齐正方形 ，统计 满足该要求的方案数目。
 * <p>
 * 轴对齐正方形 是一个正方形，除四条边长度相同外，还满足每条边都与 x-轴 或 y-轴 平行或垂直。
 * <p>
 * 实现 DetectSquares 类：
 *
 * <br>1.DetectSquares() 使用空数据结构初始化对象
 * <br>2.void add(int[] point) 向数据结构添加一个新的点 point = [x, y]
 * <br>3.int count(int[] point) 统计按上述方式与点 point = [x, y] 共同构造 轴对齐正方形 的方案数。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/detect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2022/1/26 16:34
 */
public class DetectSquares {

  Map<Integer, Map<Integer, Integer>> cnt;

  public DetectSquares() {
    cnt = new HashMap<>();
  }

  public static void main(String[] args) {
    DetectSquares detectSquares = new DetectSquares();
    detectSquares.add(new int[]{3, 10});
    detectSquares.add(new int[]{11, 2});
    detectSquares.add(new int[]{3, 2});
    //result 1
    System.out.println(detectSquares.count(new int[]{11, 10}));
    //result 0
    System.out.println(detectSquares.count(new int[]{14, 8}));
    detectSquares.add(new int[]{11, 2});
    //result 2
    System.out.println(detectSquares.count(new int[]{11, 10}));
  }

  public void add(int[] point) {
    int x = point[0], y = point[1];
    cnt.putIfAbsent(y, new HashMap<>());
    Map<Integer, Integer> yCnt = cnt.get(y);
    yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
  }

  public int count(int[] point) {
    int res = 0;
    int x = point[0], y = point[1];
    if (!cnt.containsKey(y)) {
      return 0;
    }
    Map<Integer, Integer> yCnt = cnt.get(y);
    Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
    for (Entry<Integer, Map<Integer, Integer>> entry : entries) {
      int col = entry.getKey();
      Map<Integer, Integer> colCnt = entry.getValue();
      if (col != y) {
        int d = col - y;
        res +=
            colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);
        res +=
            colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
      }
    }
    return res;
  }
}
