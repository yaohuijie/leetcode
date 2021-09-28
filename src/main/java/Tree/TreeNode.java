package Tree;

/**
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/28 15:43
 */
public class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

}
