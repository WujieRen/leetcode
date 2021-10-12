package com.ltc.wangzheng.stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description 这个效率最高，因为是用int[]模拟了一个栈的操作；
 *                  直接用栈也可以，但是效率没这么高。
 *                  由此也可以想到，如果是要开发一些底层的框架和组件，
 *                  肯定是用最基本的数据类型去模拟堆、栈等数据结构的的效率
 *                  要比直接用Stack、Queue这样的封装好的工具类的效率高
 *                  这也是为什么要能够自己写出栈、堆、二叉树等代码的原因——而不是用别人分封装好的
 */
public class ValidateStackSequences4 {
    private static boolean f1(int[] pushed, int[] popped) {
        int psLen = pushed.length;
        int[] ns = new int[psLen];
        int psIndex = -1, ppIdx = 0;
        for (int psn : pushed) {
            ns[++psIndex] = psn;
            while (psIndex != -1 && ns[psIndex] == popped[ppIdx]) {
                psIndex--;
                ppIdx++;
            }
        }
        return psIndex == -1;
    }
}
