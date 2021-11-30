package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.*;

/**
 * @author rwj
 * @create_time 2021/11/26
 * @description 按层遍历（从上到下打印二叉树），递归，结果以一维数组展示:
 *                  https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 */
public class LevelOrderFormArrayRecursion {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4, null, new TreeNode(6, new TreeNode(7), new TreeNode(8, new TreeNode(9), new TreeNode(10)))), new TreeNode(5)), new TreeNode(3));
        System.out.println(Arrays.toString(m1(n1)));
        System.out.println(Arrays.toString(m2(n1)));
    }

    //TODO: ---------------- 用 int[] 实现  -----------    还有个问题没解决：如果用递归的话，如何确定元素个数？

    public static int[] m1(TreeNode root) {
        int[] tmp = new int[1010];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        addNode(tmp, queue, 0);
        return tmp;
    }

    public static void addNode(int[] tmp, Queue<TreeNode> queue, int i) {
        if(queue.isEmpty()) return;
        TreeNode curNode = queue.poll();
        tmp[i] = curNode.val;
        if(curNode.left != null) queue.add(curNode.left);
        if(curNode.right != null) queue.add(curNode.right);
        addNode(tmp, queue, i+1);
    }

    //TODO: -----------------------  用 List 实现

    public static int[] m2(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        addNode(list, queue, 0);
        return list.stream().mapToInt(v -> v).toArray();
    }

    public static void addNode(List<Integer> list, Queue<TreeNode> queue, int i) {
//        if(queue.isEmpty() || queue.peek() == null) return;   //TODO： queue.isEmpty()的时候返回了为什么还会走到下面 queue.poll() 导致 NullPointerException
        if(queue.peek() == null) return;    //用这个更好，我的初始目的就是这样；
        TreeNode curNode = queue.poll();  //TODO: 这里注意如果没有元素的话queue.poll()的结果返回值是null；
                                            // TODO: 这会导致lis.add()报错： NullPointerException
                                            // TODO: 所以上一行要添加 queue.peek == null 过滤
        list.add(curNode.val);
        if(curNode.left != null) queue.add(curNode.left);
        if(curNode.right != null) queue.add(curNode.right);
        addNode(list, queue, i+1);
    }

}
