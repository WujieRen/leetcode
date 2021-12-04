package com.ltc.wangzheng.binary_tree;

/**
 * @author rwj
 * @create_time 2021/12/1
 * @description
 */
public class MaxDepthRecursion {

    public int o1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = o1(root.left);
        int b = o1(root.right);
        int c = Math.max(a, b);
        return c + 1;
    }


    /** ----------------- 写法一 ------------------- */

    int maxDepth;

    public int m1(TreeNode root) {
        find(root, 0);
        return maxDepth;
    }

    public void find(TreeNode node, int depth) {
        if(node == null) return;
        if(depth > maxDepth) maxDepth = depth;
        if(node.left != null) find(node.left, depth+1);
        if(node.right != null) find(node.right, depth+1);
    }
}
