package com.wy.leetcode.question79;

/**
 * @author wy
 * @date 2020/5/17
 * @description 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 */
public class Solution {
    private boolean[][] marked;
    private final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private String word;
    private char[][] board;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        this.word = word;
        cols = board[0].length;
        this.board = board;
        marked = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, int start) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }
        if (board[i][j] == word.charAt(start)) {
            this.marked[i][j] = true;
            for (int[] direction : directions) {
                int newR = i + direction[0];
                int newC = j + direction[1];
                if (isArea(newR, newC) && !marked[newR][newC]) {
                    if (dfs(newR, newC, start + 1)) {
                        return true;
                    }
                }
            }
            this.marked[i][j] = false;
        }
        return false;
    }

    private boolean isArea(int row, int col) {
        return row >= 0 && row < rows && col >= 0 & col < cols;

    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };

        String word = "ABCCED";


//        char[][] board = {{'a', 'b'}};
//        String word = "ba";
        Solution solution = new Solution();
        boolean exist = solution.exist(board, word);
        System.out.println(exist);
    }

}
