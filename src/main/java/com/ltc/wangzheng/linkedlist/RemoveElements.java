package com.ltc.wangzheng.linkedlist;

public class RemoveElements {
    public static void main(String[] args) {

    }

    private ListNode f2(ListNode head, int val) {
        ListNode header = new ListNode(-1, head);
        ListNode pre = header;
        while(head != null) {
            if(head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return header.next;
    }

    private ListNode f1(ListNode head, int val) {
        if(head == null) return null;
        ListNode tmp = head;
        ListNode pre = head;
        while (tmp != null) {
            if(tmp.val == val) {
                pre.next = tmp;
            } else {
                pre = tmp;
            }
            tmp = tmp.next;
        }
        return head.val == val ? head.next : head;
    }
}
