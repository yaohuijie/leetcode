package arrays;

/**
 * 剑指OfferⅡ 069.山峰数组的顶部
 * <p>
 * 符合下列属性的数组 arr 称为 山峰数组（山脉数组） ：
 *
 * <br>arr.length >= 3
 * <br>存在 i（0 < i < arr.length - 1）使得：
 * <br>arr[0] < arr[1] < ... arr[i-1] < arr[i]
 * <br>arr[i] > arr[i+1] > ... > arr[arr.length - 1]
 * <br>给定由整数组成的山峰数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... >
 * arr[arr.length - 1] 的下标 i ，即山峰顶部。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/14 14:12
 */
public class PeakIndexMountainArraySolution {

  public static void main(String[] args) {
    PeakIndexMountainArraySolution solution = new PeakIndexMountainArraySolution();
    int[] arr = new int[]{0, 10, 5, 2};
    System.out.println(solution.peakIndexInMountainArray(arr));
  }

  public int peakIndexInMountainArray(int[] arr) {
    int m = arr[0];
    for (int i = 1; i < arr.length; i++) {
      if (m > arr[i]) {
        return i;
      } else {
        m = arr[i];
      }
    }
    return -1;
  }

}
