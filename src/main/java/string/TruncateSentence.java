package string;

/**
 * 1816. 截断句子
 * <p>
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * <p>
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * <p>
 * 给你一个句子 s 和一个整数 k ，请你将 s 截断 ，使截断后的句子仅含 前 k 个单词。返回 截断 s 后得到的句子。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/truncate-sentence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/6 11:25
 */
public class TruncateSentence {

  public static void main(String[] args) {
    TruncateSentence solution = new TruncateSentence();
    String s = "Hello how are you Contestant";
    System.out.println(solution.truncateSentence(s, 4));
  }

  public String truncateSentence(String s, int k) {
    String[] arr = s.split(" ");
    if (k > arr.length) {
      k = arr.length;
    }
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < k; i++) {
      sb.append(arr[i]).append(" ");
    }
    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }
}
