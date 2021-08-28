package com.rwj.ltc.list;

/**
 * @author rwj
 * @create_time 2021/8/27
 * @description
 */
public class MergeTwoOrdereddList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n1_2 = new ListNode(5);
        ListNode n1_3 = new ListNode(8);
        n1.next = n1_2;
        n1_2.next = n1_3;
        ListNode n2 = new ListNode(2);
        ListNode n2_2 = new ListNode(3);
        ListNode n2_3 = new ListNode(7);
        n2.next = n2_2;
        n2_2.next = n2_3;
//        ListNode res = mergeTwoOrderedList(n1, n2);
//        ListNode res = othersWay1(n1, n2);
        ListNode res = recursionMerge(n1, n2);
        Test.iterateList(res);
    }

    /**
     * 自己实现的方式①
     *
     * @param n1
     * @param n2
     * @return
     */
    private static ListNode mergeTwoOrderedList(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (n1 != null && n2 != null) {
            ListNode n1Next = n1.next;
            ListNode n2Next = n2.next;
            Integer n1Val = (Integer) n1.val;
            Integer n2Val = (Integer) n2.val;
            if (n1Val < n2Val) {
                pre.next = n1;
                n1.next = n2;
                pre = n2;
            } else {
                pre.next = n2;
                n2.next = n1;
                pre = n1;
            }

            n1 = n1Next;
            n2 = n2Next;
        }

        if (n1 == null) pre.next = n2;
        if (n2 == null) pre.next = n1;

        return dummy.next;
    }

    /**
     * 别人的代码
     *
     * @param n1
     * @param n2
     * @return
     */
    private static ListNode othersWay1(ListNode n1, ListNode n2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (n1 != null && n2 != null) {
            if ((Integer) n1.val < (Integer) n2.val) {
                pre.next = n1;
                n1 = n1.next;
                pre = pre.next;
            } else {
                pre.next = n2;
                n2 = n2.next;
                pre = pre.next;
            }
        }
        if (n1 == null) pre.next = n2;
        if (n2 == null) pre.next = n1;
        return dummy.next;
    }

    /**
     * 递归思路
     * @param n1
     * @param n2
     * @return
     */
    private static ListNode recursionMerge(ListNode n1, ListNode n2) {
        if (n1 == null) return n2;
        if (n2 == null) return n1;
        if ((Integer) n1.val < (Integer) n2.val) {
            n1.next = recursionMerge(n1.next, n2);
            return n1;
        } else {
            n2.next = recursionMerge(n1, n2.next);
            return n2;
        }
    }


}