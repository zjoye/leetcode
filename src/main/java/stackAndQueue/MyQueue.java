package stackAndQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class MyQueue {

    private final List<Integer> stack;

    public MyQueue() {
        this.stack = new ArrayList<>();
    }

    public void push(int x) {
        stack.add(x);
    }

    public int pop() {
        Integer ele = stack.get(stack.size() - 1);
        stack.remove(ele);
        return ele;
    }

    public int top() {
        return stack.get(stack.size() - 1);
    }


    public boolean empty() {
        return stack.isEmpty();
    }
}
