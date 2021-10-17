package com.ltc.wangzheng.sort.list;

import com.ltc.wangzheng.ListNode;

/**
 * @author rwj
 * @create_time 2021/10/16
 * @description
 */
public class MergeSortList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(1, new ListNode(5, new ListNode(3, new ListNode(3))))));
        ListNode.iterate(mergeSortList(n1));
    }

    private static ListNode mergeSortList(ListNode head) {
        int len = getLen(head);
        int step = 1;
        while (step < len) {
            ListNode dummy = new ListNode(-1);
            ListNode left = head, mid = left, oldTail = dummy;
            while (left != null) {
                int cnt = 1;
                while (cnt < step && mid != null) {
                    mid = mid.next;
                    cnt++;
                }
                if(mid == null || mid.next == null) {
                    oldTail.next = mid;
                    break;
                }
                cnt = 1;
                ListNode tail = mid.next;
                while (cnt < step && tail != null) {
                    tail = tail.next;
                    cnt++;
                }
                ListNode nextNode = null;
                if (tail != null) {
                    nextNode = tail.next;
                }
                ListNode[] headAndTail = mergeSort(left, mid, tail);
                oldTail.next = headAndTail[0];
                oldTail = headAndTail[1];
                left = nextNode;
                mid = left;
            }
            head = dummy.next;
            step *= 2;
        }
        return head;
    }

    private static ListNode[] mergeSort(ListNode left, ListNode mid, ListNode tail) {
        ListNode dummy = new ListNode(-1), pre = dummy;
        ListNode right = mid.next;
        mid.next = null;
        if(tail != null) {
            tail.next = null;
        }
        while (left != null && right != null) {
            if (left.val < right.val) {
                pre.next = left;
                left = left.next;
            } else {
                pre.next = right;
                right = right.next;
            }
            pre = pre.next;
        }
        if (left != null) {
            pre.next = left;
            pre = mid;
        }
        if (right != null) {
            pre.next = right;
            pre = tail;
        }
       /* while (left != null) {
            pre.next = left;
            pre = pre.next;
            left = left.next;
        }
        while (right != null) {
            pre.next = right;
            pre = pre.next;
            right = right.next;
        }*/
        return new ListNode[]{dummy.next, pre};
    }

    private static int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }

}
