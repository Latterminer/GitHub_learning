package com.wy.jianzhi_offer;
/**
 * @Description:    剪绳子：1、动态动态规划；2、贪婪算法
 * @Author:         wy
 * @CreateDate:     2019/1/6 20:17
 * @Version:        1.0
 */
public class CutShengzi {
    public static int cutShengzi(int n){
        if (n == 0 || n == 1){
            return 0;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        for (int i = 4; i <= n; i++){
            int max = 0;
            for (int j = 1; j<= i/2; j++){
                int product = products[j]* products[i-j];
                if (product > max){
                    max = product;
                }
            }
            products[i] = max;
        }
        return products[n];
    }

    public static void main(String[] args) {
        System.out.println(cutShengzi(10));
    }
}
