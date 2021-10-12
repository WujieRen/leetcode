package com.ltc.wangzheng.stack;

import java.util.LinkedList;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class SortedStack {

    public static void main(String[] args) {
        SortedStack st = new SortedStack();
        st.push(3);
        st.push(6);
        st.push(7);
        System.out.println(st.q2);
        st.push(5);
        System.out.println(st.q2);
    }

    LinkedList q1;
    LinkedList q2;

    public SortedStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }

    public void push(int val) {
        while (!q2.isEmpty() && (Integer) q2.getFirst() < val) {
            q1.addLast(q2.removeFirst());
        }
        q1.addLast(val);
        while (!q2.isEmpty()) {
            q1.add(q2.removeFirst());
        }
        LinkedList tmp = q1;
        q1 = q2;
        q2 = tmp;
    }

    public void pop() {
        if (!q2.isEmpty()) {
            q2.removeFirst();
        }
    }

    public int peek() {
        return q2.isEmpty() ? -1 : (Integer) q2.getFirst();
    }

    public boolean isEmpty() {
        return q2.isEmpty();
    }
}
