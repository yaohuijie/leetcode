package arrays;

/**
 * 747.至少是其他数字两倍的最大数
 * <p>
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/largest-number-at-least-twice-of-others
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2022/1/13 16:47
 */
public class DominantIndex {

  public static void main(String[] args) {
    DominantIndex solution = new DominantIndex();
    int[] arr = {3, 6, 1, 0};
    System.out.println(solution.dominantIndex(arr));
  }

  public int dominantIndex(int[] arr) {
    if (arr.length < 2) {
      return 0;
    }
    int max = arr[0], maxD = 0, index = 0;
    for (int i = 1; i < arr.length; i++) {
      if (max > arr[i]) {
        maxD = Math.max(maxD, arr[i] * 2);
      } else {
        maxD = Math.max(maxD, max * 2);
        max = arr[i];
        index = i;
      }
    }
    return max >= maxD ? index : -1;
  }

}
