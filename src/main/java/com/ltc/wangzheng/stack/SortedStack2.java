package com.ltc.wangzheng.stack;

import java.util.PriorityQueue;

/**
 * @author rwj
 * @create_time 2021/10/10
 * @description
 */
public class SortedStack2 {

    PriorityQueue<Integer> pq;

    public SortedStack2() {
        pq = new PriorityQueue<Integer>();
    }

    public void push(int val) {
        pq.add(val);
//        pq.offer(val);
    }

    public void pop() {
        pq.poll();
    }

    public int peek() {
        return pq.isEmpty() ? -1 : pq.peek();
    }

    public boolean isEmpty() {
        return pq.isEmpty();
    }
}
