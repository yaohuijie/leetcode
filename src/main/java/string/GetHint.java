package string;

/**
 * 299. 猜数字游戏
 *
 * <p>
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 写出一个秘密数字，并请朋友猜这个数字是多少。朋友每猜测一次，你就会给他一个包含下述信息的提示：
 * <p>
 * 猜测数字中有多少位属于数字和确切位置都猜对了（称为 "Bulls", 公牛）， 有多少位属于数字猜对了但是位置不对（称为 "Cows",
 * 奶牛）。也就是说，这次猜测中有多少位非公牛数字可以通过重新排列转换成公牛数字。 给你一个秘密数字 secret 和朋友猜测的数字 guess ，请你返回对朋友这次猜测的提示。
 * <p>
 * 提示的格式为 "xAyB" ，x 是公牛个数， y 是奶牛个数，A 表示公牛，B 表示奶牛。
 * <p>
 * 请注意秘密数字和朋友猜测的数字都可能含有重复数字
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/bulls-and-cows
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/11/8 16:33
 */
public class GetHint {

  public static void main(String[] args) {
    GetHint solution = new GetHint();
    System.out.println(solution.getHint("11123", "00111"));
  }

  public String getHint(String secret, String guess) {
    int bull = 0, cow = 0;
    int[] cntS = new int[10];
    int[] cntG = new int[10];
    int len = Math.min(secret.length(), guess.length());
    for (int i = 0; i < len; i++) {
      char a = secret.charAt(i);
      char b = guess.charAt(i);
      if (a == b) {
        bull++;
      } else {
        cntS[a - '0']++;
        cntG[b - '0']++;
      }

    }
    int m = 10;
    for (int i = 0; i < m; i++) {
      cow += Math.min(cntG[i], cntS[i]);
    }
    return bull + "A" + cow + "B";
  }

}
