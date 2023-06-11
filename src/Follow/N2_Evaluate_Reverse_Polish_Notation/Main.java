package Follow.N2_Evaluate_Reverse_Polish_Notation;

import java.io.IOException;

/*
The problem:
Evaluate the value of an arithmetic expression in Reverse Polish Notation.
Valid operators are +, -, *, /. Each operand may be an integer or another
expression.
Some examples:
["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
问题是：
用反波兰表示法计算一个算术表达式的值。有效的运算符是+、-、*、/。
每个操作数都可以是一个整数或其他表达式。
一些例子：
[“2”、“1”、“+”、“3”、“*”]->（（2+1）*3）->9
[“4”，“13”，“5”，“/”，“+”]->（4+（13/5））->6
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String[] tokens = new String[] { "2", "1", "+", "3", "*" };
        final Solution1 solution1 = new Solution1();
        final Solution2 solution2 = new Solution2();
        System.out.println("solution1 :" + solution1.evalRPN(tokens));
        System.out.println("solution2 :" + solution2.evalRPN(tokens));
    }
}