package com.ltc.wangzheng.sort.list;

import com.ltc.wangzheng.ListNode;


/**
 * @author rwj
 * @create_time 2021/10/15
 * @description 选择排序实现链表排序
 */
public class SelectSortList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(3))))));
        n1 = selectSortList(n1);
        ListNode.iterate(n1);
    }

    public static ListNode selectSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode  tail = head, iterator = tail, min = head;
        while(tail != null) {
            while(iterator != null) {
                if(iterator.val < min.val)  min = iterator;
                iterator = iterator.next;
            }
            swapVal(tail, min);
            tail = tail.next;
            min = tail;
            iterator = tail;
        }
        return head;
    }

    public static void swapVal(ListNode tail, ListNode min) {
        int tmp = tail.val;
        tail.val = min.val;
        min.val = tmp;
    }

}
