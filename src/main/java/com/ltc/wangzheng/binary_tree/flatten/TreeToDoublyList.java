package com.ltc.wangzheng.binary_tree.flatten;

/**
 * @author rwj
 * @create_time 2021/12/13
 * @description https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 *  输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class TreeToDoublyList {

    public static void main(String[] args) {
        Node n0 = new Node(0);
        Node n1 = new Node(1, n0, null);
        Node n3 = new Node(3);
        Node n2 = new Node(2, n1, n3);
        Node n6 = new Node(6);
        Node n5 = new Node(5, null, n6);
        Node n4 = new Node(4, n2, n5);
        Node n8 = new Node(8);
        Node n11 = new Node(11);
        Node n13 = new Node(13);
        Node n12 = new Node(12, n11, n13);
        Node n9 = new Node(9, n8, n12);
        Node n7 = new Node(7, n4, n9);
        Node res = treeToDoublyList(n7);
        System.out.println(res);
    }


    /**
     * 总结：  想这个题的过程，我也是确定递归顺序，并按照递归三部曲结合来思考怎么能出结果：递归终止条件-》递归层间关系-》单层递归逻辑
     *      但是在思考递归层间关系时，我潜意识一直默认要返回一个值；让当前节点对左右节点的指针改变达到最终结果；
     *      导致根节点左右两边处理逻辑不一致，且通过这种方式转换节点间关系很容易出错且复杂。
     *
     *      看到提示：按照中序遍历顺序往后遍历，用一个虚拟头节点，只需要三行代码即可搞定，且不会影响到后续节点直接指针关系。
     *          pre.right = cur;
     *         cur.left = pre;
     *         pre = pre.right;
     */
    static Node pre = new Node(), head = pre;
    public static Node treeToDoublyList(Node root) {
        if(root == null) return null;
        inOrderRightAsc(root);
        head.right.left = pre;
        pre.right = head.right;
        return head.right;
    }
    public static void inOrderRightAsc(Node node) {
        if(node == null) return;
        inOrderRightAsc(node.left);
        pre.right = node;
        node.left = pre;
        pre = pre.right;
        inOrderRightAsc(node.right);
    }

}
