package com.ltc.wangzheng.binary_tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/11/24
 * @description 二叉树后序遍历，递归
 */
public class PostorderTraversalRecursion {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        if(root == null) return list;
        postOrder(root, list);
        return list;
    }

    public void postOrder(TreeNode root, List<Integer> list) {
        if(root.left != null) postOrder(root.left, list);
        if(root.right != null) postOrder(root.right, list);
        list.add(root.val);
    }
}
