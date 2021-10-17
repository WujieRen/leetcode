package com.ltc.wangzheng.sort.list;

import com.ltc.wangzheng.ListNode;

/**
 * @author rwj
 * @create_time 2021/10/15
 * @description
 */
public class BubbleSortList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(3))))));
        n1 = bublleSortList(n1);
        ListNode.iterate(n1);
    }

    public static ListNode bublleSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode iterator = head, tail = head;
        while (tail != null) {
            while (iterator.next != null) {
                if(iterator.next.val < iterator.val) {
                    int tmp = iterator.val;
                    iterator.val = iterator.next.val;
                    iterator.next.val = tmp;
                }
                iterator = iterator.next;
            }
            iterator = head;
            tail = tail.next;
        }
        return head;
    }

}
