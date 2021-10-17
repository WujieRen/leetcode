package com.ltc.wangzheng.sort;

/**
 * @author rwj
 * @create_time 2021/10/15
 * @description
 */
public class ReversePairs {

    //TODO: 超出时间限制
    public int reversePairs(int[] nums) {
        int len = nums.length, cnt = 0;
        for(int exter = 0; exter < len; ++exter) {
            for(int inter = exter + 1; inter < len; ++inter) {
                if(nums[inter] > nums[exter]) cnt++;
            }
        }
        return cnt;
    }
}
