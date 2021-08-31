package flight;

import java.util.Arrays;

/**
 * 1109. 航班预订统计
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/8/31 14:18
 */
public class FlightSolution {

  /**
   * 遍历轮询
   *
   * @param bookings 航班预定表
   * @param n        航班数
   * @return 每个航班预订数
   */
  public int[] corpFlightBookings(int[][] bookings, int n) {

    int[] answer = new int[n];
    for (int[] booking : bookings) {
      for (int j = booking[0] - 1; j < booking[1]; j++) {
        answer[j] += booking[2];
      }
    }
    return answer;
  }

  /**
   * 差分法
   *
   * @param bookings 航班预定表
   * @param n        航班数
   * @return 每个航班预订数
   */
  public int[] corpFlightBookings1(int[][] bookings, int n) {

    int[] answer = new int[n];
    for (int[] booking : bookings) {
      answer[booking[0] - 1] += booking[2];
      if (booking[1] < n) {
        answer[booking[1]] -= booking[2];
      }
    }
    for (int i = 1; i < n; i++) {
      answer[i] += answer[i - 1];
    }
    return answer;
  }

  /**
   * 这里有n个航班，它们分别从 1 到 n 进行编号。
   * <p>
   * 有一份航班预订表bookings ，表中第i条预订记录bookings[i] = [first_i, last_i, seats_i]意味着在从 first_i到 last_i （包含
   * first_i 和 last_i ）的 每个航班 上预订了 seats_i个座位。
   * <p>
   * 请你返回一个长度为 n 的数组answer，其中 answer[i] 是航班 i 上预订的座位总数。
   */
  public static void main(String[] args) {
    FlightSolution solution = new FlightSolution();
//    int[][] bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
    int[][] bookings = new int[][]{{1, 2, 10}, {2, 2, 15}};
    System.out.println(Arrays.toString(solution.corpFlightBookings(bookings, 2)));
    System.out.println(Arrays.toString(solution.corpFlightBookings1(bookings, 2)));
  }
}
