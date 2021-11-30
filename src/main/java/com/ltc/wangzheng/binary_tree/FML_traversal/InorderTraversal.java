package com.ltc.wangzheng.binary_tree.FML_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/11/25
 * @description 二叉树中序遍历，非递归
 *
 *           1
 *        2    3
 *     4
 *        6
 *      7      8
 *        9     10
 *
 *          [4,7,9,6,8,10,2,1,3]
 *
 */
public class InorderTraversal {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7, null, new TreeNode(9)), new TreeNode(8, null, new TreeNode(10)))), null), new TreeNode(3));
        System.out.println(inorderTraversal(n1));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }

}
