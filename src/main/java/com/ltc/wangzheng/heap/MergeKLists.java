package com.ltc.wangzheng.heap;

import com.ltc.wangzheng.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author rwj
 * @create_time 2021/12/18
 * @description https://leetcode-cn.com/problems/merge-k-sorted-lists/
 *
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode n3 = new ListNode(2, new ListNode(6));
        ListNode[] nodes = new ListNode[]{n1, n2, n3};
        ListNode res = mergeKLists(nodes);
        System.out.println(res);
    }

    /**
     * 解法①：把所有元素放在一个list中，然后堆list进行排序；排序后的结果顺序把cur.next -> next
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> list = new ArrayList<>();
        for(int i = 0; i < lists.length; ++i) {
            ListNode cur = lists[i];
            while(cur != null) {
                list.add(cur);
                ListNode tmp = cur.next;
                cur.next = null;
                cur = tmp;
            }
        }
        if(list.size() == 0) return null;
        list.sort(Comparator.comparingInt(o -> o.val));
        ListNode pre = new ListNode();
        for(ListNode node : list) {
            pre.next = node;
            pre = pre.next;
        }
        return list.get(0);
    }

    /**
     * 解法②：按顺序把ListNode[]中的0和1合并为a，然后a和2合并成c...类比
     */

    /**
     * 解法③; 分治；每次合并俩相邻的；一层一层往上最后合并成一个
     */

    /**
     * 解法④; 利用优先级队列（优先级队列的本质就是一个堆，这里模拟一个小顶堆）；
     * 每次出队头，然后把出来的list.next再放入队列中；
     * 直到队列为空；
     */
    public static ListNode mergeKLists4(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> priQue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for(ListNode node : lists) if(node != null) priQue.offer(node);
        ListNode head = new ListNode(), tail = head;
        while(!priQue.isEmpty()) {
            ListNode cur = priQue.poll();
            if(cur.next != null) priQue.offer(cur.next);
            tail.next = cur;
            tail = tail.next;
        }
        return head.next;
    }


}
