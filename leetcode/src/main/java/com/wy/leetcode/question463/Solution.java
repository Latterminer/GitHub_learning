package com.wy.leetcode.question463;

/**
 * @author wangyong
 * @date 2019/6/9
 * @description 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
 * <p>
 * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
 * <p>
 * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
 * <p>
 *  
 * <p>
 * 示例 :
 * <p>
 * 输入:
 * [[0,1,0,0],
 * [1,1,1,0],
 * [0,1,0,0],
 * [1,1,0,0]]
 * <p>
 * 输出: 16
 * <p>
 * 解释: 它的周长是下面图片中的 16 个黄色的边：
 */
public class Solution {
    public int islandPerimeter(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += edgeCount(grid, i, j);
                }
            }
        }
        return result;
    }

    private int edgeCount(int[][] grid, int row, int col) {
        int counter = 0;
        //top
        if (row == 0 || grid[row - 1][col] == 0) {
            counter++;
        }
        //bottom
        if (row == grid.length - 1 || grid[row + 1][col] == 0) {
            counter++;
        }
        //left
        if (col == 0 || grid[row][col - 1] == 0) {
            counter++;
        }
        //right
        if (col == grid[0].length - 1 || grid[row][col + 1] == 0) {
            counter++;
        }
        return counter;
    }
    /**
     * 方块总个数 * 4 - 相邻
     */
    public int islandPerimeter1(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int totalNum = 0, closeNum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    totalNum++;   // 计算贴近的,右下算
                    if (i + 1 < grid.length && grid[i + 1][j] == 1) {
                        closeNum++;
                    }
                    if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
                        closeNum++;
                    }
                }
            }
        }
        return totalNum * 4 - closeNum * 2;
    }

}
