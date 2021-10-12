package com.ltc.wangzheng.stack;

import java.util.LinkedList;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class MyStack {

    private LinkedList<Integer> queue;

    public MyStack() {
        queue = new LinkedList<Integer>();
    }

    public void push(int x) {
        queue.addLast(x);
    }

    public int pop() {
        int lastVal = queue.getLast();
        queue.removeLast();
        return lastVal;
    }

    public int top() {
        return queue.getLast();
    }

    public boolean empty() {
        return queue == null || queue.size() == 0;
    }
}
