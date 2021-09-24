package linknode;

/**
 * 430. 扁平化多级双向链表
 *
 * <p>
 * 多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构。
 * <p>
 * 给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/24 14:57
 */
public class FlattenSolution {

  /**
   * 深度优先搜索
   */
  public Node flatten(Node head) {
    dfs(head);
    return head;
  }

  public Node dfs(Node node) {
    Node cur = node;
    //记录链表的最后一个节点
    Node last = null;
    while (cur != null) {
      Node next = cur.next;
      // 如果有子节点，那么首先处理子节点
      if (cur.child != null) {
        Node childLast = dfs(cur.child);
        next = cur.next;
        // 将node与child相连
        cur.next = cur.child;
        cur.child.prev = cur;
        // 如果 next 不为空， 就将 last 与 next 相连
        if (next != null) {
          childLast.next = next;
          next.prev = childLast;
        }
        // 将 child 置为空
        cur.child = null;
        last = childLast;
      } else {
        last = cur;
      }
      cur = next;
    }
    return last;
  }

}
