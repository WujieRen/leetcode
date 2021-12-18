package com.ltc.wangzheng.binary_tree.buildtree;

import com.ltc.wangzheng.binary_tree.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author rwj
 * @create_time 2021/12/16
 * @description
 */
public class ConstructFromPostIn {
    public static void main(String[] args) {
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode res = buildTree(inorder, postorder);
        System.out.println(res);
    }
    /**
     *  后序和中序，类比前序和中序。经过一番规律寻找，发现要从后序序列中取元素，以中序序列确定节点左右顺序。
     *  再找的时候还花费了一点时间。其实不需要考虑太多，用前序/后序 和 中序确定二叉树的关键在于先找到根节点root。
     *  前序遍历第一个节点就是root；而后序遍历最后一个节点是root。
     *
     *  找到root后，剩下的就和前序&中序解法一样了。
     *
     *  首先时递归，然后时分治。
     *  递归三部曲：
     *      1. 确定终止条件；
     *      2. 确定层间关系：递归层级间的关系 & 函数要返回的结果。
     *                  比如这里就是 root.left = build()；root.right = build()
     *                  考虑层间关系的时候只考虑一层，然后推演开看是否能通过子问题的解决，找到父问题的答案。
     *      3. 确定单层处理逻辑。
     *  分治：
     *      1. 怎么分？以什么为依据分？
     *      2. 分割时的范围？
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, postorder);
    }

    public static TreeNode build(int[] inorder, int[] postorder) {
        //终止条件
        if(postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if(postorder.length == 1) return root;
        //单层处理逻辑
        int splitIdx = 0;
        for(int i = 0; i < inorder.length; ++i) {
            if(inorder[i] == root.val) {
                splitIdx = i;
                break;
            }
        }
        //递归关系+分治逻辑
        root.left = build(Arrays.copyOfRange(inorder, 0, splitIdx), Arrays.copyOfRange(postorder, 0, splitIdx));
        root.right = build(Arrays.copyOfRange(inorder, splitIdx+1, inorder.length), Arrays.copyOfRange(postorder, splitIdx, postorder.length-1));
        //单层返回结果
        return root;
    }

    /** ----------------------------------------------------- */
    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; ++i) map.put(inorder[i], i);
        return build2(inorder, postorder, map);
    }

    /**
     *  这个会陷入死循环，因为如果用map存储了inorder的下标，每次获取到的下标就不变，就陷入死循环了。
     *  如果要用map接的话，需要用限制下标范围哪种方式来《参考ConstructFromPreIn》；
     *  不改变 inorder 和 postorder，而是通过改变下标范围来分治。
     */
    public static TreeNode build2(int[] inorder, int[] postorder, Map<Integer, Integer> map) {
        if(postorder.length == 0) return null;
        TreeNode root = new TreeNode(postorder[postorder.length-1]);
        if(postorder.length == 1) return root;

        int splitIdx = map.get(root.val);
        root.left = build2(Arrays.copyOfRange(inorder, 0, splitIdx), Arrays.copyOfRange(postorder, 0, splitIdx), map);
        root.right = build2(Arrays.copyOfRange(inorder, splitIdx+1, inorder.length), Arrays.copyOfRange(postorder, splitIdx, postorder.length-1), map);
        return root;
    }
}
