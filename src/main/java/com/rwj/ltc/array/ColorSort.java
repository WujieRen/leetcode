package com.rwj.ltc.array;

/**
 * @author rwj
 * @create_time 2021/5/9
 * @description
 */
public class ColorSort {

    public void o_1(int[] nums) {
        int startPos, curIndex, endPos, tmp;
        startPos = curIndex = 0;
        endPos = nums.length;
        while(curIndex < endPos) {
            if(nums[curIndex] == 0) {
                tmp = nums[curIndex];
                nums[curIndex++] = nums[startPos];
                nums[startPos++] = tmp;
            }
            else if(nums[curIndex] == 2) {
                tmp = nums[curIndex];
                nums[curIndex] = nums[--endPos];
                nums[endPos] = tmp;
            }
            else {
                curIndex++;
            }
        }
    }

    /**
     *
     * @param nums
     */
    public void m_1(int[] nums) {
        int tmp;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }



}
