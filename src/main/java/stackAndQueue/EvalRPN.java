package stackAndQueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/
 */
public class EvalRPN {
    public static int evalRPN(String[] tokens) {
        Deque<String> asStack = new LinkedList<>();
        for (int i = 0; i < tokens.length; i++) {
            String ele = tokens[i];
            if (Objects.equals(ele, "+")) {
                asStack.push(String.valueOf(Integer.parseInt(asStack.pop()) + Integer.parseInt(asStack.pop())));
            } else if (Objects.equals(ele, "-")) {
                int right = Integer.parseInt(asStack.pop());
                int left = Integer.parseInt(asStack.pop());
                asStack.push(String.valueOf(left - right));
            } else if (Objects.equals(ele, "*")) {
                asStack.push(String.valueOf(Integer.parseInt(asStack.pop()) * Integer.parseInt(asStack.pop())));
            } else if (Objects.equals(ele, "/")) {
                int right = Integer.parseInt(asStack.pop());
                int left = Integer.parseInt(asStack.pop());
                asStack.push(String.valueOf(left / right));
            } else {
                // 非符号 即数值，将数值入栈
                asStack.push(ele);
            }
        }
        return Integer.parseInt(asStack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
        ;
    }
}
