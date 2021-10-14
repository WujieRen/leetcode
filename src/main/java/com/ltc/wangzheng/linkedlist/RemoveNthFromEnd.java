package com.ltc.wangzheng.linkedlist;

import com.ltc.wangzheng.ListNode;

public class RemoveNthFromEnd {
    public static void main(String[] args) {

    }

    private static ListNode f1(ListNode head, int n) {
        ListNode pre = new ListNode(-1, head);
        ListNode slow = head;
        ListNode fast = head;
        while(n > 0) {
            fast = fast.next;
            --n;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
            pre = pre.next;
        }
        pre.next = slow.next;
        return head;
    }
}
