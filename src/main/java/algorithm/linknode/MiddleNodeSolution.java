package algorithm.linknode;

import java.util.ArrayList;
import java.util.List;

/**
 * 876. 链表的中间节点
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/24 15:58
 */
public class MiddleNodeSolution {

  /**
   * 数组
   */
  public ListNode middleNode(ListNode head) {
    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }
    return list.get(list.size() / 2);
  }

  /**
   * 单指针
   */
  public ListNode middleNode1(ListNode head) {
    int n = 0;
    ListNode cur = head;
    while (cur != null) {
      n++;
      cur = cur.next;
    }
    int k = 0;
    cur = head;
    while (k < n / 2) {
      k++;
      cur = cur.next;
    }
    return cur;
  }

}

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }
}
