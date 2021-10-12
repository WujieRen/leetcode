package com.ltc.wangzheng.stack;

/**
 * @author rwj
 * @create_time 2021/10/11
 * @description
 */
public class ValidateStackSequences {


    private static boolean f1(int[] pushed, int[] popped) {
        if (pushed.length == 0) return true;
        int psLen = pushed.length;
        int ppLen = popped.length;
        int flagIdx = 0;
        int headNum = popped[flagIdx];
        int psFlag = 0;
        while (psFlag < psLen) {
            if(pushed[psFlag] == headNum && flagIdx != psFlag) break;
            if(pushed[psFlag] == headNum && flagIdx == psFlag) {
                headNum = popped[++flagIdx];
            }
            ++psFlag;
        }
        int ppFlag = 0;
        while (psFlag < psLen) {
            for (int j = 0; j < ppLen; ++j) {
                if (pushed[psFlag] == popped[j]) {
                    ppFlag = j > ppFlag ? j : ppFlag;
                    break;
                }
            }
            ++psFlag;
        }
        int idxVal = popped[++ppFlag];
        for(int t = 0; t < psLen; ++t) {
            if(pushed[t] == idxVal) {
                psFlag = t;
                break;
            }
        }
            for (int k = ppFlag, m = psFlag; k < ppLen && m >=0; ++k, --m) {
            if(popped[k] != pushed[m]) return false;
        }
        return true;
    }
}
