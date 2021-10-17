package com.ltc.wangzheng.sort;

import com.ltc.wangzheng.ListNode;

public class RecursionMergeSortList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(3, new ListNode(7, new ListNode(5, new ListNode(1, new ListNode(4))))));
        ListNode.iterate(sortList(n1));
    }

    public static ListNode sortList(ListNode head) {
        //1.从中间把连标分成两半
        //2。递归分，直到剩一个
        //3。merge
        if(head == null) return null;
        if(head.next == null) return head;
        ListNode middle = middleSpiltList(head);
        ListNode nextNode = middle.next;
        middle.next = null;
        ListNode leftHead = sortList(head);
        ListNode rightHead = sortList(nextNode);
        return mergeSort(leftHead, rightHead);
    }

    private static ListNode mergeSort(ListNode leftHead, ListNode rightHead) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while(leftHead != null && rightHead != null) {
            if(leftHead.val < rightHead.val) {
                pre.next = leftHead;
                leftHead = leftHead.next;
            } else {
                pre.next = rightHead;
                rightHead = rightHead.next;
            }
            pre = pre.next;
        }
        if(leftHead != null) pre.next = leftHead;
        if(rightHead != null) pre.next = rightHead;
        return dummy.next;
    }

    private static ListNode middleSpiltList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        //TODO： 以下是错误示范；会导致该程序进入死循环
        // 因为这个获取中点的节点是错误的，滞后一位
        // 当分解到 2--》3 时就会导致死循环：
        // 因为推退出件是head == null || head.next == null;
        // 而middleSpiltList获取到的永远是3，因为head=2;就导致永远不会满足结束循环的条件
        /*while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }*/
        return slow;
    }

}
