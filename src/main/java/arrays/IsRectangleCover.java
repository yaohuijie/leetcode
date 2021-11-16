package arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 391. 完美矩形
 *
 * <p>
 * 给你一个数组 rectangles ，其中 rectangles[i] = [xi, yi, ai, bi] 表示一个坐标轴平行的矩形。这个矩形的左下顶点是 (xi, yi) ，右上顶点是
 * (ai, bi) 。
 * <p>
 * 如果所有矩形一起精确覆盖了某个矩形区域，则返回 true ；否则，返回 false 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/perfect-rectangle
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/16 11:36
 */
public class IsRectangleCover {

  public static void main(String[] args) {
    IsRectangleCover solution = new IsRectangleCover();
    int[][] rectangles = {{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}};
    System.out.println(solution.isRectangleCover(rectangles));
  }

  public boolean isRectangleCover(int[][] rectangles) {
    long area = 0;
    int minX = rectangles[0][0], minY = rectangles[0][1], maxX = rectangles[0][2], maxY = rectangles[0][3];
    Map<Point, Integer> cnt = new HashMap<>();
    for (int[] rect : rectangles) {
      int x = rect[0], y = rect[1], a = rect[2], b = rect[3];
      area += (long) (a - x) * (b - y);

      minX = Math.min(minX, x);
      minY = Math.min(minY, y);
      maxX = Math.max(maxX, a);
      maxY = Math.max(maxY, b);

      Point p1 = new Point(x, y);
      Point p2 = new Point(x, b);
      Point p3 = new Point(a, y);
      Point p4 = new Point(a, b);

      cnt.put(p1, cnt.getOrDefault(p1, 0) + 1);
      cnt.put(p2, cnt.getOrDefault(p2, 0) + 1);
      cnt.put(p3, cnt.getOrDefault(p3, 0) + 1);
      cnt.put(p4, cnt.getOrDefault(p4, 0) + 1);
    }

    Point pointMinMin = new Point(minX, minY);
    Point pointMinMax = new Point(minX, maxY);
    Point pointMaxMin = new Point(maxX, minY);
    Point pointMaxMax = new Point(maxX, maxY);
    if (area != (long) (maxX - minX) * (maxY - minY) || cnt.getOrDefault(pointMinMin, 0) != 1
        || cnt.getOrDefault(pointMinMax, 0) != 1 || cnt.getOrDefault(pointMaxMin, 0) != 1
        || cnt.getOrDefault(pointMaxMax, 0) != 1) {
      return false;
    }
    cnt.remove(pointMinMin);
    cnt.remove(pointMinMax);
    cnt.remove(pointMaxMin);
    cnt.remove(pointMaxMax);

    for (Entry<Point, Integer> entry : cnt.entrySet()) {
      int val = entry.getValue();
      if (val != 2 && val != 4) {
        return false;
      }
    }
    return true;
  }

  static class Point {

    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return x + y;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Point) {
        Point p2 = (Point) obj;
        return this.x == p2.x && this.y == p2.y;
      }
      return false;
    }
  }

}
