package com.ltc.wangzheng.hash;

import com.ltc.wangzheng.ListNode;

import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(head != null) {
            if(set.contains(head.next)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }
}
