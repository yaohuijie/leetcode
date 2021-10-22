package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 229. 求众数 Ⅱ
 * <p>
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 * <br> 1 <= nums.length <= 5 * 10e4
 * <br> -10e9 <= nums[i] <= 10e9
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/22 15:15
 */
public class MajorityElementSolution {

  public static void main(String[] args) {
    MajorityElementSolution solution = new MajorityElementSolution();
    int[] nums = {3, 2, 3};
    System.out.println(solution.majorityElement(nums));
    System.out.println(solution.majorityElement1(nums));
  }

  /**
   * hash统计
   */
  public List<Integer> majorityElement(int[] nums) {
    int n = nums.length / 3;
    Map<Integer, Integer> map = new HashMap<>(nums.length);
    for (int num : nums) {
      if (map.containsKey(num)) {
        int m = map.get(num) + 1;
        map.put(num, m);
      } else {
        map.put(num, 1);
      }
    }
    List<Integer> list = new ArrayList<>();
    map.forEach((num, m) -> {
      if (m > n) {
        list.add(num);
      }
    });
    return list;
  }

  /**
   * 摩尔投票法
   */
  public List<Integer> majorityElement1(int[] nums) {
    int element1 = 0;
    int element2 = 0;
    int vote1 = 0;
    int vote2 = 0;
    for (int num : nums) {
      if (vote1 > 0 && num == element1) {
        //如果该元素为第一个元素，则计数加 1
        vote1++;
      } else if (vote2 > 0 && num == element2) {
        //如果该元素为第二个元素，则计数加 1
        vote2++;
      } else if (vote1 == 0) {
        //选择第一个元素
        element1 = num;
        vote1++;
      } else if (vote2 == 0) {
        //选择第二个元素
        element2 = num;
        vote2++;
      } else {
        //如果三个元素均不相同，则互相抵消1次
        vote1--;
        vote2--;
      }
    }
    int cnt1 = 0;
    int cnt2 = 0;
    for (int num : nums) {
      if (vote1 > 0 && num == element1) {
        cnt1++;
      }
      if (vote2 > 0 && num == element2) {
        cnt2++;
      }
    }
    //检测元素出现的次数是否满足要求
    int a = 3;
    List<Integer> ans = new ArrayList<>();
    if (vote1 > 0 && cnt1 > nums.length / a) {
      ans.add(element1);
    }
    if (vote2 > 0 && cnt2 > nums.length / a) {
      ans.add(element2);
    }
    return ans;
  }
}
