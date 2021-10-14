package com.ltc.wangzheng.recursion;

/**
 * @author rwj
 * @create_time 2021/10/13
 * @description
 */
public class Multiply {

    public int multiply3(int A, int B) {
        if(B == 0) return 0;
        return A + multiply(A, B-1);
    }

    public int multiply(int A, int B) {
        if(B == 0) return 0;
        int tmp = A;
        A += multiply(tmp, B-1);
        return A;
    }

    public int multiply2(int A, int B) {
        if(B == 0) return 0;
        int tmp = A;
        for(int i = 1; i < B; ++i) {
            A += tmp;
        }
        return A;
    }
}
