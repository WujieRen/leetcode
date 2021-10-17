package com.ltc.wangzheng.sort;

import java.util.Arrays;

/**
 * @author rwj
 * @create_time 2021/10/14
 * @description
 */
public class Merge {

    public static void main(String[] args) {
        int[] A = new int[]{
                1, 2, 3, 0, 0, 0
        };
        int[] B = new int[]{
                2, 5, 6
        };
//        merge(A, 3, B, 3);
        f1(A, 6, B, 3);
        System.out.println(Arrays.toString(A));
    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int[] tmp = new int[m + n];
        System.arraycopy(A, 0, tmp, 0, m);
        int a = 0, b = 0, cnt = 0;
        while (a < m && b < n) {
            if (A[a] <= B[b]) {
                tmp[cnt++] = A[a];
                a++;
            }
            if (a >= m) break;       //TODO: 这里要注意一旦最后一次a++就会造成下面的 A[a]产生 ArrayOutoufBoundException异常
            if (B[b] < A[a]) {
                tmp[cnt++] = B[b];
                b++;
            }
        }
        while (a < m) tmp[cnt++] = A[a++];
        while (b < n) tmp[cnt++] = B[b++];
        System.out.println(Arrays.toString(tmp));
    }

    public static void f1(int[] A, int m, int[] B, int n) {
        int aLen = m - n;
        int[] tmp = new int[aLen];
        System.arraycopy(A, 0, tmp, 0, aLen);
        int a = 0, b = 0, cnt = 0;
        while (a < aLen && b < n) {
            if (tmp[a] <= B[b]) {
                A[cnt++] = tmp[a];
                a++;
            }
            if (a >= aLen) break;       //TODO: 这里要注意一旦最后一次a++就会造成下面的 A[a]产生 ArrayOutoufBoundException异常
            if (B[b] < tmp[a]) {
                A[cnt++] = B[b];
                b++;
            }
        }
        while (a < aLen) A[cnt++] = tmp[a++];
        while (b < n) A[cnt++] = B[b++];
        System.out.println(Arrays.toString(A));
    }

    private static void f2(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, idx = m + n - 1;
        while (i >= 0 && j >= 0) {
            if(A[i] >= B[j]) {
                A[idx--] = A[i--];
            } else {
                A[idx--] = B[j--];
            }
        }
        while(i >= 0) A[idx--] = A[i--];
        while(j >= 0) A[idx--] = B[j--];
    }
}
