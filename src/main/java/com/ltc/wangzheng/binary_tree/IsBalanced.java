package com.ltc.wangzheng.binary_tree;

/**
 * @author rwj
 * @create_time 2021/12/4
 * @description
 */
public class IsBalanced {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        System.out.println(isBalanced(n1));
    }

    static int minDepth = Integer.MAX_VALUE, maxDepth;

    public static boolean isBalanced(TreeNode root) {
        iterateLevel(root, 0);
        if(root != null && (root.left == null || root.right == null)) minDepth = 0;
        return maxDepth - minDepth <= 1;
    }

    public static void iterateLevel(TreeNode node, int depth) {
        if(node == null) return;
        maxDepth = Math.max(depth, maxDepth);
        if(node.left == null && node.right == null && depth < minDepth) minDepth = Math.min(minDepth, depth);
        iterateLevel(node.left, depth+1);
        iterateLevel(node.right, depth+1);
    }

}
