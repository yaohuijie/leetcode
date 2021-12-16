package math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1610.可见点的最大数目
 * <p>
 * 给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi,
 * yi] 都表示 X-Y 平面上的整数坐标。
 * <p>
 * 最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示，
 * 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
 * <p>
 * 对于每个点，如果由该点、你的位置以及从你的位置直接向东的方向形成的角度 位于你的视野中 ，那么你就可以看到它。
 * <p>
 * 同一个坐标上可以有多个点。你所在的位置也可能存在一些点，但不管你的怎么旋转，总是可以看到这些点。同时，点不会阻碍你看到其他点。
 * <p>
 * 返回你能看到的点的最大数目。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximum-number-of-visible-points
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/16 11:38
 */
public class VisiblePoints {

  public static void main(String[] args) {
    VisiblePoints solution = new VisiblePoints();
    List<List<Integer>> points = new ArrayList<>();
    List<Integer> point = new ArrayList<>();
    List<Integer> point1 = new ArrayList<>();
    List<Integer> point2 = new ArrayList<>();
    List<Integer> location = new ArrayList<>();
    point.add(2);
    point.add(1);
    point1.add(2);
    point1.add(2);
    point2.add(3);
    point2.add(4);
    location.add(1);
    location.add(1);
    points.add(point);
    points.add(point1);
    points.add(point2);
    System.out.println(solution.visiblePoints(points, 90, location));
  }

  public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
    int sameCnt = 0;
    List<Double> polarDegrees = new ArrayList<>();
    int locationX = location.get(0);
    int locationY = location.get(1);
    for (List<Integer> point : points) {
      int x = point.get(0);
      int y = point.get(1);
      if (x == locationX && y == locationY) {
        sameCnt++;
        continue;
      }
      Double degree = Math.atan2(y - locationY, x - locationX);
      polarDegrees.add(degree);
    }
    Collections.sort(polarDegrees);
    int m = polarDegrees.size();
    for (int i = 0; i < m; i++) {
      polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
    }
    int maxCnt = 0;
    Double toDegree = angle * Math.PI / 180;
    for (int i = 0; i < m; i++) {
      int iteration = binarySearch(polarDegrees, polarDegrees.get(i) + toDegree);
      maxCnt = Math.max(maxCnt, iteration - i);
    }
    return sameCnt + maxCnt;
  }

  private int binarySearch(List<Double> arr, Double target) {
    int left = 0, right = arr.size() - 1;
    int ans = arr.size();
    while (left <= right) {
      int mid = (left + right) >> 1;
      if (arr.get(mid) > target) {
        right = mid - 1;
        ans = mid;
      } else {
        left = mid + 1;
      }
    }
    return ans;
  }
}
