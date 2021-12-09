package arrays;

/**
 * 794.有效的井字游戏
 * <p>
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * <p>
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（' '）中。
 * <p>
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * <p>
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * <p>
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。 当所有位置非空时，也算为游戏结束。
 * <p>
 * 如果游戏结束，玩家不允许再放置字符。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/valid-tic-tac-toe-state
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/12/9 15:38
 */
public class ValidTicTacToe {

  public static void main(String[] args) {
    ValidTicTacToe solution = new ValidTicTacToe();
    String[] arr = {"OXX", "XOX", "OXO"};
    System.out.println(solution.validTicTacToe(arr));
  }

  public boolean validTicTacToe(String[] board) {
    char charX = 'X', charO = 'O';
    int x = 0, o = 0;
    for (String row : board) {
      for (char c : row.toCharArray()) {
        x = (c == charX) ? (x + 1) : x;
        o = (c == charO) ? (o + 1) : o;
      }
    }
    if (x != o && x != o + 1) {
      return false;
    }
    if (win(board, charX) && o != x - 1) {
      return false;
    }
    if (win(board, charO) && o != x) {
      return false;
    }
    return true;
  }

  private boolean win(String[] board, char p) {
    for (int i = 0; i < 3; i++) {
      if (p == board[0].charAt(i) && p == board[1].charAt(i) && p == board[2].charAt(i)) {
        return true;
      }
      if (p == board[i].charAt(0) && p == board[i].charAt(1) && p == board[i].charAt(2)) {
        return true;
      }
    }
    if (p == board[0].charAt(0) && p == board[1].charAt(1) && p == board[2].charAt(2)) {
      return true;
    }
    if (p == board[0].charAt(2) && p == board[1].charAt(1) && p == board[2].charAt(0)) {
      return true;
    }
    return false;
  }
}
