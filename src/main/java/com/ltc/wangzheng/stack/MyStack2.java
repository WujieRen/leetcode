package com.ltc.wangzheng.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class MyStack2 {

    private Queue q1;
    private Queue q2;

    public MyStack2() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    public void push(int x) {
        q1.add(x);
    }

    private int getLastVal() {
        while(q1.size() > 1) {
            q2.add(q1.poll());
        }
        return  (Integer) q1.poll();
    }

    public int pop() {
        int res = getLastVal();
        while(!q2.isEmpty()) q1.add(q2.poll());
        return res;
    }

    public int top() {
        int res = getLastVal();
        q2.add(res);
        while(!q2.isEmpty()) q1.add(q2.poll());
        return res;
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
