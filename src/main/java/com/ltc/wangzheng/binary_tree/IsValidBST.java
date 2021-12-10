package com.ltc.wangzheng.binary_tree;

import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/12/8
 * @description
 *      给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *      有效 二叉搜索树定义如下：
 *          节点的左子树只包含 小于 当前节点的数。
 *          节点的右子树只包含 大于 当前节点的数。
 *          所有左子树和右子树自身必须也是二叉搜索树。
 *
 *      来源：力扣（LeetCode）
 *      链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 */
public class IsValidBST {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(1), null);
        System.out.println(isValidBSTRecursion(n1));
    }

    /**
     * 递归解法。本质也是中序遍历，但是一变形有时候就有点绕不过去了。
     * 还是对递归的本质不够理解：
     *  比如当二叉树为上面的 n1 时，第一次的 <return left && right> 返回的结果，
     *  其实是走到了根节点值为1的那个节点处，而不是整个程序的结束；
     *  然后再从 boolean left = is..(root.left) 处开始往下走，这时的 root 就是二叉树的根节点
     */
    static long maxVal = Long.MIN_VALUE;
    public static boolean isValidBSTRecursion(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBSTRecursion(root.left);
        if(maxVal >= root.val) return false;
        else maxVal = root.val;
        boolean right = isValidBSTRecursion(root.right);
        return left && right;
    }

    /**
     * 本质就是利用二叉查找树中序遍历的有序性。以下是非递归实现。
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode cur = root;
        long preV = Long.MIN_VALUE;
        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(preV >= cur.val) return false;
            preV = cur.val;
            cur = cur.right;
        }
        return true;
    }

    //总是会有意外情况，说明方法不对
    /*public boolean valid(TreeNode root, TreeNode pre, String flag) {
        if (root == null) return true;
        if (root.left != null && root.left.val > root.val) return false;
        if (root.right != null && root.right.val < root.val) return false;
        if (pre != null) {
            if (flag.equals("left") && root.left != null && root.left.val >= pre.val) return false;
            if (flag.equals("left") && root.right != null && root.right.val >= pre.val) return false;
            if (flag.equals("right") && root.left != null && root.left.val <= pre.val) return false;
            if (flag.equals("right") && root.right != null && root.right.val <= pre.val) return false;
        }
        return valid(root.left, root, "left") && valid(root.right, root, "right");
    }*/

}
