package com.wy.leetcode.question448;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wy
 * @date 2019-06-22
 * @description
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 */
public class Solution {
    /**
     * 不使用额外的空间，把num[i]和num[num[i]-1]处，假设数组序号0~n-1 应该放的是数字1~n，则遍历数组，将当前元素与其应该放的位置处的元素交换，知道该位置处放的是应该放的元素或者与交换处元素相等。
     * @param nums 列表
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[i] -1 == i || nums[nums[i]-1] == nums[i]) {
                i++;
            } else {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp-1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                result.add(i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(nums));
    }
}
