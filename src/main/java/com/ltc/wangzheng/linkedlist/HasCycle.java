package com.ltc.wangzheng.linkedlist;

public class HasCycle {
    public static void main(String[] args) {

    }
    private static boolean f1(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
}