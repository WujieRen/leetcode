package com.ltc.wangzheng.binary_tree.max_diameter;

import com.ltc.wangzheng.binary_tree.TreeNode;

/**
 * @author rwj
 * @create_time 2021/12/17
 * @description
 */
public class PathSumAll {

    int sum;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return 0;
        inner(root, targetSum);
        if(root.left != null) pathSum(root.left, targetSum);
        if(root.right != null) pathSum(root.right, targetSum);
        return sum;
    }
    public void inner(TreeNode node, int targetSum) {
        if(node == null) return;
        if(node.val == targetSum) ++sum;
        inner(node.left, targetSum-node.val);
        inner(node.right,  targetSum-node.val);
    }
}
