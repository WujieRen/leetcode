package com.ltc.wangzheng.binary_tree.max_diameter;

import com.ltc.wangzheng.binary_tree.TreeNode;

/**
 * @author rwj
 * @create_time 2021/12/16
 * @description https://leetcode-cn.com/problems/diameter-of-binary-tree/
 *
 */
public class DiameterOfBinaryTree {

    /**
     * 这是一开始我的写法
     */
    int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        /*int left = getHigh(root.left);
        int right = getHigh(root.right);
        return Math.max(left + right, maxDiameter);*/

        //以下是看了别人的写法后的优化写法
        getHigh(root);
        return maxDiameter;
    }
    public int getHigh(TreeNode node) {
        if (node == null) return 0;
        int left = getHigh(node.left);
        int right = getHigh(node.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }

    /**
     * 看到另外一种写法
     */
    int re = 0;
    public int diameterOfBinaryTree2(TreeNode root) {
        resursion(root);
        return re;
    }
    //以每一个节点为根节点计算左到右最大的路径
    public int resursion(TreeNode root) {
        if (root == null) return 0;
        //左树最大值
        int leftNum = resursion(root.left);
        //右树最大值
        int rightNum = resursion(root.right);
        re = Math.max(leftNum + rightNum, re);
        return Math.max(leftNum, rightNum) + 1;
    }
}
