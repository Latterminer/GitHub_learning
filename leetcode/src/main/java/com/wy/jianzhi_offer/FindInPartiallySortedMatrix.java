package com.wy.jianzhi_offer;

public class FindInPartiallySortedMatrix {
    public static boolean findNum(int[][] matrix, int target) {
        int cols = matrix[0].length;
        int rows = matrix.length;
        if (cols >= 0 && rows >= 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && cols > 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    row++;
                } else {
                    col--;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(FindInPartiallySortedMatrix.findNum(matrix, 99));

    }
}
