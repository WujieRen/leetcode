package com.ltc.wangzheng.binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/11/24
 * @description 非递归写法有很多种，可以用一个栈来解决；也可以用两个栈来解决。
 *      但是核心都是要用到栈，因为root层节点是最后打印（先进后出）。
 *      以下是一个示例。
 */
public class PostorderTraversal {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7), new TreeNode(8))), new TreeNode(5)), new TreeNode(3));
        System.out.println(o1_m2(n1));
        System.out.println(o1(n1));
    }

    public static List<Integer> o1_m2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = cur;
        while(!stack.isEmpty() || cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if(cur.right != null && cur.right != pre) {
                    cur = cur.right;
                } else {
                    list.add(cur.val);
                    stack.pop();
                    pre = cur;
                    cur = null;
                }
            }

        }
        return list;
    }

    public static List<Integer> o1_m1(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = cur;
        while(!stack.isEmpty() || cur != null) {
//            while(cur != null) {
            if(cur != null) {
                stack.push(cur);
                cur = cur.left;
                continue;
            }
            cur = stack.peek();
            if(cur.right != null && cur.right != pre) {
                cur = cur.right;
            } else {
                list.add(cur.val);
                stack.pop();
                pre = cur;
                cur = null;
            }
        }
        return list;
    }

    public static List<Integer> o1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<Integer>();
        TreeNode cur = root;
        TreeNode p = null;
        while(!stack.isEmpty() || cur != null){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == p){
                list.add(cur.val);
                stack.pop();
                p = cur;
                cur = null;
            }else{
                cur = cur.right;
            }
        }
        return list;
    }
}
