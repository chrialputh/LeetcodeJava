package Follow.N2_Evaluate_Reverse_Polish_Notation;

import java.util.Stack;

class Solution1 {
    int evalRPN(String[] tokens) {
        int returnValue = 0;
        String operators = "+-*/";
        Stack<String> stack = new Stack<String>();  //新建一个“后进先出”的堆栈
        for (String t : tokens) {   //遍历tokens
            if (!operators.contains(t)) {
                stack.push(t);  //若不是运算符就把他压入堆栈
            } else {            //若是运算符
                //Integer.valueOf(String s, int radix):将字符串s按照指定的radix(默认为10)进制解释为10进制数
                int a = Integer.valueOf(stack.pop());  //删除当前堆栈内顶端元素，并将其作为返回值
                int b = Integer.valueOf(stack.pop());
                switch (t) {     //根据运算符的不同，执行相应操作
                    case "+":
                        stack.push(String.valueOf(a + b));//运算完后，将结果也压入栈内
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b / a));
                        break;
                }
            }
        }
        returnValue = Integer.valueOf(stack.pop());//对tokens处理完后，stack堆栈内就只剩一个元素-->结果
        return returnValue;
    }
}
