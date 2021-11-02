package com.ltc.wangzheng.hash;

import com.ltc.wangzheng.ListNode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GetIntersectionNode {

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        List<ListNode> list = new LinkedList<ListNode>();
        while(headA != null) {
            list.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(list.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<ListNode>();
        while(headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while(headB != null) {
            if(set.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }
}
