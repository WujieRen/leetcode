package com.ltc.wangzheng.binary_tree;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/11/24
 * @description 二叉树前序遍历，非递归
 */
public class PreorderTraversal {

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7), new TreeNode(8))), new TreeNode(5)), new TreeNode(3));
//        System.out.println(preorderTraversal(n1));
        System.out.println(o3(n1));
        System.out.println(o2(n1));
    }

    public static List<Integer> o1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return list;
    }

    public static List<Integer> o3(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) return res;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode node = root;
        while (!stack.isEmpty() || node != null) {
            while (node != null) {
                res.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }
        return res;
    }

    public static List<Integer> o2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                list.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop().right;
        }
        return list;
    }

}
