package algorithm.linknode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 19. 删除链表的倒数第N个节点
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/24 16:07
 */
public class RemoveNthFromEndSolution {

  /**
   * 计算链表长度
   */
  public ListNode removeNthFromEnd(ListNode head, int n) {
    int k = getLength(head);
    ListNode dummy = new ListNode(0, head);
    ListNode cur = dummy;
    for (int i = 1; i < k - n + 1; i++) {
      cur = cur.next;
    }
    cur.next = cur.next.next;
    return dummy.next;
  }

  public int getLength(ListNode node) {
    int len = 0;
    while (node != null) {
      len++;
      node = node.next;
    }
    return len;
  }

  /**
   * 栈
   */
  public ListNode removeNthFromEnd1(ListNode head, int n) {
    ListNode dummy = new ListNode(0, head);
    Deque<ListNode> stack = new LinkedList<>();
    ListNode cur = dummy;
    while (cur != null) {
      stack.push(dummy);
      cur = cur.next;
    }
    for (int i = 0; i < n; i++) {
      stack.pop();
    }
    ListNode prev = stack.peek();
    assert prev != null;
    prev.next = prev.next.next;
    return dummy.next;
  }

}
