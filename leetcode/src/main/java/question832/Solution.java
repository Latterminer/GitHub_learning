package question832;

import java.util.Arrays;

/**
 * @author wangyong
 * @date 2019/5/6
 * @description 图片水平翻转，然后每个数字取反
 */
public class Solution {
    public static int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0) {
            return null;
        }
        for (int i = 0; i < A.length; i++) {
            int cols = A[i].length;
            for (int j = 0; j < cols / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][cols - 1 - j] == 0 ? 1 : 0;
                A[i][cols - 1 - j] = temp == 0 ? 1 : 0;
            }
            if (cols%2!=0){
                A[i][cols/2]= A[i][cols/2]==0?1:0;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,0},{0,1}};
        flipAndInvertImage(A);
        System.out.println(Arrays.deepToString(A));
    }
}
