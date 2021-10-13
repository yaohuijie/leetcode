package math;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 412. Fizz Buzz
 * <p>
 * 给你一个整数 n ，找出从 1 到 n 各个整数的 Fizz Buzz 表示，并用字符串数组 answer（下标从 1 开始）返回结果
 * </p>
 *
 * @author Ghost_Yao
 * @version 1.0.0$
 * @date created in 2021/10/13 14:23
 */
public class FizzBuzzSolution {

  public static void main(String[] args) {
    FizzBuzzSolution solution = new FizzBuzzSolution();
    System.out.println(solution.fizzBuzz(15));
    System.out.println(solution.fizzBuzz1(15));
  }

  public List<String> fizzBuzz(int n) {
    return IntStream.range(1, n + 1).mapToObj(a -> a % 15 == 0 ? "FizzBuzz"
        : a % 3 == 0 ? "Fizz" : a % 5 == 0 ? "Buzz" : String.valueOf(a)).collect(
        Collectors.toList());
  }

  public List<String> fizzBuzz1(int n) {
    List<String> list = new ArrayList<>();
    int f = 1, b = 1;
    for (int i = 1; i <= n; i++) {
      if (f == 3 && b == 5) {
        list.add("FizzBuzz");
        f = 1;
        b = 1;
      } else if (f == 3) {
        list.add("Fizz");
        f = 1;
        b++;
      } else if (b == 5) {
        list.add("Buzz");
        b = 1;
        f++;
      } else {
        f++;
        b++;
        list.add(String.valueOf(i));
      }

    }
    return list;
  }

}
