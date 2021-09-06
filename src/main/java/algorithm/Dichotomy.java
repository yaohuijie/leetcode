package algorithm;

/**
 * 704. 二分法查找
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/6 11:02
 */
public class Dichotomy {

  /**
   * 二分查找
   *
   * @param nums   带查询数组
   * @param target 目标值
   * @return 目标值所在数组下标
   */
  public int search(int[] nums, int target) {
    int a = 0;
    int b = nums.length - 1;
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }
    while (a <= b) {
      int mid = (a + b) >> 1;
      if (nums[mid] > target) {
        b = mid - 1;
      } else if (nums[mid] == target) {
        return mid;
      } else {
        a = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1
   * <p>
   * 你可以假设 nums 中的所有元素是不重复的。 n 将在 [1, 10000]之间。 nums 的每个元素都将在 [-9999, 9999]之间。
   */
  public static void main(String[] args) {
    Dichotomy dichotomy = new Dichotomy();
    int[] nums = new int[]{-1, 0, 5};
    System.out.println(dichotomy.search(nums, -1));
  }
}
