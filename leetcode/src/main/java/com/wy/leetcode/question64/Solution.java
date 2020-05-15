package com.wy.leetcode.question64;

/**
 * @author wy
 * @date 2020/5/14
 * @description
 * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 *
 * 说明：每次只能向下或者向右移动一步。
 *
 * 示例:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row <= 0) {
            return 0;
        }
        int col = grid[0].length;
        int[] path = new int[col];
        path[0] = grid[0][0];
        for (int i = 1; i < col; i++) {
            path[i] = path[i - 1] + grid[0][i];
        }

        for (int i =1; i< row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    path[j] = path[j] + grid[i][j];
                } else {
                    path[j] = Math.min(path[j - 1], path[j]) + grid[i][j];
                }
            }
        }
        return path[col - 1];
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}};
        Solution solution = new Solution();
        final int i = solution.minPathSum(grid);
        System.out.println(i);
    }
}
