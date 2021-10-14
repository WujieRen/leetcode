package com.ltc.wangzheng.recursion;

import com.ltc.wangzheng.ListNode;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class ReversePrint {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(3, new ListNode(2)));
        ListNode.iterate(n1);
        n1 = reverseList(n1);
        ListNode.iterate(n1);
        System.out.println(Arrays.toString(reversePrint(n1)));
    }

    public static int[] reversePrint(ListNode head) {
        if(head == null) return new int[1];
        int[] ary = new int[10000];
        head = reverseList(head);
        int cnt = 0;
        while(head != null) {
            ary[cnt++] = head.val;
            head = head.next;
        }
        return ary;
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while(head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return pre;
    }
}
