package com.ltc.wangzheng.linkedlist;

public class GetIntersectionNode {
    public static void main(String[] args) {
        ListNode h5 = new ListNode(5);
        ListNode h4 = new ListNode(4, h5);
        ListNode h3 = new ListNode(8, h4);
        ListNode h2 = new ListNode(1, h3);
        ListNode h1 = new ListNode(4, h2);
        ListNode.iterate(h1);

//        ListNode n1 = new ListNode(1, h3);
//        ListNode n6 = new ListNode(6, n1);
//        ListNode n5 = new ListNode(5, n6);
        ListNode n5 = new ListNode(5);
        ListNode.iterate(n5);

        ListNode.iterate(f1(h1, n5));
    }

    private static int getListSize(ListNode head) {
        int cnt = 0;
        while (head != null) {
            head = head.next;
            ++cnt;
        }
        return cnt;
    }

    private static ListNode skipToHead(ListNode head, int k) {
        while (k > 0) {
            head = head.next;
            --k;
        }
        return head;
    }

    private static ListNode f1(ListNode headA, ListNode headB) {
        int aSize = getListSize(headA);
        int bSize = getListSize(headB);
        int skipSize = Math.abs(aSize - bSize);
        if (aSize > bSize) {
            headA = skipToHead(headA, skipSize);
        } else {
            headB = skipToHead(headB, skipSize);
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }
}
