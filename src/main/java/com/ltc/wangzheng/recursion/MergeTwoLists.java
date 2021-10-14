package com.ltc.wangzheng.recursion;

import com.ltc.wangzheng.ListNode;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class MergeTwoLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode n2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        ListNode.iterate(mergeTwoLists(n1, n2));
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while(l1 != null && l2 != null) {
            if(l1.val >= l2.val) {
                pre.next = l2;
//                pre = l2;
                l2 = l2.next;
            } else {
                pre.next = l1;
//                pre = l1;
                l1 = l1.next;
            }
            pre = pre.next;
        }
        if(l2 == null) pre.next = l1;
        if(l1 == null) pre.next = l2;
        return head.next;
    }
}
