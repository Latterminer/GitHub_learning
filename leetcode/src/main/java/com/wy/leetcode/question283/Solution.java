package com.wy.leetcode.question283;

/**
 * @author wangyong
 * @date 2019/6/19
 * @description
 */
public class Solution {
    public static void moveZeroes(int[] nums) {
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (j < len && i <= j) {
            while (i < len && nums[i] != 0) {
                i++;
            }
            while (j < len && nums[j] == 0) {
                j++;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(nums);
    }
}
