package com.wy.leetcode.question349;

import java.util.*;

/**
 * @author wangyong
 * @date 2019/6/3
 * @description
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 *
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 *
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // 确定数组 nums1 的取值范围
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums1) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        boolean[] arr = new boolean[max - min + 1];
        for (int num : nums1) {
            arr[num - min] = true;
        }

        // 判断数组 nums2 中的数是否在数组 nums1 中存在，
        // 如果存在保存在数组 tmp 中
        int[] tmp = new int[max - min + 1];
        int idx = 0;
        for (int num : nums2) {
            if (num >= min && num <= max && arr[num - min]) {
                tmp[idx++] = num;
                arr[num- min] = false;
            }
        }

        // 返回结果
        int[] ret = new int[idx];
        for (int i = 0; i < idx; i++) {
            ret[i] = tmp[i];
        }
        return ret;
    }
}
