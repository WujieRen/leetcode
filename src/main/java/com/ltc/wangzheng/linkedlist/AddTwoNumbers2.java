package com.ltc.wangzheng.linkedlist;

import com.ltc.wangzheng.ListNode;

public class AddTwoNumbers2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = null;
        ListNode.iterate(f1(l1, l2));
    }

    private static int get2NodeAndSum(ListNode l1, ListNode l2, int carry) {
        int num1 = l1 == null ? 0 : l1.val;
        int num2 = l2 == null ? 0 : l2.val;
        return num1 + num2 + carry;
    }

    private static ListNode f1(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        int carry = 0;
        while(l1 != null || l2 != null) {
//            int num1 = l1 == null ? 0 : l1.val;
//            int num2 = l2 == null ? 0 : l2.val;
//            int res = num1 + num2 + carry;
            int res = get2NodeAndSum(l1, l2, carry);
            int newNum = res % 10;
            newTail.next = new ListNode(newNum);
            newTail = newTail.next;
            carry = res / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if(carry > 0) {
            newTail.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
