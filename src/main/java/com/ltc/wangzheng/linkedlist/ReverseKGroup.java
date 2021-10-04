package com.ltc.wangzheng.linkedlist;

public class ReverseKGroup {
    public static void main(String[] args) {
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
//        ListNode l2 = new ListNode(2);
        ListNode l1 = new ListNode(1, l2);
//        ListNode l1 = null;
        ListNode.iterate(f1(l1, 1));
    }

    /**
     * @param head
     * @return 返回一个大小为2的ListNode数组；第一个值为链表的头节点；第二个值是链表的尾节点
     */
    private static ListNode[] reverstList(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode tmpTail = head;
        while (pre != tail) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
        }
        return new ListNode[]{pre, tmpTail};
    }


    private static ListNode f1(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        ListNode tail = dummyHead;
        ListNode tmpTail = head;
        while (tmpTail != null) {
            int cnt = 1;
            while (cnt < k && tmpTail != null) {
                tmpTail = tmpTail.next;
                ++cnt;
            }
            if (cnt == k && tmpTail != null) {
                ListNode nxt = tmpTail.next;
                ListNode[] resNode = reverstList(head, tmpTail);
                head = nxt;
                tmpTail = nxt;
                tail.next = resNode[0];
                tail = resNode[1];
            } else {
                tail.next = head;
            }
        }
        return dummyHead.next;
    }
}
