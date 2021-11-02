package linknode;

/**
 * 237. 删除链表中的节点
 * <p>
 * 请编写一个函数，用于 删除单链表中某个特定节点 。在设计函数时需要注意，你无法访问链表的头节点 head ，只能直接访问 要被删除的节点 。
 * <p>
 * 题目数据保证需要删除的节点 不是末尾节点
 *
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/2 11:03
 */
public class DeleteNodeSolution {

  public static void main(String[] args) {
    DeleteNodeSolution solution = new DeleteNodeSolution();
    ListNode head = new ListNode(4);
    ListNode node1 = new ListNode(5);
    ListNode node2 = new ListNode(1);
    ListNode node3 = new ListNode(9);
    head.next = node1;
    node1.next = node2;
    node2.next = node3;
    solution.deleteNode(node1);
    ListNode next = head;
    while (next != null) {
      System.out.println(next.val);
      next = next.next;
    }
  }

  public void deleteNode(ListNode node) {
    ListNode next = node.next;
    if (next != null) {
      node.val = next.val;
      node.next = next.next;
    }
  }
}
