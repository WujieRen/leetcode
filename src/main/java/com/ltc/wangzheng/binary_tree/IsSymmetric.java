package com.ltc.wangzheng.binary_tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/12/8
 * @description
 */
public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return certificate(root.left, root.right);
    }

    /**
     * --------------解法①：递归交叉验证左右节点
     */
    public boolean certificate(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        /*if (left.val != right.val) return false;
        return certificate(left.left, right.right) && certificate(left.right, right.left);*/
        return left.val == right.val && certificate(left.left, right.right) && certificate(left.right, right.left);
    }

    /**
     * 解法②：层序遍历，放到一个双端队列里，
     * 如果队列大小为奇数，直接 return false
     * 如果是偶数，判断是否镜像对称——这里要注意，只判断回文是不够的，还要判断值的位置；
     * 值的位置由两点确定：
     *      1. 是左节点还是右节点；
     *      2. 当节点都相等且左右也能对上时，它们的父节点也要相等才行；
     * 不满足以上条件则不是镜像对称，如；
     *                        2
     *                3             3
     *            4      5        5    4
     *                 8   9         9  8
     */
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2), null);
        System.out.println(isSymmetric2(n1));

    }

    static class WrappedNode {
        TreeNode node;
        int flag;
        int parentV;

        WrappedNode(TreeNode node, int flag, int parentV) {
            this.node = node;
            this.flag = flag;
            this.parentV = parentV;
        }
    }
    public static boolean isSymmetric2(TreeNode root) {
        if (root == null) return true;
        Queue<WrappedNode> que = new LinkedList<>();
        if (root.left != null) que.add(new WrappedNode(root.left, -1, root.val));
        if (root.right != null) que.add(new WrappedNode(root.right, 1, root.val));
        Stack<WrappedNode> stack = new Stack();
        while (!que.isEmpty()) {
            int size = que.size();
            if (size % 2 != 0) {
                return false;
            }
            for (int i = 0; i < size; ++i) {
                WrappedNode wrap = que.poll();
                TreeNode cur = wrap.node;
                if (cur.left != null) que.add(new WrappedNode(cur.left, -1, cur.val));
                if (cur.right != null) que.add(new WrappedNode(cur.right, 1, cur.val));
                if (i < size / 2) {
                    stack.push(wrap);
                    continue;
                }
                if (cur != root) {
                    WrappedNode st = stack.pop();
                    if (cur.val != st.node.val || wrap.flag + st.flag != 0 || wrap.parentV != st.parentV) return false;
                }
            }
        }
        return true;
    }


}
