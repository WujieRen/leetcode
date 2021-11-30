package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rwj
 * @create_time 2021/11/26
 * @description 按层遍历（从上到下打印二叉树），递归，结果以二维数组展示:
 *                   https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 */
public class LevelOrderFormMultiDimAryRecursion {

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7), new TreeNode(8, new TreeNode(9), new TreeNode(10)))), new TreeNode(5)), new TreeNode(3));
        System.out.println(levelOrder(n2));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, list);
        return list;
    }

    public static void dfs(TreeNode node, int high, List<List<Integer>> list) {
        if(node == null) return;
        /**
         * 如果下面这行给ArrayList限制了大笑的话，会报：超出内存限制
         * 一般情况下，如果可以确定ArrayList的元素个数，最好给定一个值，这样可以减少扩容的次数，提升效率；
         * 但是在数据规模不确定的情况下活着有条件限制的情况下，就要结合具体情况看。
         */
//        if(list.size() == high) list.add(high, new ArrayList<>((int)Math.pow(2, high)));
        if(list.size() == high) list.add(high, new ArrayList<>());
        list.get(high).add(node.val);
        dfs(node.left, high+1, list);
        dfs(node.right, high+1,  list);
    }

}
