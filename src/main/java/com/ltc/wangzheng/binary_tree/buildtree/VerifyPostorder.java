package com.ltc.wangzheng.binary_tree.buildtree;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/12/15
 * @description
 */
public class VerifyPostorder {

    /**
     * 解法①：
     *      在了解了前序/后序 + 中序能够确定一棵树的前提下；
     *      根据二叉搜索（查找）树的中序遍历有序性，构造出也给中序遍历的数组；
     *      结合 前序/后序+中序 能够确定一个树，
     *      并在递归过程中根据返回的左右子节点的值和当前root节点的大小——二叉搜索树的特性，左边一定小于root，右边一定大于roo
     *      就可以判定该树是否为一棵二叉搜索树。
     */
    boolean flag = true;
    public boolean verifyPostorder(int[] postorder) {
        int[] inorder = Arrays.copyOf(postorder, postorder.length);
        Arrays.sort(inorder);
        build(inorder, postorder);
        return flag;
    }
    public TreeNode build(int[] inorder, int[] postorder) {
        if(!flag) return new TreeNode();
        //终止条件
        if (postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length - 1]);
        if (postorder.length == 1) return root;
        //单层处理逻辑
        int splitIdx = 0;
        for (int i = 0; i < inorder.length; ++i) {
            if (inorder[i] == root.val) {
                splitIdx = i;
                break;
            }
        }
        //递归关系+分治逻辑
        TreeNode left = build(Arrays.copyOfRange(inorder, 0, splitIdx), Arrays.copyOfRange(postorder, 0, splitIdx));
        if(left != null && left.val >= root.val) flag = false;
        TreeNode right = build(Arrays.copyOfRange(inorder, splitIdx + 1, inorder.length), Arrays.copyOfRange(postorder, splitIdx, postorder.length - 1));
        if(right != null && right.val <= root.val) flag = false;
        //单层返回结果
        return root;
    }

    /**
     * 解法②：
     *      本质和解法①是一样的，都是利用了二叉搜索树后中序遍历的有序性。不过用的方法更加巧妙。
     *      方法②结合二叉搜索树后序遍历，根节点一定是最后一个元素的特性，按此特性递归处理每一层；也利用了分治的思想。
     *      一层一层缩小范围处理，只要有一层不满足，就返回false。
     */
    public boolean verifyPostorder2(int[] postorder) {
        if(postorder.length <= 1) return true;
        return verify(postorder, 0, postorder.length-1);    //注意边界条件
    }
    public boolean verify(int[] postorder, int start, int end) {
        if(start >= end) return true;    //终止条件

        //单层分割逻辑
        int i = 0;
        while(postorder[i] < postorder[end]) ++i;
        int m = i;
        while(postorder[i] > postorder[end]) ++i;

        //返回值，是单层处理逻辑的一部分，也是体现层间关系的地方
        return end == i && verify(postorder, start, m-1) && verify(postorder, m, end-1);
    }


}
