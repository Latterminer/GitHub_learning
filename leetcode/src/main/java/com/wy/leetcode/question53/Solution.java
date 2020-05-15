package com.wy.leetcode.question53;

/**
 * @author wy
 * @date 2020/5/12
 * @description
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution {
    /**
     * 动态规划
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // 保存最大值
        int max = nums[0];
        // 保存当前值
        int pre = 0;
        for (int num : nums) {
            // 求当前最大值和
            pre = Math.max(pre + num, num);
            max = Math.max(pre, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Solution solution = new Solution();
        final int result = solution.maxSubArray(nums);
        System.out.println(result);
    }
}
