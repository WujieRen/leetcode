package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/11/26
 * @description 按层遍历（从上到下打印二叉树），非递归，结果以二维数组展示:
 *  *                  https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 *
 *                  1. 以队列实现；
 *                  2. 以栈实现：用两个栈模拟一个队列的效果；
 */
public class LevelOrderFormMultiDimensionalArray {

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7), new TreeNode(8, new TreeNode(9), new TreeNode(10)))), new TreeNode(5)), new TreeNode(3));
        System.out.println(levelOrderWithQueue(n2));
        System.out.println(levelOrderWithStacks(n2));
    }

    /**
     * 1. 以队列实现
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderWithQueue(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                subList.add(cur.val);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            list.add(subList);
        }
        return list;
    }

    /**
     * 2. 用栈实现，用两个栈模拟一个队列的效果
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderWithStacks(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        Stack<TreeNode> leftStack = new Stack<>();
        leftStack.push(root);
        Stack<TreeNode> rightStack = new Stack<>();
        while(!leftStack.isEmpty()) {
//            List<Integer> subList = new ArrayList<>(leftStack.size());  //也可以用ArrayList，但是只要用和数组相关的数据结构；最好要指定元素个数，这是一个能提升性能的优化！！！
            List<Integer> subList = new LinkedList<>();
            while(!leftStack.isEmpty()) {
                TreeNode curLeftNode = leftStack.pop();
                subList.add(curLeftNode.val);
                rightStack.push(curLeftNode);
            }
            list.add(subList);
            while(!rightStack.isEmpty()) {
                TreeNode curRightNode = rightStack.pop();
                if(curRightNode.right != null) leftStack.push(curRightNode.right);
                if(curRightNode.left != null) leftStack.push(curRightNode.left);
            }
        }
        return list;
    }


}
