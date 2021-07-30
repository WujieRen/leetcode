package com.rwj.ltc.list;

/**
 * @author rwj
 * @create_time 2021/7/30
 * @description 链表节点
 */
public class ListNode {
    Object val;
    ListNode next;
    ListNode(Object val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val.toString();
    }
}
