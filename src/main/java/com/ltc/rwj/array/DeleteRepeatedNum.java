package com.ltc.rwj.array;

/**
 * @author rwj
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/all-about-array/x9a60t/
 * 来源：力扣（LeetCode）
 * @create_time 2021/5/8
 * @description
 */
public class DeleteRepeatedNum {

    /**
     * 别人的方法1，这个我感觉是最简洁的写法了。极美。
     *
     * @param nums
     * @return
     */
    public int others_1(int[] nums) {
        int tmp = Integer.MAX_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != tmp) {
                tmp = nums[i];
//                nums[count++] = tmp;
                nums[count] = tmp;
                count++;
            }
        }
        return count;
    }

    /**
     * 这个思路和最简洁的写法思路是一样的，但是写法有些拖沓。变量也过多，不够简洁美。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 0) {
            return 0;
        }
        int temp = nums[0];
        int k = 1;
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == temp) {
                j++;
            } else if (j >= 0 && nums[i] != temp) {
                nums[i - j] = nums[i];
                temp = nums[i];
                k++;
            }
        }
        return k;
    }

    /**
     * 执行用时：206 ms, 在所有 Java 提交中击败了5.00%的用户
     * 内存消耗：40.1 MB, 在所有 Java 提交中击败了81.64%的用户
     *
     * @param nums
     * @return
     */
    public int m_1(int[] nums) {
        int i = 1;
        int count = 0;
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2) {
            if (nums[0] == nums[1]) return 1;
            else return 2;
        }
        if (nums.length > 2) {
            do {
                if (nums[i] == nums[i - 1]) {
                    int tmp = nums[i];
                    for (int r = i; r < nums.length; r++) {
                        if (r == nums.length - 1) {
                            nums[r] = tmp;
                        } else {
                            nums[r] = nums[r + 1];
                        }
                    }
                    count++;
                } else {
                    i++;
                }
            } while (i + count < nums.length);
        }
        return i;
    }
}
