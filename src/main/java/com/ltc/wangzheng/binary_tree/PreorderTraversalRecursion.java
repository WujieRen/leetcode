package com.ltc.wangzheng.binary_tree;

import lombok.val;

import java.util.LinkedList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/11/15
 * @description
 */
public class PreorderTraversalRecursion {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new LinkedList<>();
//        if(root == null) return list;
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        if(root.left != null) preOrder(root.left, list);
        if(root.right != null) preOrder(root.right, list);
    }
}
