package com.wy.leetcode.question11;

/**
 * @author wy
 * @date 2020/3/26
 * @description 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 */
public class Solution {
    /**
     * 暴力解法
     *
     * @param height 高度数组
     * @return
     */
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = (j - i) * Math.min(height[i], height[j]);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    /**
     * 一遍遍历，双指针
     * @param height
     * @return
     */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            int area = Math.min(height[r], height[l]) * (r - l);
            if (area > maxArea) {
                maxArea = area;
            }
            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        final int i = solution.maxArea(heights);
        System.out.println(i);
    }
}
