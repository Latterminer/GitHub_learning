package com.wy.leetcode.question31;

import java.util.Arrays;

/**
 * @author wy
 * @date 2020/4/24
 * @description
 */
public class Solution {
    public void nextPermutation(int[] nums) {
        int j;
        for (j = nums.length - 1; j > 0; j--) {
            if (nums[j - 1] < nums[j]) {
                break;
            }
        }
        // 当整个数组是逆序
        if (j == 0) {
            reverse(nums, 0, nums.length - 1);
            System.out.println(Arrays.toString(nums));
            return;
        }
        int smaller = nums[j - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > smaller) {
                swapNum(nums, i, j - 1);
                break;
            }
        }

        reverse(nums, j, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swapNum(nums, start, end);
            start++;
            end--;
        }
    }

    private void swapNum(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{3, 2, 1});
    }
}
