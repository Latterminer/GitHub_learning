package com.wy.leetcode.question33;

/**
 * @author wy
 * @date 2020/4/25
 * @description
 */
public class Solution {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边是递增
            // (nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid])
            if (nums[left] <= nums[mid]) {
                // 目标值是否在左边的范围内
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // 左边非递增
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        byte a = 1;

        char b = 'a';
        char c = 'z';
        int d =c - b;
        System.out.println(d);
    }
}
