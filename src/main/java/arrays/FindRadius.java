package arrays;

import java.util.Arrays;

/**
 * 475.供暖器
 * <p>
 * 冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。
 * <p>
 * 在加热器的加热半径范围内的每个房屋都可以获得供暖。
 * <p>
 * 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。
 * <p>
 * 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/heaters 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/20 15:16
 */
public class FindRadius {

  public static void main(String[] args) {
    FindRadius solution = new FindRadius();
    int[] houses = {1, 2, 3, 4};
    int[] heaters = {1, 4};
    System.out.println(solution.findRadius(houses, heaters));
    System.out.println(solution.findRadius1(houses, heaters));
  }

  /**
   * 排序 + 双指针
   *
   * @param houses  int[] 房子列表
   * @param heaters int[] 供暖器
   * @return int 最小半径
   */
  public int findRadius(int[] houses, int[] heaters) {
    Arrays.sort(houses);
    Arrays.sort(heaters);
    int ans = 0;
    for (int i = 0, j = 0; i < houses.length; i++) {
      int curDistance = Math.abs(houses[i] - heaters[j]);
      while (j < heaters.length - 1 && Math.abs(houses[i] - heaters[j]) >= Math.abs(
          houses[i] - heaters[j + 1])) {
        j++;
        curDistance = Math.min(curDistance, Math.abs(houses[i] - heaters[j]));
      }
      ans = Math.max(ans, curDistance);
    }
    return ans;
  }

  /**
   * 排序 + 二分法
   *
   * @param houses  int[] 房子列表
   * @param heaters int[] 供暖器
   * @return int 最小半径
   */
  public int findRadius1(int[] houses, int[] heaters) {
    int ans = 0;
    Arrays.sort(heaters);
    for (int house : houses) {
      int i = binarySearch(heaters, house);
      int j = i + 1;
      int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
      int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
      int curDistance = Math.min(leftDistance, rightDistance);
      ans = Math.max(ans, curDistance);
    }
    return ans;
  }

  private int binarySearch(int[] arr, int target) {
    int left = 0, right = arr.length - 1;
    if (arr[left] > target) {
      return -1;
    }
    while (left < right) {
      int mid = (right - left + 1) / 2 + left;
      if (arr[mid] > target) {
        right = mid - 1;
      } else {
        left = mid;
      }
    }
    return left;
  }

}
