package com.ltc.wangzheng.binary_tree;

/**
 * @author rwj
 * @create_time 2021/12/3
 * @description
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    public void invert(TreeNode node) {
        if(node == null) return;
        if(node.left == null && node.right == null) return;
        TreeNode lNode = node.left;
        TreeNode rNode = node.right;
        node.left = rNode;
        node.right = lNode;
        invert(lNode);
        invert(rNode);
    }
}
