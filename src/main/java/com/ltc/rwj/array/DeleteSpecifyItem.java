package com.ltc.rwj.array;

/**
 * @author rwj
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9p1iv/
 * 来源：力扣（LeetCode）
 * @create_time 2021/5/8
 * @description
 */
public class DeleteSpecifyItem {

    public int m1(int[] nums, int val) {
        int count = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == val) {
//                nums[i] = nums[count];
//                nums[count] = 0;
//                count--;
                nums[i] = nums[count--];
            }
        }
        return count + 1;
    }

}
