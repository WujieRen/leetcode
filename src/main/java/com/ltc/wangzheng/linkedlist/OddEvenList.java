package com.ltc.wangzheng.linkedlist;

public class OddEvenList {
    public static void main(String[] args) {
//        ListNode h5 = new ListNode(5);
//        ListNode h4 = new ListNode(4);
//        ListNode h3 = new ListNode(3, h4);
//        ListNode h2 = new ListNode(2, h3);
//        ListNode h1 = new ListNode(1, h2);
        ListNode h1 = new ListNode(1);
        f1(h1).iterate(h1);
    }

    private static ListNode f1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode evenNode = head;   //偶数节点
        ListNode oddNode = head.next;    //奇数节点
        ListNode oddNodeHead = oddNode;
        while(oddNode.next != null && evenNode.next != null) {
            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;
        }
        evenNode.next = oddNodeHead;
        return head;
    }
}
