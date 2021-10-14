package com.ltc.wangzheng.linkedlist;

import com.ltc.wangzheng.ListNode;

public class MergeTwoLists {
    public static void main(String[] args) {

    }

    private static ListNode f2(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(-1);
        ListNode pre = header;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            }
            else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }
        pre.next = l1 == null ? l2 : l1;
        return header.next;
    }

    private static ListNode f1(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode header = new ListNode(-1);
        header.next = l1.val <= l2.val ? l1 : l2;
        ListNode pre = header;
        while(l1 != null && l2 != null) {
            while(l1 != null && l2 != null && l1.val <= l2.val) {
                l1 = l1.next;
                pre = pre.next;
            }
            pre.next = l2;
            while(l1 != null && l2 != null && l2.val <= l1.val) {
                l2 = l2.next;
                pre = pre.next;
            }
            pre.next = l1;
        }
        if(l1 == null) pre.next = l2;
        if(l2 == null) pre.next = l1;
        return header.next;
    }
}
