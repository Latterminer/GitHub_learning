package com.wy.leetcode.question62;

import java.util.Arrays;

/**
 * @author wangyong
 * @date 2019/6/12
 * @description 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * <p>
 * 问总共有多少条不同的路径？
 * 输入: m = 3, n = 2
 * 输出: 3
 * 解释:
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向右 -> 向下
 * 2. 向右 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向右
 * 示例 2:
 * <p>
 * 输入: m = 7, n = 3
 * 输出: 28
 */
public class Solution {
    /**
     * 递归解法
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        return findPath(0, 0, m, n);
    }

    private int findPath(int row, int col, int m, int n) {
        if (row > m || col > n) {
            return 0;
        }
        if (row == m - 1 && col == n - 1) {
            return 1;
        }
        return findPath(row + 1, col, m, n) + findPath(row, col + 1, m, n);
    }

    /**
     * 动态规划解法
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        int[][] paths = new int[m][n];
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            paths[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    /**
     * 优化空间复杂度O(n)
     * 当一行遍历结束，对于下一行来说cur数组中保存的是上一行中每个方格可以到达的次数
     *
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths2(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths2(3, 7));
    }
}
