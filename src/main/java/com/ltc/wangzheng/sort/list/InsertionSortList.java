package com.ltc.wangzheng.sort.list;

import com.ltc.wangzheng.ListNode;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description 插入排序实现链表排序
 */
public class InsertionSortList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(3))))));
        ListNode.iterate(insertionSortList(n1));
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode left = dummy, right = head;
        while(right != null) {
            while(left.next != null && right.val > left.next.val) {
                left = left.next;
            }
            ListNode nxt = right.next;
            right.next = left.next;
            left.next = right;
            right = nxt;
            left = dummy;
        }
        return dummy.next;
    }
}
