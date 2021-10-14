package com.ltc.wangzheng.recursion;

import com.ltc.wangzheng.ListNode;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class ReversePrint1 {
    public int[] reversePrint(ListNode head) {
        ListNode pre = null;
        int cnt = 0;
        while(head != null) {
            ListNode nxt = head.next;
            head.next = pre;
            pre = head;
            head = nxt;
            cnt++;
        }
        int[] res = new int[cnt];
        cnt = 0;
        while(pre != null) {
            res[cnt++] = pre.val;
            pre = pre.next;
        }
        return res;
    }
}
