import java.util.Collections;
import java.util.PriorityQueue;

/**
 * 295.数据流的中位数
 *
 * @author Ghost_Yao
 * @version 1.0.0
 * @date created in 2021/8/27 17:28
 */
public class MedianFinder {

  PriorityQueue<Integer> queueMin;
  PriorityQueue<Integer> queueMax;

  /**
   * initialize your data structure here.
   */
  public MedianFinder() {
    queueMax = new PriorityQueue<>();
    queueMin = new PriorityQueue<>((a, b) -> (b - a));
  }

  public void addNum(Integer num) {
    if (queueMin.isEmpty() || num <= queueMin.peek()) {
      queueMin.offer(num);
      if (queueMax.size() + 1 < queueMin.size()) {
        queueMax.offer(queueMin.poll());
      }
    } else {
      queueMax.offer(num);
      if (queueMax.size() > queueMin.size()) {
        queueMin.offer(queueMax.poll());
      }
    }
  }

  public double findMedian() {
    if (queueMin.size() == 0 || queueMax.size() == 0) {
      return 0;
    }
    if (queueMin.size() > queueMax.size()) {
      return queueMin.peek();
    }
    return (queueMin.peek() + queueMax.peek()) / 2.0;
  }

}
