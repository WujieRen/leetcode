package com.ltc.wangzheng.linkedlist;

import java.math.BigDecimal;

public class AddTwoNumbers {
    public static void main(String[] args) {
//        [9]
//[1,9,9,9,9,9,9,9,9,9]
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))))))))));
//        l1 = reverseList(l1);
//        ListNode.iterate(l1);
//        l2 = reverseList(l2);
//        ListNode.iterate(l2);

        ListNode head = f1(l1, l2);
        ListNode.iterate(head);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }

    private static ListNode f1(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        BigDecimal num1 = new BigDecimal(0);
        BigDecimal ten = new BigDecimal(10);
        while(l1 != null) {
            num1 = num1.multiply(ten).add(new BigDecimal(l1.val));
//            num1 = num1 * 10 + l1.val;
            l1 = l1.next;
        }
        BigDecimal num2 = new BigDecimal(0);
        while(l2 != null) {
            num2 = num2.multiply(ten).add(new BigDecimal(l2.val));
//            num2 = num2 * 10 + l2.val;
            l2 = l2.next;
        }
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(Long.MAX_VALUE);
        char[] res = String.valueOf(num1.add(num2)).toCharArray();
        int len = res.length - 1;
        ListNode head = new ListNode(Integer.parseInt(Character.toString(res[len])));
        ListNode tail = head;
        for(int i = len - 1; i >= 0; --i) {
            tail.next = new ListNode(Integer.parseInt(Character.toString(res[i])));
            tail = tail.next;
        }
        return head;
    }
    //1000000000000000000000000000001
    //9223372036854775807
}
