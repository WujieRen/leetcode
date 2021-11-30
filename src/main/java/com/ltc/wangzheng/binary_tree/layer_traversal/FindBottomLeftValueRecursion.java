package com.ltc.wangzheng.binary_tree.layer_traversal;

import com.ltc.wangzheng.binary_tree.TreeNode;

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
public class FindBottomLeftValueRecursion {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5, null, new TreeNode(6, new TreeNode(7), null))), new TreeNode(3));
        TreeNode n2 = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(findBottomLeftValue1(n2));
    }

    static int res, maxDepth = -1;

    //TODO: -----------------   写法2⃣️

    public static int findBottomLeftValue2(TreeNode root) {
        o1(root, 0);
        return res;
    }

    //其实这种写法效率更高
    public static void o1(TreeNode node, int depth) {
        if(node.left == null && node.right == null) {
            if(depth > maxDepth) {
                maxDepth = depth;
                res = node.val;
            }
            return;
        }
        if(node.left != null) o1(node.left, depth+1);
        if(node.right != null) o1(node.right, depth+1);
    }


    //TODO: ----------------  写法1⃣️

    public static int findBottomLeftValue1(TreeNode root) {
        m1(root, 0);
        return res;
    }

    public static void m1(TreeNode node, int depth) {
        if(node == null) return;
        if(depth >= maxDepth) {
            res = node.val;
            maxDepth = depth;
        }
        if(node.right != null) m1(node.right, depth+1);
        if(node.left != null) m1(node.left, depth+1);
    }

    public static void m2(TreeNode node, int depth) {
        if(node == null) return;
        if(depth > maxDepth) {
            res = node.val;
            maxDepth = depth;
        }
        if(node.left != null) m2(node.left, depth+1);
        if(node.right != null) m2(node.right, depth+1);
    }
}
