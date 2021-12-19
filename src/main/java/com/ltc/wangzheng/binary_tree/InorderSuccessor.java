package com.ltc.wangzheng.binary_tree;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/12/9
 * @description
 *      设计一个算法，找出二叉搜索树中指定节点的“下一个”节点（也即中序后继）。
 *      如果指定节点没有对应的“下一个”节点，则返回null。
 *
 *      https://leetcode-cn.com/problems/successor-lcci/
 */
public class InorderSuccessor {

    //TODO: 非递归解法，本质还是利用二叉查找树的中序遍历有序性，当找到相等的值得时候，用标志位进行过滤提取下一个值
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        boolean flag = false;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(flag) return cur;
            if(cur == p) flag = true;
            cur = cur.right;
        }
        return cur;
    }

    //TODO: 递归解法，本质还是利用二叉查找树的中序遍历有序性，当找到相等的值得时候，用标志位进行过滤提取下一个值
    TreeNode res;
    boolean flag = false;
    public TreeNode m1(TreeNode root, TreeNode p) {
        find(root, p);
        return res;
    }
    public void find(TreeNode root, TreeNode p) {
        if (root == null || res != null) return;
        find(root.left, p);
        if(res == null && flag) res = root;
        if(root == p) flag = true;
        find(root.right, p);
    }

    //TODO: 别人解法①：根据二叉查找树左子树一定比父节点小，右子树一定比父节点大的特点，剪枝，减少查找结点的数量
    public TreeNode o1(TreeNode root, TreeNode p) {
        if(root == null || p == null) return null;
        TreeNode res = null;
        /*if(p.right != null) {
            p = p.right;
            while(p != null) {
                res = p;
                p = p.left;
            }
            return res;
        }*/
        //注释掉的部分也可以这样写
        if(p.right != null) {
            res = p.right;
            while(res.left != null) res = res.left;
            return res;
        }
        while(root != null) {
            if(root == p) return res;
            if(root.val > p.val) {
                res = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    /** 争哥的解法 */
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        TreeNode candidate = null;
        TreeNode q = root;
        while(q != null) {
            if(q.val > p.val) {
                candidate = q;
                q = q.left;
            } else {
                q = q.right;
            }
        }
        return candidate;
    }

}
