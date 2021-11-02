package com.ltc.wangzheng.hash;

import com.ltc.wangzheng.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodes {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<Integer>();
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(head != null) {
            if(!set.contains(head.val)) {
                set.add(head.val);
                tail.next = head;
                tail = tail.next;
            }
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}
