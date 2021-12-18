package com.ltc.wangzheng.binary_tree.max_diameter;

import com.ltc.wangzheng.binary_tree.TreeNode;

/**
 * @author rwj
 * @create_time 2021/12/16
 * @description https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/
 *
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * 路径和 是路径中各节点值的总和。
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-maximum-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxPathSum {
    int maxPathNum = 0;
    public int maxPathSum(TreeNode root) {
        getHighVal(root);
        return maxPathNum;
    }
    public int getHighVal(TreeNode node) {
        if(node == null) return 0;
        int left = Math.max(0, getHighVal(node.left));
        int right = Math.max(0, getHighVal(node.right));
        maxPathNum = Math.max(maxPathNum, left+right+node.val);
        return Math.max(left, right) + node.val;
    }
}
