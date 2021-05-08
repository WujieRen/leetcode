package com.rwj.ltc.array;

/**
 * @author rwj
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 说明：
 *  1. 必须在原数组上操作，不能拷贝额外的数组。
 *  2. 尽量减少操作次数。
 * @create_time 2021/5/8
 * @description
 */
public class RemoveZero {

    /**
     * 给定一个count，记下需要补值的下表，然后将不是0的移到上个补值的位置，后续把所有count个末尾的元素置零
     * 遍历元素，
     * @param nums
     */
    public void m_1(int[] nums) {
        int count = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                nums[count] = nums[i];
                count++;
            }
        }
        while (count < len) {
            nums[count] = 0;
            count++;
        }
    }
}
