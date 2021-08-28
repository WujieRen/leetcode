package com.rwj.ltc.list;

/**
 * @author rwj
 * @create_time 2021/7/30
 * @description 链表节点
 */
public class ListNode<T> {
    T val;
    ListNode next;
    ListNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
