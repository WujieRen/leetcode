package com.ltc.wangzheng.binary_tree.flatten;

import com.ltc.wangzheng.binary_tree.TreeNode;

/**
 * @author rwj
 * @create_time 2021/12/12
 * @description
 *  二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。
 *  实现一个方法，把二叉搜索树转换为单向链表，要求依然符合二叉搜索树的性质，转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 *  返回转换后的单向链表的头节点。
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/binode-lcci
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConvertBiNode {

    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(4, new TreeNode(2, new TreeNode(1, new TreeNode(0), null), new TreeNode(3)), new TreeNode(6,  new TreeNode(5),  new TreeNode(8, new TreeNode(7), null)));
//        TreeNode n1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), null);
        TreeNode n1 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        TreeNode res = convertBiNode(n1);
        while(res != null) {
            System.out.println(res.val);
            res = res.right;
        }
    }

    static TreeNode pre = new TreeNode(), head = pre;
    public static TreeNode convertBiNode(TreeNode root) {
        addNode(root);
        return head.right;
    }

    public static void addNode(TreeNode root) {
        if(root == null) return;
        addNode(root.left);
        pre.right = root;
//        pre.left = null;  /** 这个会报错：Error - Found cycle in the TreeNode  ，原因是如果该树只有左子树，当前节点的左节点很有可能指向了已经处理的某个节点却没有置空 */
        root.left = null;
        pre = root;
        addNode(root.right);
    }
}
