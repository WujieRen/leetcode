package com.ltc.wangzheng.heap;

/**
 * @author rwj
 * @create_time 2021/12/18
 * @description Heap        堆
 * 堆的特性：
 *      1. 堆必须是完全二叉树（中间没有空洞）
 *      2. 堆的每个结点的元素大小都大于等于，或小于等于，其子树中每个节点的值
 * 堆是完全二叉树，所以适合用数组存。用数组存时下标关系：
 *      如果当前节点下标为 i,则其父节点下标为 i/2 ； 其左子节点下标为 2*i ； 其右子节点下标为 2*i+1 ；
 * 堆的操作：
 *      1. 往堆中插入数据
 *      2. 取堆顶元素
 *      3. 删除堆顶元素
 *      4. 更新元素值
 *          如果更新后元素值变小了：自上往下堆化  O(nlogn)
 *          如果更新后元素值变大了：自下往上堆化  O(n)
 *
 *  堆的应用：
 *      1. 堆排序——建堆（两种实现思路）
 *          - 从前往后处理每个元素，对每个元素执行自下而上的堆化
 *          - 从后往前处理每个元素，对每个元素执行自上而下的堆化
 *      2. 堆排序——排序
 *          2.1 将堆顶元素与最后一个元素交换，最大元素就到了下表为n的位置堆大小-1；
 *          2.2 交换之后，自上而下堆化，重新构建堆；
 *          一直重复以上过程，直到队中剩下最后一个元素，排序工作就完成了
 *  堆排序算法分析
 *      堆排序算法是否是原地排序算法？   是
 *      堆排序是否是稳定排序？           否
 *      堆排序的时间复杂度是多少？       O(nlogn)
 *      堆排序的空间复杂度是多少？       O(1)
 */
public class Heap {

    int[] heap;
    int capacity;
    int count;

    Heap(int capacity) {
        this.heap = new int[capacity+1];
        this.capacity = capacity;
        this.count = 0;
    }

    public void insert(int num) {
        if (count >= capacity) return;   //看容量满了没，满了就不能插入了
        ++count;
        heap[count] = num;
        /** 自下往上堆化 */
        heapifyFromB2T(heap, count);
    }

    public void heapifyFromB2T(int[] heap, int idx) {
        while (idx/2 > 0 && heap[idx] > heap[idx/2]) {  //这里要注意 idx 在过程中是不断变化的
            swap(heap, idx, idx/2);
            idx = idx/2;
        }
    }

    //删除堆顶元素
    public void removeMax() {
        if(count == 0) return;
        heap[1] = heap[count];
        --count;    //删除元素
        /** 自上往下堆化 */
        heapifyFromT2B(heap, 1, count);
    }

    public int top() {
        if(count == 0) return -1;
        return heap[1];
    }

    /**
     * 从上往下堆化（heapify）
     * @param heap  堆数组
     * @param idx   上idx
     * @param count 元素数量/个数
     */
    public static void heapifyFromT2B(int[] heap, int idx, int count) {
        int maxPos = idx;
        while(true) {
            int leftIdx = 2*idx;
            int rightIdx = 2*idx+1;
            if(leftIdx <= count && heap[maxPos] < heap[leftIdx]) maxPos = 2*idx;
            if(rightIdx <= count && heap[maxPos] < heap[rightIdx]) maxPos = 2*idx+1;
            if(idx == maxPos) break;
            swap(heap, idx, maxPos);
            idx = maxPos;
        }
    }

    public static void swap(int[] ary, int i, int j) {
        int tmp = ary[i];
        ary[i] = ary[j];
        ary[j] = tmp;
    }

    public static void buildHeap(int[] ary, int n) {
        /** 这里用的从后往前，从第一个非叶子节点，执行自下而上的堆化 */
        // 非叶子节点下标为什么是从 1 ~ n/2
        for(int i = n/2; i >= 1; --i) heapifyFromT2B(ary, i, n);
    }

}
