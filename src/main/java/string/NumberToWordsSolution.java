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

  private final int ZERO = 0;
  private final int TEN = 10;
  private final int HUNDRED = 100;
  private final int THOUSAND = 1000;
  private final int BILLION = 1_000_000_000;

  public static void main(String[] args) {
    NumberToWordsSolution solution = new NumberToWordsSolution();
    System.out.println(solution.numberToWords(5803256));
    System.out.println(solution.numberToWords2(5803256));
  }

  /**
   * 递归
   */
  public String numberToWords(int num) {
    if (num == 0) {
      return "Zero";
    }
    StringBuilder sb = new StringBuilder();
    int unit = BILLION;
    for (int i = 3; i >= ZERO; i--, unit /= THOUSAND) {
      int curNum = num / unit;
      if (curNum != ZERO) {
        num -= curNum * unit;
        StringBuffer curr = new StringBuffer();
        recursion(curr, curNum);
        curr.append(thousands[i]).append(" ");
        sb.append(curr);
      }
    }
    return sb.toString().trim();
  }

  public void recursion(StringBuffer curr, int num) {
    if (num != ZERO) {
      int TWENTY = 20;
      if (num < TEN) {
        curr.append(singles[num]).append(" ");
      } else if (num < TWENTY) {
        curr.append(teens[num - TEN]).append(" ");
      } else if (num < HUNDRED) {
        curr.append(tens[num / TEN]).append(" ");
        recursion(curr, num % TEN);
      } else {
        curr.append(singles[num / HUNDRED]).append(" Hundred ");
        recursion(curr, num % HUNDRED);
      }
    }
  }

  /**
   * 迭代
   */
  public String numberToWords2(int num) {
    if (num == ZERO) {
      return "Zero";
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 3, unit = BILLION; i >= ZERO; i--, unit /= THOUSAND) {
      int curNum = num / unit;
      if (curNum != ZERO) {
        num -= curNum * unit;
        sb.append(toEnglish(curNum)).append(thousands[i]).append(" ");
      }
    }
    return sb.toString().trim();
  }

  public String toEnglish(int num) {
    StringBuilder curr = new StringBuilder();
    int hundred = num / HUNDRED;
    num %= HUNDRED;
    if (hundred != ZERO) {
      curr.append(singles[hundred]).append(" Hundred ");
    }
    int ten = num / TEN;
    if (ten > 1) {
      curr.append(tens[ten]).append(" ");
      num %= TEN;
    }
    //考虑 0 的情况。否则会多空格
    if (num > ZERO && num < TEN) {
      curr.append(singles[num]).append(" ");
    } else if (num >= TEN) {
      curr.append(teens[num - TEN]).append(" ");
    }
    return curr.toString();
  }

}
