package algorithm;

/**
 * 629. K个逆序对数组
 *
 * <p>
 * 给出两个整数 n 和 k，找出所有包含从 1到 n的数字，且恰好拥有 k 个逆序对的不同的数组的个数。
 * <p>
 * 逆序对的定义如下：对于数组的第i个和第 j 个元素，如果满 i < j 且 a[i] > a[j]，则其为一个逆序对；否则不是。
 * <p>
 * 由于答案可能很大，只需要返回 答案 mod 109 + 7 的值。
 * <p>
 * n的范围是[1,1000]并且k的范围是[0,1000].
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/k-inverse-pairs-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/11 11:19
 */
public class InversePairs {

  final int MOD = 1000000007;

  public static void main(String[] args) {
    InversePairs solution = new InversePairs();
    //数组[1,3,2] 和 [2, 1, 3] 都有一个逆序对
    System.out.println(solution.kInversePairs(3, 1));
  }

  public int kInversePairs(int n, int k) {
    int[][] f = new int[2][k + 1];
    f[0][0] = 1;
    for (int i = 1; i <= n; i++) {
      for (int j = 0; j <= k; j++) {
        int cur = i & 1, prev = cur ^ 1;
        f[cur][j] =
            (j - 1 >= 0 ? f[cur][j - 1] : 0) - (j - i >= 0 ? f[prev][j - i] : 0) + f[prev][j];
        if (f[cur][j] >= MOD) {
          f[cur][j] -= MOD;
        } else if (f[cur][j] < 0) {
          f[cur][j] += MOD;
        }
      }
    }
    return f[n & 1][k];
  }
}
