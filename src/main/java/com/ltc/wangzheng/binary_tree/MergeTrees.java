package com.ltc.wangzheng.binary_tree;

/**
 * @author rwj
 * @create_time 2021/12/1
 * @description
 */
public class MergeTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1, root2);
    }

    public TreeNode merge(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) return null;
        if (node1 == null) return node2;
        if (node2 != null) {
            node1.val = node1.val + node2.val;
            node1.left = merge(node1.left, node2.left);
            node1.right = merge(node1.right, node2.right);
        }
        return node1;
    }
}
