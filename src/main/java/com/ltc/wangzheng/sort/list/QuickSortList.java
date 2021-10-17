package com.ltc.wangzheng.sort.list;

import com.ltc.wangzheng.ListNode;

/**
 * @author rwj
 * @create_time 2021/10/15
 * @description
 */
public class QuickSortList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(3))))));
        ListNode.iterate(quickSortList(n1));
    }

    public static ListNode quickSortList(ListNode head) {

        return head;
    }
}
