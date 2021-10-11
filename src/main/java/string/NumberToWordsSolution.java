package string;

/**
 * 273. 整数转换英文表示
 * <p>
 * 将非负整数 num 转换为其对应的英文表示
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/11 15:06
 */
public class NumberToWordsSolution {

  String[] singles = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
  String[] teens = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
      "Seventeen", "Eighteen", "Nineteen"};
  String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty",
      "Ninety"};
  String[] thousands = {"", "Thousand", "Million", "Billion"};


  /**
   * 递归
   */
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 3, uint = 1000000000; i >= 0; i--, uint /= 1000) {
      int curNum = num / uint;
      if (curNum != 0) {
        num -= curNum * uint;
        StringBuffer curr = new StringBuffer();
        recursion(curr, curNum);
        curr.append(thousands[i]).append(" ");
        sb.append(curr);
      }
    }
    return sb.toString().trim();
  }

  public void recursion(StringBuffer curr, int num) {
    if (num != 0) {
      if (num < 10) {
        curr.append(singles[num]).append(" ");
      } else if (num < 20) {
        curr.append(teens[num - 10]).append(" ");
      } else if (num < 100) {
        curr.append(tens[num / 10]).append(" ");
        recursion(curr, num % 10);
      } else {
        curr.append(singles[num / 100]).append(" Hundred ");
        recursion(curr, num % 100);
      }
    }
  }

  /**
   * 迭代
   */
  public String numberToWords2(int num) {
    if (num == 0) {
      return "Zero";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 3, uint = 1000000000; i >= 0; i--, uint /= 1000) {
      int curNum = num / uint;
      if (curNum != 0) {
        num -= curNum * uint;
        sb.append(toEnglish(curNum)).append(thousands[i]).append(" ");
      }
    }
    return sb.toString().trim();
  }

  public String toEnglish(int num) {
    StringBuilder curr = new StringBuilder();
    int hundred = num / 100;
    num %= 100;
    if (hundred != 0) {
      curr.append(singles[hundred]).append(" Hundred ");
    }
    int ten = num / 10;
    if (ten > 1) {
      curr.append(tens[ten]).append(" ");
      num %= 10;
    }
    //考虑 0 的情况。否则会多空格
    if (num > 0 && num < 10) {
      curr.append(singles[num]).append(" ");
    } else if (num >= 10) {
      curr.append(teens[num - 10]).append(" ");
    }
    return curr.toString();
  }

}
