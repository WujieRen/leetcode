package com.ltc.wangzheng.linkedlist;

import com.ltc.wangzheng.ListNode;

public class GetKthFromEnd {
    public static void main(String[] args) {

    }

    private static ListNode f1(ListNode head, int k) {
        ListNode slow = head;
        ListNode fast = head;
        while(k > 0) {
            fast = fast.next;
            --k;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
