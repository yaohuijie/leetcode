package string;

/**
 * 71.简化路径
 * <p>
 * 给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
 * <p>
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠
 * '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
 * <p>
 * 请注意，返回的 规范路径 必须遵循下述格式：
 *
 * <hr>始终以斜杠 '/' 开头。
 * <hr>两个目录名之间必须只有一个斜杠 '/' 。
 * <hr>最后一个目录名（如果存在）不能 以 '/' 结尾。
 * <hr>此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
 * <hr>返回简化后得到的 规范路径 。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/simplify-path
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2022/1/6 14:30
 */
public class SimplifyPath {

  public static void main(String[] args) {
    SimplifyPath solution = new SimplifyPath();
    System.out.println(solution.simplifyPath("/n/Qz/../../ZWuLz/./R/.//"));
  }

  public String simplifyPath(String path) {
    String[] split = path.split("/");
    StringBuilder sb = new StringBuilder();
    for (String p : split) {
      if (".".equalsIgnoreCase(p) || p.isEmpty()) {
        continue;
      }
      if ("..".equalsIgnoreCase(p)) {
        if (sb.length() > 0) {
          sb.delete(sb.lastIndexOf("/"), sb.length());
        }
        continue;
      }
      sb.append("/").append(p);
    }
    if (sb.length() == 0) {
      sb.append("/");
    }
    return sb.toString();
  }

}
