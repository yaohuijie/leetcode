package linknode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指Offer 22. 链表中倒数第k个节点
 *
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2021/9/2 17:37
 */
public class LinkSolution {

  /**
   * 差值法
   *
   * @param head 链
   * @param k    倒数k个节点
   * @return 找到后的链
   */
  public ListNode getKthFromEnd(ListNode head, int k) {
    List<ListNode> list = new ArrayList<>();
    while (head != null) {
      list.add(head);
      head = head.next;
    }
    if (list.size() >= k) {
      return list.get(list.size() - k);
    }
    return null;
  }

  /**
   * 双指针
   *
   * @param head 链
   * @param k    倒数k个节点
   * @return 找到后的链
   */
  public ListNode getKthFromEnd1(ListNode head, int k) {
    ListNode fast = head;
    ListNode slow = head;
    while (k > 0 && fast != null) {
      fast = fast.next;
      k--;
    }
    while (fast != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }


  /**
   * 剑指Offer 22. 链表中倒数第k个节点 输入一个链表，输出该链表中倒数第k个节点
   */
  public static void main(String[] args) {
    LinkSolution solution = new LinkSolution();
    ListNode node = new ListNode(1);
    setNext(2, node, 6);
    ListNode slow = solution.getKthFromEnd1(node, 2);
    while (slow != null) {
      System.out.println(slow.val);
      slow = slow.next;
    }
  }

  public static void setNext(int num, ListNode node, int total) {
    if (num < total) {
      ListNode next = new ListNode(num);
      node.next = next;
      num++;
      setNext(num, next, total);
    }
  }


}
