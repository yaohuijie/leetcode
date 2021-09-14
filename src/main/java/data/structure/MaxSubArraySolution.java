package data.structure;

/**
 * 53. 最大子序和
 * <br>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/14 11:55
 */
public class MaxSubArraySolution {

  /**
   * 动态规划
   * <p>
   * 1<= nums.length <= 3 * 10e4
   * <br>
   * -10e5 <= nums[i] <= 10e5
   */
  public int maxSubArray(int[] nums) {
    if (nums.length == 1) {
      return nums[0];
    }
    int pre = 0, max = 0;
    for (int num : nums) {
      pre = Math.max(num, pre + num);
      max = Math.max(max, pre);
    }
    return max;
  }

  /**
   * 分治
   */
  public int maxSubArray1(int[] nums) {
    return getInfo(nums, 0, nums.length - 1).mSum;
  }

  public Status getInfo(int[] a, int l, int r) {
    if (l == r) {
      return new Status(a[l], a[l], a[l], a[l]);
    }
    int m = (l + r) >> 1;
    Status lSub = getInfo(a, l, m);
    Status rSub = getInfo(a, m + 1, r);
    return pushUp(lSub, rSub);
  }

  public Status pushUp(Status l, Status r) {
    int iSum = l.iSum + r.iSum;
    int lSum = Math.max(l.lSum, l.iSum + r.lSum);
    int rSum = Math.max(r.rSum, r.iSum + l.rSum);
    int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
    return new Status(lSum, rSum, mSum, iSum);
  }

  static class Status {

    public int lSum, rSum, mSum, iSum;

    public Status(int lSum, int rSum, int mSum, int iSum) {
      this.lSum = lSum;
      this.rSum = rSum;
      this.mSum = mSum;
      this.iSum = iSum;
    }
  }

}
