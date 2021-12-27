package arrays;

import java.util.Arrays;

/**
 * 825.适龄的朋友
 * <p>
 * 在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。
 * <p>
 * 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求：
 * <p>
 * <br>· age[y] <= 0.5 * age[x] + 7
 * <br>· age[y] > age[x]
 * <br>· age[y] > 100 && age[x] < 100
 * <br>否则，x 将会向 y 发送一条好友请求。
 * <p>
 * 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。
 * <p>
 * 返回在该社交媒体网站上产生的好友请求总数。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/friends-of-appropriate-ages
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2021/12/27 16:54
 */
public class NumFriendRequests {

  public static void main(String[] args) {
    NumFriendRequests solution = new NumFriendRequests();
    int[] ages = {16, 17, 18};
    System.out.println(solution.numFriendRequests(ages));
  }

  /**
   * 排序 + 双指针
   *
   * @param ages int[]
   * @return int
   */
  public int numFriendRequests(int[] ages) {
    int n = ages.length, s = 7;
    double d = 0.5;
    Arrays.sort(ages);
    int left = 0, right = 0, ans = 0;
    for (int age : ages) {
      if (age < 15) {
        continue;
      }
      while (ages[left] <= age * d + s) {
        left++;
      }
      while (right + 1 < n && ages[right + 1] <= age) {
        right++;
      }
      ans += right - left;
    }
    return ans;
  }

}
