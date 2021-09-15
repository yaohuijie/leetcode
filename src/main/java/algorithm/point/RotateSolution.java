package algorithm.point;

/**
 * 189. 旋转数组
 * <p>
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/15 14:45
 */
public class RotateSolution {

  /**
   * 额外数组
   */
  public void rotate(int[] nums, int k) {
    int len = nums.length;
    int[] arr = new int[len];
    for (int i = 0; i < len; i++) {
      arr[(i + k) % len] = nums[i];
    }
    System.arraycopy(arr, 0, nums, 0, len);
  }

  /**
   * 环状替换
   */
  public void rotate1(int[] nums, int k) {
    int len = nums.length;
    k = k % len;
    int count = gcd(k, len);
    for (int i = 0; i < count; i++) {
      int current = i;
      int prev = nums[i];
      do {
        int next = (current + k) % len;
        int temp = nums[next];
        nums[next] = prev;
        prev = temp;
        current = next;
      } while (i != current);
    }
  }

  public int gcd(int x, int y) {
    return y > 0 ? gcd(y, x % y) : x;
  }

  /**
   * 数组翻转
   */
  public void rotate2(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }

  public void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }
}
