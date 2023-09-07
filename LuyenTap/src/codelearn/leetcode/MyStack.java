package codelearn.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MyStack {
    private Deque<Integer> queue;
    public MyStack() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        if (queue.isEmpty())
            return -1;
        return queue.removeLast();
    }

    public int top() {
        if (queue.isEmpty())
            return -1;
        return queue.getLast();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

