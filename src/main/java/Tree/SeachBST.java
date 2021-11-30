package tree;

/**
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/26 11:19
 */
public class SeachBST {

  public static void main(String[] args) {
    SeachBST solution = new SeachBST();
    TreeNode root = new TreeNode(4);
    TreeNode left = new TreeNode(2);
    TreeNode right = new TreeNode(7);
    root.left = left;
    root.right = right;
    left.left = new TreeNode(1);
    left.right = new TreeNode(3);
    TreeNode node = solution.searchBST(root, 2);
    System.out.println(node.val);
  }

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }

    return searchBST(val < root.val ? root.left : root.right, val);
  }


}
