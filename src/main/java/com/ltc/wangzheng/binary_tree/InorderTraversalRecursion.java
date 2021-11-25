package com.ltc.wangzheng.binary_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/11/24
 * @description
 */
public class InorderTraversalRecursion {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7, null, new TreeNode(9)), new TreeNode(8, null, new TreeNode(10)))), null), new TreeNode(3));
        System.out.println(inorderTraversal(n1));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        inOrder(root, list);
        return list;
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if(root.left != null) inOrder(root.left, list);
        list.add(root.val);
        if(root.right != null) inOrder(root.right, list);
    }
}
