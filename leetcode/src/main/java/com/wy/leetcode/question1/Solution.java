package com.wy.leetcode.question1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wy
 * @date 2020/3/19
 * @description
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class Solution {
    /**
     * 空间换时间，时间复杂度0（n）,借助哈希表
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int index = 0; index < nums.length; index++) {
            final int num = target - nums[index];
            if (map.containsKey(num) && map.get(num) != index) {
                return new int[]{map.get(num), index};
            }
            map.put(nums[index], index);
        }
        throw new IllegalArgumentException("No result");
    }
}
