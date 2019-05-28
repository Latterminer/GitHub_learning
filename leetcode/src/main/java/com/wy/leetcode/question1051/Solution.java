package com.wy.leetcode.question1051;

import java.util.Arrays;

/**
 * @author wy
 * @date 2019-05-28
 * @description 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * <p>
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 */
public class Solution {
    /**
     * 暴力解法
     *
     * @param heights
     * @return
     */
    public int heightChecker(int[] heights) {
        int[] referArray = Arrays.copyOf(heights, heights.length);
        Arrays.sort(referArray);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != referArray[i]) {
                count++;
            }
        }
        return count;
    }

    /**
     * 用字典
     *
     * @param heights
     * @return
     */
    public int heightChecker1(int[] heights) {
        int ret = 0;
        /*
        调度的取值为1~100，统计每个高度在heights中对应的个数
         */
        int[] map = new int[101];
        for (int i = 0; i < heights.length; i++) {
            map[heights[i]]++;
        }
        /*
        对heigths中的每一个元素和map数组的索引j进行比较，如果不同则说明位置需要调整
         */
        int j = 1;
        for (int i = 0; i < heights.length; i++) {
            while (map[j] == 0 && j <= 100) {
                j++;
            }
            if (j != heights[i]) {
                ret++;
            }
            map[j]--;
        }
        return ret;
    }
}
