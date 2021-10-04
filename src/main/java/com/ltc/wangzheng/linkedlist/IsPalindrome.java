package com.ltc.wangzheng.linkedlist;

public class IsPalindrome {
    public static void main(String[] args) {

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

    private static ListNode getMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static boolean f1(ListNode head) {
        ListNode midNode = getMidNode(head);
        ListNode reversedHeadNode = reverseList(midNode);
        while (head != null) {
            if(head.val != reversedHeadNode.val) {
                return false;
            }
            head = head.next;
            reversedHeadNode = reversedHeadNode.next;
        }
        return true;
    }
}
