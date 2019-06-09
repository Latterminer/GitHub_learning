package com.wy.leetcode.question136;

import java.util.HashSet;

/**
 * @author wangyong
 * @date 2019/6/9
 * @description
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 示例 1:
 *
 * 输入: [2,2,1]
 * 输出: 1
 * 示例 2:
 *
 * 输入: [4,1,2,1,2]
 * 输出: 4
 */
public class Solution {
    /**
     * 暴力解法、hash表、异或运算
     * 异或运算：异或运算满足交换率和结合率，即：a^b^c=a^c^b; a^0=a,a^a=0下面用异或运算来求解
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    /**
     * hash table
     * @param nums
     * @return
     */
    public int singleNumber1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.remove(num)) {
                set.add(num);
            }
        }
        return set.iterator().next();
    }
}
