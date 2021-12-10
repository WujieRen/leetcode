package com.ltc.wangzheng.binary_tree;

/**
 * @author rwj
 * @create_time 2021/12/8
 * @description
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return certificate(root.left, root.right);
    }

    public boolean certificate(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        /*if (left.val != right.val) return false;
        return certificate(left.left, right.right) && certificate(left.right, right.left);*/
        return left.val == right.val && certificate(left.left, right.right) && certificate(left.right, right.left);
    }
}
