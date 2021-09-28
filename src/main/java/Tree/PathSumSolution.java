package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 437. 路径总和Ⅲ
 *
 * <p>
 * 给定一个二叉树的根节点 root，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * <p>
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/28 15:42
 */
public class PathSumSolution {

  /**
   * 深度优先搜索
   */
  public int pathSum(TreeNode root, int targetSum) {
    if (root == null) {
      return 0;
    }
    int ret = sumNode(root, targetSum);
    ret += sumNode(root.left, targetSum);
    ret += sumNode(root.left, targetSum);
    return ret;
  }

  public int sumNode(TreeNode node, int sum) {
    int ret = 0;
    if (node == null) {
      return 0;
    }
    int val = node.val;
    if (val == sum) {
      ret++;
    }
    ret += sumNode(node.left, sum - val);
    ret += sumNode(node.right, sum - val);
    return ret;
  }

  /**
   * 前缀和
   */
  public int pathSum1(TreeNode root, int targetSum) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    return dfs(root, map, 0, targetSum);
  }

  public int dfs(TreeNode node, Map<Integer, Integer> map, int curr, int sum) {
    if (node == null) {
      return 0;
    }
    int ret;
    curr += node.val;
    ret = map.getOrDefault(curr - sum, 0);
    map.put(curr, map.getOrDefault(curr, 0) + 1);
    ret += dfs(node.left, map, curr, sum);
    ret += dfs(node.right, map, curr, sum);
    map.put(curr, map.getOrDefault(curr, 0) - 1);
    return ret;
  }

}
