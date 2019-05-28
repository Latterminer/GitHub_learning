package com.wy.jianzhi_offer;

/**
 * @Description:    求数组中的元素相加的最大值，要求选取的元素不相邻
 * @Author:         wy
 * @CreateDate:     2019/1/12 9:10
 * @Version:        1.0
 */
public class MaxSumInArray {
    public static int getMaxSum(int[] array, int index){
//        int[] dp = new int[array.length];
        if (index == 0){
            return array[0];
        }
        if (index == 1){
            return Math.max(array[0], array[1]);
        }

//        for (int i = 2; i < array.length; i++){
        int a = array[index] + getMaxSum(array, index-2);
        int b = getMaxSum(array, index-1);
        return Math.max(a, b);
//        }
//        return dp[array.length-1];
    }

    public static int getMaxSumNonRec(int[] array){
        int[] dp = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++){
            dp[i] = Math.max(array[i] + dp[i-2], dp[i-1]);
        }
        return dp[array.length-1];
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 1, 7, 8, 3};
//        System.out.println(getMaxSum(array, array.length-1));
        System.out.println(getMaxSumNonRec(array));
    }
}
