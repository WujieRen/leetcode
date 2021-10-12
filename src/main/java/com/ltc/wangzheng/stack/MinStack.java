package com.ltc.wangzheng.stack;

import java.util.LinkedList;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class MinStack {

    LinkedList stack;
    int min = Integer.MAX_VALUE;

    public MinStack() {
        stack = new LinkedList();
    }

    public void push(int val) {
        stack.addLast(val);
        if(val < min) min = val;
    }

    public void pop() {
        int oldLastV = (Integer) stack.getLast();
        stack.removeLast();
        if(!stack.isEmpty() && oldLastV == min) {
            min = (Integer) stack.getFirst();
            for(Object o : stack) {
                int v = (Integer) o;
                if(v < min) min = v;
            }
        }
        if(stack.isEmpty()) {
            min = Integer.MAX_VALUE;
        }
    }

    public int top() {
        return (Integer) stack.getLast();
    }

    public int getMin() {
        return min;
    }
}
