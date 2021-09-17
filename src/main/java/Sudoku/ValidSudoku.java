package Sudoku;

/**
 * 36. 有效的数独
 * <p>
 * 请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。<br/> 数字 1-9 在每一列只能出现一次。<br/> 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。<br/>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/9/17 14:34
 */
public class ValidSudoku {


  public boolean isValidSudoku(char[][] board) {
    int len = board.length;
    int[][] row = new int[len][len];
    int[][] col = new int[len][len];
    int[][][] box = new int[3][3][len];

    for (int i = 0; i < len; i++) {
      for (int j = 0; j < len; j++) {
        char a = board[i][j];
        if (a != '.') {
          int index = a - '0' - 1;
          row[i][index]++;
          col[j][index]++;
          box[i / 3][j / 3][index]++;
          if (row[i][index] > 1 || col[j][index] > 1 || box[i / 3][j / 3][index] > 1) {
            return false;
          }
        }
      }
    }
    return true;
  }

}
