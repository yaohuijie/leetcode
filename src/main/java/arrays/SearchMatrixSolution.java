package arrays;

/**
 * 240. 搜索二维矩阵 Ⅱ
 * <p>
 * 编写一个高效的算法来搜索 m * n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。 每列的元素从上到下升序排列。
 *
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/25 14:48
 */
public class SearchMatrixSolution {

  public static void main(String[] args) {
    SearchMatrixSolution solution = new SearchMatrixSolution();
    int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24},
        {18, 21, 23, 26, 30}};
    System.out.println(solution.searchMatrix(matrix, 5));
    System.out.println(solution.searchMatrix(matrix, 20));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    boolean flag = false;
    for (int i = matrix.length - 1; i >= 0; i--) {
      if (matrix[i][0] > target) {
        continue;
      }
      int j = matrix[i].length - 1;
      if (matrix[i][j] < target) {
        continue;
      }
      for (; j >= 0; j--) {
        if (matrix[i][j] == target) {
          flag = true;
        }
      }
    }
    return flag;
  }

  /**
   * z字形查找
   */
  public boolean searchMatrix3(int[][] matrix, int target) {
    int m = matrix.length, n = matrix[0].length;
    int x = 0, y = n - 1;
    while (x < m && y >= 0) {
      if (matrix[x][y] == target) {
        return true;
      }
      if (matrix[x][y] > target) {
        y--;
      } else {
        x++;
      }
    }
    return false;
  }

  /**
   * 二分法
   */
  public boolean searchMatrix2(int[][] matrix, int target) {
    for (int[] row : matrix) {
      int index = search(row, target);
      if (index > 0) {
        return true;
      }
    }
    return false;
  }

  public int search(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    while (low < high) {
      int mid = (low + high) / 2 + low;
      int num = nums[mid];
      if (num == target) {
        return mid;
      } else if (num > target) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

  /**
   * 直接查找
   */
  public boolean searchMatrix1(int[][] matrix, int target) {
    for (int[] row : matrix) {
      for (int element : row) {
        if (element == target) {
          return true;
        }
      }
    }
    return false;
  }
}
