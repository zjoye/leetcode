package stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/problems/implement-stack-using-queues/
 */
public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        this.q1 = new LinkedList<Integer>();
        this.q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        this.q2.offer(x);
        while (!this.q1.isEmpty()) {
            this.q2.offer(this.q1.poll());
        }
        Queue<Integer> tmp = this.q1;
        this.q1 = this.q2;
        this.q2 = tmp;
    }

    public int pop() {
        return this.q1.poll();
    }

    public int top() {
        return this.q1.peek();
    }

    public boolean empty() {
        return this.q1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.top(); // 返回 2
        myStack.pop(); // 返回 2
        myStack.empty(); // 返回 False
    }

}
