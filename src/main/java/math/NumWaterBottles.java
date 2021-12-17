package math;

/**
 * 1518.换酒问题
 * <p>
 * 小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。
 * <p>
 * 如果喝掉酒瓶中的酒，那么酒瓶就会变成空的。
 * <p>
 * 请你计算 <b>最多<b/>能喝到多少瓶酒。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/17 10:56
 */
public class NumWaterBottles {

  public static void main(String[] args) {
    NumWaterBottles solution = new NumWaterBottles();
    System.out.println(solution.numWaterBottles(15, 4));
    System.out.println(solution.numWaterBottles1(15, 4));
  }

  /**
   * 模拟
   *
   * @param numBottles  int 买的酒的数量
   * @param numExchange int 兑换数量（多少个空瓶兑换一瓶酒）
   * @return int 总共能喝多少瓶酒
   */
  public int numWaterBottles(int numBottles, int numExchange) {
    int sum = 0, drink = 0;
    while (numBottles > 0) {
      drink++;
      numBottles--;
      sum++;
      if (drink == numExchange) {
        drink = 0;
        numBottles++;
      }
    }
    return sum;
  }

  /**
   * 数学
   *
   * @param numBottles  int 买的酒的数量
   * @param numExchange int 兑换数量（多少个空瓶兑换一瓶酒）
   * @return int 总共能喝多少瓶酒
   */
  public int numWaterBottles1(int numBottles, int numExchange) {
    return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1
        + numBottles : numBottles;
  }

}
