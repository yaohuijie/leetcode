package math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 869. 重新排序得到2的幂
 * <p>
 * 给定正整数 N，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * <p>
 * 如果我们可以通过上述方式得到2 的幂，返回 true；否则，返回 false。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/28 11:29
 */
public class ReorderedPowerOfSolution {

  Set<String> powerOf2Digits = new HashSet<>();
  boolean[] vis;

  public static void main(String[] args) {
    ReorderedPowerOfSolution solution = new ReorderedPowerOfSolution();
    System.out.println(solution.reorderedPowerOf2(1024));
    System.out.println(solution.reorderedPowerOfTwo(2401));
  }

  public boolean reorderedPowerOfTwo(int n) {
    init();
    return powerOf2Digits.contains(countDigits(n));
  }

  public void init() {
    for (int n = 1; n <= 1e9; n <<= 1) {
      powerOf2Digits.add(countDigits(n));
    }
  }

  public String countDigits(int n) {
    char[] arr = new char[10];
    while (n > 0) {
      arr[n % 10]++;
      n /= 10;
    }
    return new String(arr);
  }

  /****************************************
   *                                      *
   *****************************************/
  public boolean reorderedPowerOf2(int n) {
    char[] arr = Integer.toString(n).toCharArray();
    Arrays.sort(arr);
    vis = new boolean[arr.length];
    return backtrack(arr, 0, 0);
  }

  public boolean backtrack(char[] arr, int idx, int num) {
    if (idx == arr.length) {
      return isPowerOf2(num);
    }
    for (int i = 0; i < arr.length; i++) {
      //不能有前导0
      boolean flag = num == 0 && arr[i] == '0';
      boolean fb = i > 0 && !vis[i - 1] && arr[i] == arr[i - 1];
      if (flag || vis[i] || fb) {
        continue;
      }
      vis[i] = true;
      if (backtrack(arr, idx + 1, num * 10 + arr[i] - '0')) {
        return true;
      }
      vis[i] = false;
    }
    return false;
  }

  public boolean isPowerOf2(int n) {
    return (n & (n - 1)) == 0;
  }
}
