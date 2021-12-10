package com.ltc.wangzheng.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/12/9
 * @description 给定一棵二叉搜索树，请找出其中第k大的节点。
 */
public class KthLargest {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4));
        System.out.println();
    }

    //TODO: -------------------------  解法①（1ms）：中序遍历升序，取出第k大    ---------------------------------
    List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        addList(root);
        return list.get(list.size()-k);
    }

    public void addList(TreeNode node) {
        if(node == null) return;
        addList(node.left);
        list.add(node.val);
        addList(node.right);
    }

    //-------------------------  解法①优化（1ms）：中序遍历降序，取出第k大    ---------------------------------
    public int kthLargest1(TreeNode root, int k) {
        addList1(root, k);
        return list.get(k-1);
    }
    public void addList1(TreeNode node, int k) {
        if(node == null || list.size() == k) return;
        addList1(node.right, k);
        list.add(node.val);
        addList1(node.left, k);
    }

    //-------------------------  解法①继续优化（0ms）：中序遍历降序，取出第k大    ---------------------------------
    int res, cnt;
    public int kthLargest2(TreeNode root, int k) {
        addList2(root, k);
        return res;
    }
    public void addList2(TreeNode node, int k) {
        if(node == null || cnt == k) return;
        addList2(node.right, k);
        if(++cnt == k) {
            res = node.val;
        }
        addList2(node.left, k);
    }

}
