package com.wy.leetcode.question152;

/**
 * @author wy
 * @date 2020/5/14
 * @description
 */
public class Solution {
    public int maxProduct(int[] nums) {
        // 记录最大值，初始时需要设置为整数的最小值，因为当数组中只有一个负数存在时，这时候的最小值就是这个负数
        int max = Integer.MIN_VALUE;
        // 记录当前的最大和最小，在遇到0的时候会重新计算
        int currentMax = 1;
        int currentMin = 1;
        for (int num : nums) {
            // 如果是负数，最大值和最小值会反转，所以需要交换
            if (num < 0) {
                int tmp = currentMax;
                currentMax = currentMin;
                currentMin = tmp;
            }
            currentMax = Math.max(currentMax * num, num);
            currentMin = Math.min(currentMin * num, num);
            max = Math.max(currentMax, max);
        }
        return Math.max(currentMax, max);
    }
}
