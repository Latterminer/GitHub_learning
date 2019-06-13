package com.wy.leetcode.question169;

import java.util.Arrays;

/**
 * @author wangyong
 * @date 2019/6/11
 * @description 求数组中出现次数超过一半的数
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     *
     *
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {
        int count = 0;
        int majorNum = 0;
        for (int ele : nums) {
            if (count == 0) {
                majorNum = ele;
            }
            if (majorNum == ele) {
                count++;
            } else {
                count--;
            }
        }
        return majorNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 3};
        System.out.println(majorityElement1(nums));
    }
}
