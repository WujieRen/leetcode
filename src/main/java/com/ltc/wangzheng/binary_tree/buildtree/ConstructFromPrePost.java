package com.ltc.wangzheng.binary_tree.buildtree;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/12/18
 * @description https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/
 *
 * 返回与给定的前序和后序遍历匹配的任何二叉树。
 *  pre 和 post 遍历中的值是不同的正整数。
 * 示例：
 * 输入：pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ConstructFromPrePost {
    public static void main(String[] args) {
        int[] preorder = new int[]{1,2,4,5,3,6,7};
        int[] postorder = new int[]{4,5,2,6,7,3,1};
        TreeNode res = constructFromPrePost(preorder, postorder);
        System.out.println(res);

        TreeNode res2 = constructFromPrePost2(preorder, postorder);
        System.out.println(res2);
    }
    /**
     *  写法①，每次都是把数组固定范围copy，
     *  相对写法②而言，下标计算较为简单，
     *  但是因为涉及到数组copy，效率就低一些
     */
    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return construct(preorder, postorder);
    }
    public static TreeNode construct(int[] preorder, int[] postorder) {
        if(preorder.length == 0) return null;       //终止条件

        //单层处理逻辑
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length == 1) return root;   //终止条件
        int splitIdx = 0;
        for(int i = 0; i < postorder.length; ++i) {
            if(postorder[i] == preorder[1]) {
                splitIdx = i;
                break;
            }
        }
        //层间关系、参数
        root.left = construct(Arrays.copyOfRange(preorder, 1, splitIdx+2), Arrays.copyOfRange(postorder, 0, splitIdx+1));
        root.right = construct(Arrays.copyOfRange(preorder, splitIdx+2, preorder.length), Arrays.copyOfRange(postorder, splitIdx+1, postorder.length));

        return root;
    }

    /**    写法②，数组不copy，
     * 只是用下标去限制数组的范围，
     * 比写法①效率高，但下标计算稍复杂
     */
    public static TreeNode constructFromPrePost2(int[] preorder, int[] postorder) {
        return construct2(preorder, 0, preorder.length-1, postorder, 0, postorder.length-1);
    }
    public static TreeNode construct2(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart, int postEnd) {
        if(preStart > preEnd) return null;   //终止条件

        TreeNode root = new TreeNode(preorder[preStart]);
        if(preStart == preEnd) return root;   //终止条件
        int splitIdx = 0;
        for(int i = postStart; i <= postEnd; ++i) {
            if(postorder[i] == preorder[preStart+1]) {
                splitIdx = i;
                break;
            }
        }

        root.left = construct2(preorder, preStart+1, preStart+splitIdx-postStart+1, postorder, postStart, splitIdx);
        root.right = construct2(preorder, preStart+splitIdx-postStart+2, preEnd, postorder, splitIdx+1, postEnd-1);

        return root;
    }

}
