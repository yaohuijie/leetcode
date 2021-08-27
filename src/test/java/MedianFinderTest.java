/**
 * @author Ghost_Yao
 * @version 1.0$
 * @date created in 2021/8/27 17:31
 */
public class MedianFinderTest {

  /**
   * 295.数据流的中位数
   * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
   *
   * 例如，
   *
   * [2,3,4]的中位数是 3
   *
   * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
   *
   * 设计一个支持以下两种操作的数据结构：
   *
   * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
   * double findMedian() - 返回目前所有元素的中位数。
   */
  public static void main(String[] args) {
    MedianFinder finder = new MedianFinder();
    finder.addNum(6);
    System.out.println(finder.findMedian());
    finder.addNum(10);
    System.out.println(finder.findMedian());
    finder.addNum(2);
    System.out.println(finder.findMedian());
    finder.addNum(6);
    finder.addNum(5);
    finder.addNum(0);
    finder.addNum(6);
    finder.addNum(3);
    finder.addNum(1);
    finder.addNum(0);
    finder.addNum(0);
    System.out.println(finder.findMedian());
  }

}
