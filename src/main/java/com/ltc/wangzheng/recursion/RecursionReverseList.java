package com.ltc.wangzheng.recursion;

import com.ltc.wangzheng.ListNode;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class RecursionReverseList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(3, new ListNode(2)));
        ListNode.iterate(n1);
        n1 = f1(n1);
        ListNode.iterate(n1);
    }

    public static ListNode f2(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode newHead = f2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode f1(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }

}
