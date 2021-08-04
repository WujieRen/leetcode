package com.rwj.ltc.array.wangzheng;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/8/2
 * @description
 */
public class N2Sort {

    private static int[] arry = {4, 5, 6, 3, 2, 1};

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(bubbleSort(arry)));
//        System.out.println(Arrays.toString(insertionSort(arry)));
        System.out.println(Arrays.toString(insertSort(arry)));
//        System.out.println(Arrays.toString(selectionSort(arry)));
//        System.out.println(Arrays.toString(selectInsert(arry)));
    }

    private static int[] selectInsert(int[] arry) {
        for (int i = 0; i < arry.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[j] < arry[minIndex]) minIndex = j;
            }
            int tmp = arry[minIndex];
            arry[minIndex] = arry[i];
            arry[i] = tmp;
        }
        return arry;
    }

    /**
     * 选择排序  （我自己的写法）
     *
     * @param arry
     * @return
     */
    private static int[] selectionSort(int[] arry) {
        for (int i = 0; i < arry.length - 1; i++) {
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[j] < arry[i]) {
                    int tmp = arry[j];
                    arry[j] = arry[i];
                    arry[i] = tmp;
                }
            }
        }
        return arry;
    }

    /**
     * 这种写法要好很多，复杂度是O(n^2)
     * @param arry
     * @return
     */
    private static int[] insertSort(int[] arry) {
        for(int i = 0; i < arry.length - 1; i++) {
            for(int j = i + 1; j > 0; j--) {
                if(arry[j] < arry[j-1]) {
                    int tmp = arry[j-1];
                    arry[j-1] = arry[j];
                    arry[j] = tmp;
                }
            }
        }
        return arry;
    }

    /**
     * 自己的写法，复杂度极高；达到了O(n^3)
     *
     * @param arry
     * @return
     */
    private static int[] insertionSort(int[] arry) {
        for (int i = 1; i < arry.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arry[i] < arry[j]) {
                    int tmpVal = arry[i];
                    int tmpI = i;
                    while (tmpI != j) {
                        arry[tmpI] = arry[--tmpI];
                    }
                    arry[j] = tmpVal;
                    break;
                }
            }
        }
        return arry;
    }

    /**
     * 冒泡排序：
     * 冒泡排序只会操作相邻的两个数据。
     * 每次冒泡操作都会对相邻的两个元素进行比较，看是否满足大小关系要求。如果不满足就让它俩互换。
     * 一次冒泡会让至少一个元素移动到它应该在的位置，重复 n 次，就完成了 n 个数据的排序工作。
     * <p>
     * 当然，这个冒泡过程还可以优化。
     * 当某次冒泡操作已经没有数据交换时，说明已经达到完全有序，不用再继续执行后续的冒泡操作。
     *
     * @param arry
     * @return
     */
    private static int[] bubbleSort(int[] arry) {
        int limit = arry.length - 1;
        for (int j = 0; j < limit; j++) {
            boolean flag = true;            // 提前退出冒泡循环的标志位
            for (int i = 0; i < limit; i++) {
                if (arry[i] > arry[i + 1]) {
                    int tmp = arry[i + 1];
                    arry[i + 1] = arry[i];
                    arry[i] = tmp;
                    flag = false;       // 表示有数据交换
                }
            }
            if (flag) break;        // 没有数据交换，提前退出
        }
        return arry;
    }
}
