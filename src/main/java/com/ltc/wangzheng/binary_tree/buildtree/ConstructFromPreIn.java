package com.ltc.wangzheng.binary_tree.buildtree;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rwj
 * @create_time 2021/12/14
 * @description
 * preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 */
public class ConstructFromPreIn {
    public static void main(String[] args) {
//        TreeNode n1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        int[] preOrder = new int[]{3,9,20,15,7};
        int[] inOrder = new int[]{9,3,15,20,7};
        TreeNode res = buildTree(preOrder, inOrder);
//        System.out.println(res);

        res = buildTreeRecursion(preOrder, inOrder);
        System.out.println(res);
    }

    public static TreeNode buildTreeRecursion(int[] preorder, int[] inorder) {
        return build(preorder, 0,  preorder.length-1, inorder, 0, inorder.length-1);
    }

    /**
     * 思考路径：
     *  1. 确定从上往下，用递归分治解决；
     *  2. 既然是递归：
     *      2.1 确定递归终止条件
     *      2.2 考虑层间关系：递归的父子层需要那些东西？以什么作为处理后的结果？
     *      2.3 考虑单独一层处理的话，逻辑是怎样的？
     *  3. 既然是分治：
     *      3.1 以什么条件作为分割的依据？
     *      3.2 分割时需要分割的范围？大小？
     *
     * 最终在递归调用时的索引变化那里卡住了，想了好几个小时弄不对；最后调试了一个小时...
     */
    public static TreeNode build(int[] preorder, int leftStart, int leftEnd, int[] inorder, int rightStart, int rightEnd) {
        //1. 如果分割的数组大小已经为0，说明没有元素了，分到最底层了
        if(leftEnd < leftStart) return null;
        //可以先写好要返回的结果和返回结果和当前层之间的关系
        //2. 递归的2.2和2.3是要一起考虑的，考虑处理逻辑是本身就要考虑到需要什么参数，返回什么结果；同时也就确定了层间关系
        TreeNode root = new TreeNode(preorder[leftStart]);
        if(leftEnd - leftStart == 0 || rightEnd - rightStart == 0) return root;

        // 2.3 确定处理逻辑是在递归之前还是之后，怎么确认？这里是考虑到分治需要对本层先分再传参数给递归函数，
        //      所以单层间的处理规则在到下一层之前要分割好
        int splitIdx = -1;
        for(int i = rightStart; i <= rightEnd; ++i) {
            if(inorder[i] == preorder[leftStart]) {
                splitIdx = i;
                break;
            }
        }

        //  2.2 返回的结果  // 2.2 层间关系
//        TreeNode left = build(preorder, leftStart+1, leftSplitIdx, inorder, 0, leftSplitIdx);
//        TreeNode right = build(preorder, leftStart+1+leftSplitIdx, preorder.length, inorder, leftSplitIdx+1, inorder.length);
        root.left = build(preorder, leftStart+1, leftStart+(splitIdx-rightStart), inorder, rightStart, splitIdx-1);
        root.right = build(preorder, leftStart+(splitIdx-rightStart)+1, leftEnd, inorder, splitIdx+1, rightEnd);

        return root;
    }

    /**
     * 一开始自己尝试的解法。
     * 根据前序遍历的特性，先  node -> node.left -> node.right
     * 再根据中序遍历的结果，
     *      1. 判定先序遍历中下一个节点是在当前节点左边还是右边？
     *      2. 如果当前节点左/右节点 != null  -->  cur = cur.left / cur = cur.right
     *      3. 一直找到要插入的那个节点；然后根据中序遍历的结果，比较当前节点和要插入的节点的索引大小（小插左，大插右）
     *      4. 遍历前序序列结果一直到结束。
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> hasTab = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) {
            hasTab.put(inorder[i], i);
        }
        TreeNode root = new TreeNode(preorder[0]), pre;
        for(int i = 1; i < preorder.length; ++i) {
            pre = root;
            int curV = preorder[i];
            while(true) {
                if(hasTab.get(curV) < hasTab.get(pre.val)) {
                    if(pre.left != null) pre = pre.left;
                    else break;
                }
                if(hasTab.get(curV) > hasTab.get(pre.val)) {
                    if(pre.right != null) pre = pre.right;
                    else break;
                }
            }
            if(pre.left == null && hasTab.get(curV) < hasTab.get(pre.val)) pre.left = new TreeNode(curV);
            else pre.right = new TreeNode(curV);
        }
        return root;
    }
}
