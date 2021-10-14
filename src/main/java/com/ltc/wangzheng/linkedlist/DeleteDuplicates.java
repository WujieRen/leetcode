package com.ltc.wangzheng.linkedlist;

import com.ltc.wangzheng.ListNode;

public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode h4 = new ListNode(3);
        ListNode h3 = new ListNode(3, h4);
        ListNode h2 = new ListNode(2, h3);
        ListNode h1 = new ListNode(1, h2);
        ListNode head = new ListNode(1, h1);
        f1(head).iterate(head);

    }
    private static ListNode f1(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode nxt = pre.next;
        while(nxt != null) {
            if(pre.val == nxt.val) {
                pre.next = nxt.next;
            } else {
                pre = nxt;
            }
            nxt = nxt.next;
        }
        return head;
    }
}
