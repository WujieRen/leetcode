package com.ltc.wangzheng.linkedlist;

import com.ltc.wangzheng.ListNode;

public class ReverseList {
    public static void main(String[] args) {

    }

    private static ListNode f3(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }

    private static ListNode f2(ListNode head) {
        if(head == null) return null;
        ListNode old = null;
        ListNode cur = head;
        ListNode nxt = head.next;
        while(true) {
            cur.next = old;
            old = cur;
            cur = nxt;
            if(cur == null) break;
            nxt = nxt.next;
        }
        return old;
    }

    private static ListNode f1(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode cur = head.next;
        ListNode nxt = cur.next;
        head.next = null;
        while(true) {
            cur.next = head;
            head = cur;
            cur = nxt;
            if(cur == null) break;
            nxt = cur.next;
        }
        return head;
    }
}
