package com.ltc.rwj.array;

/**
 * @author rwj
 *
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9nivs/
 * 来源：力扣（LeetCode）
 *
 * @create_time 2021/5/9
 * @description
 */
public class KeepTwoIdenticalItem {
    /**
     * 很巧妙的一个方法，把已被替换的位置前面的元素作为新数组，
     *      然后如果当前元素和新数组元素的倒数第二个元素不相等，那就替换。
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(index < 2 || nums[i] != nums[index-2]) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }

    /**
     * 我自己想着是给定一个变量，用来记录重复了几次，
     * 再给定一个变量，用来记录可替换位置
     *  然后条件合适的时候允许替换
     * @param nums
     * @return
     */
    public int m_1(int[] nums) {
        int n = nums.length;
        if(n <= 2) return n;
        int i = 1;//遍历索引，当前重复元素位置，和要替换的位置
        int k = i - 1;//当前元素的前一个元素
        int j = i + 1;//所有元素遍历索引
        //
        while(j <= n-1) {
            if(nums[j] != nums[i] || (nums[j] == nums[i] && nums[j] != nums[k])) {
                k = i;
                nums[i+1] = nums[j];
                i++;
            }
            j++;
        }
        return i+1;
    }
}
