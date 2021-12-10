package com.ltc.wangzheng.binary_tree;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/12/10
 * @description  https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 *      出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 *      提醒一下，二叉搜索树满足下列约束条件：
 *          节点的左子树仅包含键 小于 节点键的节点。
 *          节点的右子树仅包含键 大于 节点键的节点。
 *          左右子树也必须是二叉搜索树。
 *      来源：力扣（LeetCode）
 *      链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
 */
public class ConvertBST {

    //TODO: 递归解法， 本质还是利用二叉搜索树的中序遍历有序性
    int sum;
    public TreeNode convertBST(TreeNode root) {
        addV(root);
        return root;
    }
    public void addV(TreeNode node) {
        if (node == null) return;
        addV(node.right);
        node.val +=  sum;
        sum = node.val;
        addV(node.left);
    }

    //TODO: 非递归解法， 本质还是利用二叉搜索树的中序遍历有序性
    public TreeNode o1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int sum = 0;
        while(cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            cur.val += sum;
            sum = cur.val;
            cur = cur.left;
        }
        return root;
    }

}
