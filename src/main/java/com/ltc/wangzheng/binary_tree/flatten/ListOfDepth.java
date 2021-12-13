package com.ltc.wangzheng.binary_tree.flatten;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author rwj
 * @create_time 2021/12/13
 * @description https://leetcode-cn.com/problems/list-of-depth-lcci/
 * 给定一棵二叉树，设计一个算法，创建含有某一深度上所有节点的链表（比如，若一棵树的深度为 D，则会创建出 D 个链表）。返回一个包含所有深度的链表的数组。
 */
public class ListOfDepth {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        listOfDepth(n1);
        System.out.println(res);
        preOrder(n1, 0);
        System.out.println(rst);
        rst.toArray(new ListNode[0]);
        System.out.println(rst);
    }
    /**  --------------------------- 一看就是按层遍历。解法①，非递归 -------------------    */
    static List<ListNode> res = new ArrayList<>();
    public static ListNode[] listOfDepth(TreeNode tree) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode pre = new ListNode(Integer.MIN_VALUE), listNode, head = pre;
            for (int i = 0; i < size; ++i) {
                TreeNode cur = queue.poll();
                listNode = new ListNode(cur.val);
                pre.next = listNode;
                pre = pre.next;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(head.next);
        }
//        return res.toArray(new ListNode[res.size()]);
        return res.toArray(new ListNode[0]);
    }

    /**  --------------------------- 一看就是按层遍历。解法②，递归 -------------------   */
    static List<ListNode> rst = new ArrayList<>();
    public static void preOrder(TreeNode node, int depth) {
        if(node == null) return;
        if(rst.size() == depth) rst.add(new ListNode(node.val));
        else {
            ListNode tmp = rst.get(depth);
            while(tmp.next != null) tmp = tmp.next;
            tmp.next = new ListNode(node.val);
        }
        preOrder(node.left, depth+1);
        preOrder(node.right, depth+1);
    }

}
