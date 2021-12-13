package com.ltc.wangzheng.binary_tree.lca;

import com.ltc.wangzheng.binary_tree.TreeNode;

/**
 * @author rwj
 * @create_time 2021/12/13
 * @description
 *
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinarySearchTreeLowestCommonAncestor {

    /** ---------------------    方法①：一看就是LCA，所以按后续遍历处理，从下往上返回指定值。递归解法       -------------------- */
    /** 6ms， 效率比方法③略低 */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, q, p);
        if(left != null && right != null) return root;
        return left == null ? right : left;
    }

    /**
     * 方法②：利用二叉搜索（查找）树的特性来解决
     *      1. 对于每一个节点的值，它的左子树一定比该节点要小；右子树一定比该节点要大；
     *      2. 按中序遍历时升序
     * 此题利用的时第一个特性.
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == root || q == root) return root;
        if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) return root;
        TreeNode iter = root;
        if(p.val < iter.val && q.val < iter.val) {
            while(iter != null && p.val < iter.val && q.val < iter.val) iter = iter.left;
            TreeNode left = iter;
            while(iter != null && p.val > iter.val && q.val > iter.val) iter = iter.right;
            TreeNode right = iter;
            return left != null && right != null ? right : left == null ? right : left;
        } else {
            while(iter != null && p.val > iter.val && q.val > iter.val) iter = iter.right;
            TreeNode right = iter;
            while(iter != null && p.val < iter.val && q.val < iter.val) iter = iter.left;
            TreeNode left = iter;
            return right != null && left != null ? left : right == null ? left : right;
        }
    }

    /**
     * 方法②写法②：仍然是利用了二叉查找树的特性：
     *  对于每一个节点的值，它的左子树一定比该节点要小；右子树一定比该节点要大；
     * 来搜索指定值。只要找到一个p或q其中的一个，或者夹在p或q中间的第一个；就是我们要找的值。
     * 这个写法太骚了，秒杀我上面的写法；思路清晰代码简洁。
     * niubility
     */
    public TreeNode lowestCommonAncestor2_2(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        while(true) {
            if(p.val < root.val && q.val < root.val) {
                root = root.left;
            } else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else {
                break;
            }
        }
        return root;
    }

    /**
     * 方法③：利用了二叉搜索树的特性，同时也利用了递归；实在写方法②的时候偶然发现这样也阔以。
     * 效率比方法①略高。 5ms
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p == root || q == root) return root;
        if((p.val > root.val && q.val < root.val) || (p.val < root.val && q.val > root.val)) return root;
        if(p.val < root.val && q.val < root.val) return lowestCommonAncestor3(root.left, p, q);
        if(p.val > root.val && q.val > root.val) return lowestCommonAncestor3(root.right, p, q);
        return null;
    }
}
