package com.wy.jianzhi_offer;

public class MatrixPath {
    private int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public boolean havePath(char[][] matrix, int rows, int cols, String str){
        if (rows == 0 || cols == 0){
            return false;
        }
        boolean[][] flags = new boolean[rows][cols];
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (backSearch(matrix, flags, 0, i, j, str)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backSearch(char[][] matrix, boolean[][] flags, int pathLen, int row, int col, String str){
        if (pathLen == str.length()){
            return true;
        }
        if (row < 0 || col < 0 || matrix[row][col] != str.charAt(pathLen) || flags[row][col] == true){
            return false;
        }
        flags[row][col] = true;
        for (int[] n: next){
            if (backSearch(matrix, flags, pathLen+1, row+n[0], col+n[1], str)){
                return true;
            }
        }
        flags[row][col] = false;
        return false;
    }

    public static void main(String[] args) {

    }

}
