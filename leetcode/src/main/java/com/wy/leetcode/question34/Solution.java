package com.wy.leetcode.question34;

import java.util.Arrays;

/**
 * @author wy
 * @date 2020/4/25
 * @description
 */
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int left = 0;
        int rignt = nums.length - 1;
        if (nums.length <= 0) {
            return result;
        }
        int mid = -1;
        while (left <= rignt) {
            mid = (left + rignt) >> 1;
            if (nums[mid] == target) {
                break;
            }
            if (target < nums[mid]) {
                rignt = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[mid] == target) {
            left = mid;
            rignt = mid;
            while (left > 0 && nums[left] == nums[mid]) {
                left--;
            }
            while (rignt < nums.length - 1 && nums[rignt] == nums[mid]) {
                rignt++;
            }
            result[0] = left + 1;
            result[1] = rignt - 1;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        Solution solution = new Solution();
        final int[] ints = solution.searchRange(nums, 6);
        System.out.println(Arrays.toString(ints));
    }
}
