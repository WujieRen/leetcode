package com.ltc.wangzheng.binary_tree;

/**
 * @author rwj
 * @create_time 2021/12/1
 * @description
 */
public class MaxDepthRecursion {

    /** ----------------- 写法一，递的时候累计计算高度 ------------------- */

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

    /** ----------------- 写法一，递的时候累计计算高度 ------------------- */
    public int o2(TreeNode root) {
        return find(root);
    }

    public int find(TreeNode node) {
        if(node == null) return 0;
        return Math.max(find(node.left), find(node.right))+1;
    }

    //或者：
    public int o1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int a = o1(root.left);
        int b = o1(root.right);
        int c = Math.max(a, b);
        return c + 1;
    }

}
