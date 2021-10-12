package com.ltc.wangzheng.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class MyStack3 {

    private Queue q1;
    private Queue q2;

    public MyStack3() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        q1.offer(x);
        while(!q2.isEmpty()) {
            q1.add(q2.poll());
        }
        Queue tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    public int pop() {
        return (Integer) q2.poll();
    }

    public int top() {
        return (Integer) q2.peek();
    }

    public boolean empty() {
        return q2.isEmpty();
    }
}
