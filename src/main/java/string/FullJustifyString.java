package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 * <p>
 * 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且两端对齐的文本。
 * <p>
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
 * <p>
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 * <p>
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 * <p>
 * 说明:
 * <p>
 * 单词是指由非空格字符组成的字符序列。 每个单词的长度大于 0，小于等于maxWidth。 输入单词数组 words至少包含一个单词。
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/9 19:52
 */
public class FullJustifyString {

  /**
   * 贪心算法
   */
  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> list = new ArrayList<>();
    int right = 0, n = words.length;
    while (true) {
      //当前行的第一个单词在words的位置
      int left = right;
      //统计这一行单词长度之和
      int sumLen = 0;
      //循环确定当前行可以放多少单词，注意单词之间应至少有一个空格
      while (right < n && sumLen + words[right].length() + right - left <= maxWidth) {
        sumLen += words[right++].length();
      }
      //当前行是最后一行：单词左对齐，且单词之间应只有一个空格，在行末填充剩余空格
      if (right == n) {
        StringBuffer sb = join(words, left, n, " ");
        sb.append(blank(maxWidth - sb.length()));
        list.add(sb.toString());
        return list;
      }
      int numWords = right - left;
      int numSpaces = maxWidth - sumLen;
      //当前行只有一个单词：该单词左对齐，在行末填充剩余空格
      if (numWords == 1) {
        StringBuffer sb = new StringBuffer(words[left]);
        sb.append(blank(numSpaces));
        list.add(sb.toString());
        continue;
      }

      //当前行不止一个单词
      int avgSpaces = numSpaces / (numWords - 1);
      int extraSpaces = numSpaces % (numWords - 1);
      StringBuffer sb = new StringBuffer();
      //拼接额外加一个空格的单词
      sb.append(join(words, left, left + extraSpaces + 1, blank(avgSpaces + 1)));
      sb.append(blank(avgSpaces));
      //拼接其余单词
      sb.append(join(words, left + extraSpaces + 1, right, blank(avgSpaces)));
      list.add(sb.toString());
    }
  }

  /**
   * blank
   *
   * @return 返回长度为n的由空格组成的字符串
   */
  public String blank(int n) {
    StringBuffer sb = new StringBuffer();
    for (int i = 0; i < n; i++) {
      sb.append(' ');
    }
    return sb.toString();
  }

  /**
   * join
   *
   * @return 返回用sep拼接[left， right] 范围内的words组成的字符串
   */
  public StringBuffer join(String[] words, int left, int right, String sep) {
    StringBuffer sb = new StringBuffer(words[left]);
    for (int i = left + 1; i < right; i++) {
      sb.append(sep);
      sb.append(words[i]);
    }
    return sb;
  }

}
