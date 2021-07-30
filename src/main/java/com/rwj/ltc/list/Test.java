package com.rwj.ltc.list;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/7/30
 * @description
 */
public class Test {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;

        ListNode head = node1;
        System.out.println(hasCycle(head) + "<--->" + hasCycle2(head));
//        iterateList(head);

//        reverseList(head);
//        head = node5;
//        iterateList(head);

        ListNode a = new ListNode("a");
        ListNode b = new ListNode("b");
        ListNode c = new ListNode("c");
        ListNode C = new ListNode("c");
        ListNode B = new ListNode("ba");
        ListNode A = new ListNode("a");
        a.next = b;
        b.next = c;
        c.next = C;
        C.next = B;
//        c.next = B;
        B.next = A;
        iterateList(a);
//        System.out.println(isPalindrome(a));
        System.out.println(hasCycle(a) + "<--->" + hasCycle2(a));

        ListNode j = new ListNode("a");
        ListNode k = new ListNode("a");
        ListNode l = new ListNode("a");
        j.next = k;
        k.next = l;
        System.out.println(hasCycle(j) + "<--->" + hasCycle2(j));


//        System.out.println(Arrays.toString(getMiddleNode(head)));     //TODO: 环状链表会陷入死循环
        System.out.println(Arrays.toString(getMiddleNode(a)));
        System.out.println(Arrays.toString(getMiddleNode(j)));

        head = removeN(a, 2);
        iterateList(head);
    }

    /**
     * 删除链表的倒数第n个元素
     * @param head
     * @param n
     * @return
     */
    private static ListNode removeN(ListNode head, int n) {
        ListNode fast = head;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = fast;

        return head;
    }



    /**
     * 求链表的中间结点
     * @param head
     * @return
     */
    private static ListNode[] getMiddleNode(ListNode head) {
        ListNode[] nodes = new ListNode[2];
        ListNode fast = head;
        ListNode slow = head;
        boolean isDouble = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            if (fast != null) {
                slow = slow.next;
            }  else {
                isDouble = true;
            }
        }
        nodes[0] = slow;
        if(isDouble) nodes[1] = slow.next;
        return nodes;
    }


    /**
     * 链表中环的检测      OTHER
     *
     * @param head
     * @return
     */
    private static boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

    /**
     * 链表中环的检测   MYSELF
     *
     * @param head
     * @return
     */
    private static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
//            if(fast.val == slow.val) {            //TODO：一开始写的时候这里犯错了。虽然结果碰巧也对但是那是因为不同引用的值不一样。
//                                                      如果不同引用的值相同，那这种方式就永远只能返回true
                return true;
            }
        }
        return false;
    }

    /**
     * 遍历链表
     *
     * @param head
     */
    private static void iterateList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "\t");
            head = head.next;
        }
        System.out.println();
    }

    /**
     * 判断链表是否回文
     *
     * @param head
     * @return
     */
    private static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head;
        ListNode slow = head;
        // a b c b a
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

//        iterateList(slow);
        //TODO: 这里的方法只是对slow的副本进行操作；所里里面值的修改不会对这里的slow造成影响
//        System.out.println(slow.val+"---");
        //TODO: 所以这里如果要对比两个列表值是否相等，除了讲fast指向head外，slow也要执行另一个列表的head
        slow = reverseList(slow);
//        iterateList(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
//            if(!fast.val.equals(slow.val)) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }

        return true;
    }

    /**
     * 链表翻转
     *
     * @param head
     * @return 链表head元素
     */
    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
