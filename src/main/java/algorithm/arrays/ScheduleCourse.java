package algorithm.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 630.课程表Ⅲ
 * <p>
 * 这里有 n 门不同的在线课程，按从 1 到 n 编号。给你一个数组 courses ，其中 courses[i] = [duration, lastDay] 表示第 i 门课将会 持续 上
 * duration 天课，并且必须在不晚于 lastDay 的时候完成。
 * <p>
 * 你的学期从第 1 天开始。且不能同时修读两门及两门以上的课程。
 * <p>
 * 返回你最多可以修读的课程数目。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/course-schedule-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/14 11:30
 */
public class ScheduleCourse {


  public static void main(String[] args) {
    ScheduleCourse solution = new ScheduleCourse();
    //result = 3
    int[][] courses = {{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
    System.out.println(solution.scheduleCourse(courses));
  }

  public int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, Comparator.comparingInt(arr -> arr[1]));
    PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
    int sum = 0;
    for (int[] cour : courses) {
      int ti = cour[0], di = cour[1];
      if (sum + ti <= di) {
        sum += ti;
        q.offer(ti);
      } else if (!q.isEmpty() && q.peek() > ti) {
        sum -= q.poll() - ti;
        q.offer(ti);
      }
    }
    return q.size();
  }
}
