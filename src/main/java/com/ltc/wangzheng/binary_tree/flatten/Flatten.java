package com.ltc.wangzheng.binary_tree.flatten;

import com.ltc.wangzheng.binary_tree.TreeNode;

/**
 * @author rwj
 * @create_time 2021/12/12
 * @description
 *  给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *  展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 *  展开后的单链表应该与二叉树 先序遍历 顺序相同。
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Flatten {
    public void flatten(TreeNode root) {
        m1(root);
    }

    /**  -------------------------   解法①：利用当前节点对左右子节点进行倒腾，但是左指针指向右指针的时候要遍历，效率不够高    -----------------------------  */
    public TreeNode m1(TreeNode root) {
        if(root == null) return null;
        TreeNode left = m1(root.left);
        TreeNode right = m1(root.right);
        if(left != null) {
            root.left = null;
            root.right = left;
            while(left.right != null) left = left.right;
            left.right = right;
        }
        return root;
    }

    /**  解法②：利用当先序遍历的特性：上一个节点的下一个节点总是以：当前节点->左子节点->右子节点  的顺序
     *  将上一个遍历节点的left指针指向null，right指针指向当前节点
     * */
    TreeNode pre = new TreeNode();
    public void o1(TreeNode root) {
        if(root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;
        pre.right = root;
        pre.left = null;
        pre = root;

        o1(left);
        o1(right);
    }


    /**  -------------------------   解法③：利用逆后序遍历（从右往左进行后续遍历），让当前节点一直指向上一个last节点
     *  总结一下：
     *      二叉树上这些操作本质就是按照某种顺序对指针或者对值的操作；
     *      所以，对二叉树递归来说，最重要的首先是确定递归的顺序，前？中？后？
     *      然后，就是递归三部曲：
     *          确定递归终止条件；
     *          确定是否是否有返回值、返回值和参数——本质是递归层级之间的关联关系；
     *          确定单层之间的处理逻辑；
     *      最后，针对每种递归顺序，逆序处理是否能解决问题？——从左往右处理还是从右往左处理？（其实从右往左的后序遍历，就是从左往右的前序遍历）
     *      是否会更方便？
     */
    TreeNode last;
    public void m1_o1(TreeNode root) {
        if(root == null) return;
        m1_o1(root.right);
        m1_o1(root.left);
        root.right = last;
        root.left = null;
        last = root;
    }

}
