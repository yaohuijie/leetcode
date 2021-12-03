package algorithm.arrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 1005. k次取反后最大化的数组和
 *
 * <p>
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/maximize-sum-of-array-after-k-negations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/3 11:12
 */
public class LargestSumAfterKNegations {

  public static void main(String[] args) {
    LargestSumAfterKNegations solution = new LargestSumAfterKNegations();
    int[] arr = {2, -3, -1, 5, -4};
    System.out.println(solution.largestSumAfterKNegations(arr, 2));
  }

  public int largestSumAfterKNegations(int[] nums, int k) {
    int min = Math.abs(nums[0]), sum = 0;
    List<Integer> list = new ArrayList<>(100);
    for (int num : nums) {
      min = Math.min(Math.abs(num), min);
      if (num < 0) {
        list.add(num);
      } else {
        sum += num;
      }
    }
    if (!list.isEmpty()) {
      list.sort(Comparator.comparingInt(a -> a));
      for (Integer n : list) {
        if (k > 0) {
          sum -= n;
          k--;
        } else {
          sum += n;
        }

      }
    }
    if (k > 0) {
      if (k % 2 != 0) {
        sum = sum - min - min;
      }
    }
    return sum;
  }

}
