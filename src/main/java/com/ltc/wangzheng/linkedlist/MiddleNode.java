package com.ltc.wangzheng.linkedlist;

import com.ltc.wangzheng.ListNode;

public class MiddleNode {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(3, new ListNode(7, new ListNode(5, new ListNode(1, new ListNode(4))))));
        ListNode mid = f1(n1);
        System.out.println(mid.val);
        ListNode m2 = f2(n1);
        System.out.println(m2.val);
    }

    //TODO: 错误示范！！！
    private static ListNode f1(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //TODO：这个才是正确的
    private static ListNode f2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
