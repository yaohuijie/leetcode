package math;

/**
 * 319. 灯泡开关
 * <p>
 * <br> 初始有 n 个灯泡处于关闭状态。
 * <br> 第一轮，你将会打开所有灯泡。
 * <br> 第二轮，你将会每两个灯泡关闭一个。
 * <br> 第三轮，你每三个灯泡就切换一个灯泡开关（即，打开变关闭，关闭变打开）。
 * <br>  ……
 * <br> 第i轮，你每 i 个灯泡就切换一个灯泡开关。
 * <br> 直到 n 轮，你只需要切换最后一个灯泡的开关。
 * <br> 找出并返回 n 轮后有多少个亮着的灯泡?
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/15 11:15
 */
public class BulbSwitch {

  public static void main(String[] args) {
    BulbSwitch solution = new BulbSwitch();
    System.out.println(solution.bulbSwitch(5));
  }

  public int bulbSwitch(int n) {
    return (int) Math.sqrt(n + 0.5);
  }

}
