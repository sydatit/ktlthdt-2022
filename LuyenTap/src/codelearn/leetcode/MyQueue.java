package codelearn.leetcode;

import java.util.Stack;

public class MyQueue {
    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }
    Stack<Integer> pushS = new Stack<>();
    Stack<Integer> popS = new Stack<>();

    public MyQueue() {
    }

    public void push(int x) {
        while (!popS.empty())
            pushS.push(popS.pop());
        pushS.push(x);
    }

    public int pop() {
        while (!pushS.isEmpty())
            popS.push(pushS.pop());
        return popS.pop();
    }

    public int peek() {
        while (!pushS.isEmpty())
            popS.push(pushS.pop());
        return popS.peek();
    }

    public boolean empty() {
        return pushS.isEmpty() && popS.isEmpty();
    }
}
