package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/11/29
 * @description
 *              1
 *           2    3
 *         4  5
 *              6
 *            7
 */
public class FindBottomLeftValue {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, new TreeNode(5), new TreeNode(6, null, new TreeNode(7))));
//        System.out.println(findBottomLeftValue(n1));
        System.out.println(o_m1(n1));
        System.out.println(m2(n1));
        System.out.println(o3(n1));
    }

    static int res,maxDepth;
    public static int o_m2(TreeNode root) {
        iteral(root, 0);
        return res;
    }
    public static void iteral(TreeNode node, int depth) {
        if(node == null) return ;
        if(depth > maxDepth) {
            maxDepth = depth;
            res = node.val;
        } //TODO: 以上部分的代码是可以优化的；只有当节点左右节点都是null的时候才执行比较和复制的操作
        iteral(node.left, depth+1);
        iteral(node.right, depth+1);
    }

    public static int o_m1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = root.val;
        while(!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            res = cur.val;
            if(cur.right != null) queue.add(cur.right);
            if(cur.left != null) queue.add(cur.left);
        }
        return res;
    }

    public static int o3(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            if(root.right != null) queue.add(root.right);
            if(root.left != null) queue.add(root.left);
        }
        return root.val;
    }

    /**
     * 前两个方法一直在用深度优先式的方式，从浅到深再从左到右来寻找；结果一直是不好处理；
     * 看评论提到可以广度优先，先从左到右，再从浅到深；每次拿到每一层的第一个值，就是最左边的值。
     * @param root
     * @return
     */
    public static int m2(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        stack1.push(root);
        Stack<TreeNode> stack2 = new Stack<>();
        int res = root.val;
        while(!stack1.isEmpty()) {
            int i = 0;
            while(!stack1.isEmpty()) {
                TreeNode cur = stack1.pop();
                if(i == 0) res = cur.val;
                stack2.push(cur);
                ++i;
            }
            while(!stack2.isEmpty()) {
                TreeNode cur = stack2.pop();
                if(cur.right != null) stack1.push(cur.right);
                if(cur.left != null) stack1.push(cur.left);
            }
        }
        return res;
    }

    /**
     *
     * @param root
     * @return
     */
    public static int m1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root.left;
        int deep = 0, leftV = 0;
        boolean flag = false;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if (stack.size() > deep) {
                deep = stack.size();
                leftV = cur.val;
            }
            if (cur.right == null) cur = stack.pop().right;
            else cur = stack.peek().right;
        }
        return leftV;
    }

    public static int findBottomLeftValue(TreeNode root) {
        int i = 0, j = 0, leftV = 0, rightV = 0;
        if (root.left != null) {
            TreeNode leftN = root.left, pre = root;
            while (leftN.left != null) {
                while (leftN.left != null) {
                    pre = leftN;
                    leftN = leftN.left;
                    ++i;
                }
                if (pre.right != null) leftN = pre.right;
            }
            leftV = leftN.val;
        }
        if (root.right != null) {
            TreeNode rightN = root.right, pre = root;
            while (rightN.left != null) {
                while (rightN.left != null) {
                    pre = rightN;
                    rightN = rightN.left;
                    ++j;
                }
                if (pre.right != null) rightN = pre.right;
            }
            rightV = rightN.val;
        }
        return i >= j ? leftV : rightV;
    }

}
