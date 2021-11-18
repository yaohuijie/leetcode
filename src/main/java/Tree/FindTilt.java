package tree;

/**
 * 563. 二叉树的坡度
 * <p>
 * 给定一个二叉树，计算整个树的坡度。
 * <p>
 * 一个树的节点的坡度定义即为，该节点左子树的节点之和和右子树节点之和的 差的绝对值。若果没有左子树的话， 左子树的节点之和为0；没有右子树的话也是一样。空节点的坡度为0.
 * <p>
 * 整个树的坡度就是其所有节点的坡度之和。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/18 11:09
 */
public class FindTilt {

  private int ans = 0;

  public static void main(String[] args) {
    FindTilt solution = new FindTilt();
    TreeNode root = new TreeNode(4);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(9);
    root.left = left;
    root.right = right;
    left.left = new TreeNode(3);
    left.right = new TreeNode(5);
    right.right = new TreeNode(7);
    System.out.println(solution.findTilt(root));

  }

  public int findTilt(TreeNode root) {
    ans = 0;
    dfs(root);
    return ans;
  }

  private int dfs(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int sumLeft = dfs(node.left);
    int sumRight = dfs(node.right);
    ans += Math.abs(sumLeft - sumRight);
    return sumLeft + sumRight + node.val;
  }
}
