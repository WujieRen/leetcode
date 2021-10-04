package com.ltc.wangzheng.linkedlist;

public class MiddleNode {
    public static void main(String[] args) {

    }
    private static ListNode f1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
