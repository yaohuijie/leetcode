package arrays;

/**
 * 334.递增的三元子序列
 * <p>
 * 给你一个整数数组 arr ，判断这个数组中是否存在长度为 3 的递增子序列。
 * <p>
 * 如果存在这样的三元组下标 (i, j, k)且满足 i < j < k，使得arr[i] < arr[j] < arr[k]，返回 true ；否则，返回 false。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2022/1/12 14:26
 */
public class IncreasingTriplet {

  public static void main(String[] args) {
    IncreasingTriplet solution = new IncreasingTriplet();
    int[] arr = {0, -1, 0, 0, 1000000};
    System.out.println(solution.increasingTriplet(arr));
    System.out.println(solution.increasingTriplet1(arr));
  }

  /**
   * 双向遍历
   *
   * @param arr int[] 需要校验的数组
   * @return boolean
   */
  public boolean increasingTriplet(int[] arr) {
    int len = arr.length;
    if (len < 3) {
      return false;
    }
    int[] leftMin = new int[len];
    leftMin[0] = arr[0];
    for (int i = 1; i < len; i++) {
      leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
    }
    int[] rightMax = new int[len];
    rightMax[len - 1] = arr[len - 1];
    for (int i = len - 2; i >= 0; i--) {
      rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
    }
    for (int i = 1; i < len - 1; i++) {
      if (arr[i] > leftMin[i - 1] && arr[i] < rightMax[i + 1]) {
        return true;
      }
    }
    return false;
  }

  /**
   * 贪心算法
   *
   * @param arr int[] 需要校验的数组
   * @return boolean
   */
  public boolean increasingTriplet1(int[] arr) {
    int len = arr.length;
    if (len < 3) {
      return false;
    }
    int first = arr[0], second = Integer.MAX_VALUE;
    for (int i = 1; i < len; i++) {
      int num = arr[i];
      if (num > second) {
        return true;
      } else if (num > first) {
        second = num;
      } else {
        first = num;
      }
    }
    return false;
  }

}
