package com.ltc.wangzheng.binary_tree;

/**
 * @author rwj
 * @create_time 2021/12/4
 * @description
 */
public class IsBalanced {

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), null), null), new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3, null, new TreeNode(5, new TreeNode(6), null)));
        System.out.println(isBalanced_src(n1));
        System.out.println("-------------------");
        System.out.println(isBalanced(n1));
    }

    //TODO:   -------------------------- 写法一: 归的时候计算高度， -----------------------
    public static boolean isBalanced_src(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHigh_src(root.left) - getHigh_src(root.right)) <= 1) {
            System.out.println("~~~~~");
            return isBalanced_src(root.left) && isBalanced_src(root.right);
        }
        return false;
    }

    public static int getHigh_src(TreeNode node) {
        if (node == null) return 0;
        System.out.println("IsBalanced.getHigh_src--" + node.val);
        return Math.max(getHigh_src(node.left), getHigh_src(node.right)) + 1;
    }

    //TODO:   -------------------------- 写法一优化: 归的时候一旦发现某节点左右两节点高度超过1，直接结束，不再进行剩下节点的遍历 -----------------------
    static boolean flag = false;

    public static boolean isBalanced(TreeNode root) {
        if (flag) return false;
        if (root == null) return true;
        if (Math.abs(getHigh(root.left) - getHigh(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }

    public static int getHigh(TreeNode node) {
        if (flag) return 0;
        if (node == null) return 0;
        System.out.println("IsBalanced.getHigh---" + node.val);
        int left = getHigh(node.left);
        int right = getHigh(node.right);
        if (Math.abs(left - right) > 1) flag = true;
        return Math.max(left, right) + 1;
    }

    //TODO:   -------------------------- 写法二: 递的时候计算高度 -----------------------
    static int maxDepth;

    public static boolean o1(TreeNode root) {
        if (root == null) return true;
        getHigh(root.left, 1);
        int leftHigh = maxDepth;
        maxDepth = 0;
        getHigh(root.right, 1);
        int rightHigh = maxDepth;
        if (Math.abs(leftHigh - rightHigh) > 1) return false;
        maxDepth = 0;
        return o1(root.left) && o1(root.right);
    }

    public static void getHigh(TreeNode node, int depth) {
        if (node == null) return;
        maxDepth = Math.max(depth, maxDepth);
        getHigh(node.left, depth + 1);
        getHigh(node.right, depth + 1);
    }

    //TODO:   -------------------------- 写法三: 归的时候计算高度，并判断是否平衡 -----------------------
    public static boolean isBalanced_3(TreeNode root) {
        if (root == null) return true;
        return getHigh_3(root) != -1;
    }

    public static int getHigh_3(TreeNode node) {
        if (node == null) return 0;
        int left = getHigh_3(node.left);
        if(left == -1) return -1;
        int right = getHigh_3(node.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right)+1 : -1;
    }

}
