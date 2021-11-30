package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/11/25
 * @description 按层遍历（从上到下打印二叉树），非递归，结果以一维数组展示:
 *                  https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 *
 *              1. 以队列实现；
 *              2. 以栈实现；两个栈模拟队列效果
 */
public class LevelOrderFormArray {

    /**
     * o1_m1耗时3ms，o1_m2耗时0ms；主要耗时花在list转int[]上；
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        TreeNode n2 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7), new TreeNode(8, new TreeNode(9), new TreeNode(10)))), new TreeNode(5)), new TreeNode(3));
        System.out.println(Arrays.toString(o1_m1(n1)));
        System.out.println(Arrays.toString(o1_m2(n2)));
    }

    /**
     * 执行时间：0ms
     * @param root
     * @return
     */
    public static int[] o1_m2(TreeNode root) {
        if(root == null) return new int[]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int[] tmp = new int[1010];
        int i = 0;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            tmp[i++] = cur.val;
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null)  queue.add(cur.right);
//            ++i;
        }
        int[] res = new int[i];
        System.arraycopy(tmp, 0, res, 0, i);
        return res;
    }

    /**
     * 执行时间： 3ms
     * @param root
     * @return
     */
    public static int[] o1_m1(TreeNode root) {
        if(root == null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> list = new LinkedList<>();
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            list.add(cur.val);
            if(cur.left != null) queue.add(cur.left);
            if(cur.right != null)  queue.add(cur.right);
        }
        return list.stream().mapToInt(v -> v).toArray();
    }

}
