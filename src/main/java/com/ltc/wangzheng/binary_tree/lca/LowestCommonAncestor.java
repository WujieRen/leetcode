package com.ltc.wangzheng.binary_tree.lca;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author rwj
 * @create_time 2021/12/11
 * @description 本质是后序遍历。先一溜到底，归的时候，去做处理
 *
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 */
public class LowestCommonAncestor {

    static List<Integer> path = new ArrayList<>();
    static List<Integer> path2 = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode n_2 = new TreeNode(-2);
        TreeNode n_1 = new TreeNode(-1, n_2, null);
        TreeNode n9 = new TreeNode(9, n_1, null);
        TreeNode n10 = new TreeNode(10, n9, null);
        TreeNode n7 = new TreeNode(7);
        TreeNode n4 = new TreeNode(4, null, n10);
        TreeNode n0 = new TreeNode(0);
        TreeNode n8 = new TreeNode(8);
        TreeNode n6 = new TreeNode(6);
        TreeNode n1 = new TreeNode(3, new TreeNode(5, n6, new TreeNode(2, n7, n4)), new TreeNode(1, n0, n8));
//        lowestCommonAncestor3(n1, n7, n4);
//        findPath(n1, n4);
//        System.out.println(path);
        //破坏性很强，每次执行结束后二叉树就会被破坏掉
//        System.out.println(findPath2(n1, n9));
        System.out.println(findPath2(n1, n_1));
        System.out.println(findPath2(n1, n8));
        TreeNode n2 = new TreeNode(5);
        n1 = new TreeNode(3, null, n2);
        System.out.println(findPath2(n1, n2));
    }

    /**
     * 这个是完全自创，但是思路的话本质还是二叉树的后续遍历；先递下去，归的时候判断路径中是否存在要找的值；不存在就一直pop到stack为空
     */
    static class UsedNode {
        TreeNode node;
        int status;
        UsedNode() {}
        UsedNode(TreeNode node) {}
        UsedNode(TreeNode node, int status) {
            this.node = node;
            this.status = status;
        }
    }
    public static List<Integer> findPath2(TreeNode root, TreeNode dstNode) {
        List<Integer> res = new ArrayList<>();
        Stack<UsedNode> stack = new Stack<>();
        UsedNode cur = new UsedNode();
        TreeNode curN = root;
        while (!stack.isEmpty() || curN != null) {
            while (curN != null) {
                cur = new UsedNode(curN, 0);
                stack.push(cur);
                curN = curN.left;
            }
            cur = stack.peek();
            cur.status = 1;
            curN = cur.node;
            if (curN == dstNode) break;
            while(curN.right == null && curN.left == null) {
                stack.pop();
                cur = stack.peek();
                if (cur.status == 1)
                    cur.status = 2;
                if (cur.status == 0)
                    cur.status = 1;
                curN = cur.node;
            }
            curN.left = null;
            if(cur.status == 2) curN.right = null;
            curN = curN.right;
        }
        while (!stack.isEmpty()) res.add(0, stack.pop().node.val);
        return res;
    }

    /**                ------------------------------------------------------------------            */
    public static boolean findPath(TreeNode node, TreeNode dstNode) {
        if (node == null) return false;
        if (node == dstNode) {
            path.add(node.val);
            return true;
        }
        boolean left = findPath(node.left, dstNode);
        boolean right = findPath(node.right, dstNode);
        if (left || right) path.add(node.val);
        return left || right;
    }


    /**             -------------------------------------------------------------------------------                  */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        if (left == null) return right;
        return left;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root;
        return left == null ? right : left;
    }

    /**
     * 以下这种方法的本质其实和上面是一样的；
     *
     * @param root
     * @param path
     * @param lookup
     * @return
     */
    public static boolean helper(TreeNode root, List<TreeNode> path, TreeNode lookup) {
        boolean ret;
        if (root == null) return false;
        if (root == lookup) {
            path.add(root);
            return true;
        }
        ret = helper(root.left, path, lookup) || helper(root.right, path, lookup);
        if (ret) path.add(root); //这里是我看了别人代码后给他优化的地方；
        return ret;
    }

    public static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path_p = new ArrayList<TreeNode>();
        List<TreeNode> path_q = new ArrayList<TreeNode>();
        TreeNode res = null;
        if (helper(root, path_p, p) && helper(root, path_q, q)) {
            int size_p = path_p.size() - 1;
            int size_q = path_q.size() - 1;
            for (; size_p >= 0 && size_q >= 0; size_p--, size_q--) {
                if (path_p.get(size_p) != path_q.get(size_q)) {
                    break;
                } else {
                    res = path_p.get(size_p);
                }
            }
            return res;
        } else {
            return null;
        }
    }

}
